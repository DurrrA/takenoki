package com.project.cafetest.controller;


import com.project.cafetest.model.AuthenticationRespone;
import com.project.cafetest.model.User;
import com.project.cafetest.service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.servlet.function.ServerResponse.ok;


@RestController
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/api/register")
    public ResponseEntity<AuthenticationRespone> register(@RequestBody User request) {
        return ResponseEntity.ok(authenticationService.register(request));
    }
    @PostMapping("/api/authenticate")
    public ResponseEntity<AuthenticationRespone> authenticate(@RequestBody User request) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}
