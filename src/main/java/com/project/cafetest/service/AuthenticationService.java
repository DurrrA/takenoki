package com.project.cafetest.service;

import com.project.cafetest.JWT.JWTService;
import com.project.cafetest.model.AuthenticationRespone;
import com.project.cafetest.model.Token;
import com.project.cafetest.model.User;
import com.project.cafetest.repository.TokenRepo;
import com.project.cafetest.repository.UserRepo;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthenticationService {


    private final UserRepo userRepo;

    private final JWTService jwtService;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;
    private final TokenRepo tokenRepo;

    public AuthenticationService(UserRepo userRepo, JWTService jwtService, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, TokenRepo tokenRepo) {
        this.userRepo = userRepo;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.tokenRepo = tokenRepo;
    }



    public AuthenticationRespone register(User request) {
        if (userRepo.findByUsername(request.getUsername()).isPresent()) {
            return new AuthenticationRespone(null, "Username is already taken");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());
        user = userRepo.save(user);

        String jwt = jwtService.generateToken(user);

        saveUserToken(jwt, user);
        return new AuthenticationRespone(jwt, "User registered successfully");
    }

    public AuthenticationRespone authenticate(User request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        Optional<User> optionalUser = userRepo.findByUsername(request.getUsername());
        if (optionalUser.isEmpty()) {
            return new AuthenticationRespone(null, "User not found");
        }

        User user = optionalUser.get();
        String jwt = jwtService.generateToken(user);
        revokeUserToken(user);
        saveUserToken(jwt, user);
        return new AuthenticationRespone(jwt, "User authenticated successfully");
    }

    private void revokeUserToken(User user) {
        List<Token> validTokens = tokenRepo.findAllTokenByUser(user.getId());
        if (validTokens.isEmpty()) {
            return;
        }

        validTokens.forEach(token -> {
            token.setLoggedOut(true);
        });

        tokenRepo.saveAll(validTokens);
    }

    private void saveUserToken(String jwt, User user) {
        Token token = new Token();
        token.setToken(jwt);
        token.setUser(user);
        tokenRepo.save(token);
    }
}
