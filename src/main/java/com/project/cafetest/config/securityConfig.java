package com.project.cafetest.config;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import com.project.cafetest.service.UserDetailService;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.project.cafetest.filter.JwtAuthenticationFilter;
import com.project.cafetest.service.logoutHandler;


@Configuration
@EnableWebSecurity
public class securityConfig {


    private final JwtAuthenticationFilter JwtAuthenticationFilter;
    private final UserDetailService UserDetailService;

    private final logoutHandler logoutHandler;


    public securityConfig(JwtAuthenticationFilter jwtAuthenticationFilter, UserDetailService userDetailService, com.project.cafetest.service.logoutHandler logoutHandler) {
        this.JwtAuthenticationFilter = jwtAuthenticationFilter;
        this.UserDetailService = userDetailService;
        this.logoutHandler = logoutHandler;
    }

    @Bean
    public SecurityFilterChain SecurityfilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(reg-> reg
                        .requestMatchers("/api/newsletter/get**", "/api/menu/get**", "/api/aboutus**").permitAll()
                        .requestMatchers("/api/feedback/posting**").permitAll()
                        .requestMatchers("/api/authenticate/**","/api/register/**").permitAll()
                        .anyRequest().authenticated())
                .userDetailsService(UserDetailService).sessionManagement(
                        session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(JwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling(
                        e -> e.accessDeniedHandler(
                                        (request, response, accessDeniedException) -> response.setStatus(403))
                                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)))
                .logout(l->l
                        .logoutUrl("/logout")
                        .addLogoutHandler(logoutHandler)
                        .logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext()
                        ))
                .build();
    }



    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }



}