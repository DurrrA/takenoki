package com.project.cafetest.model;

public class AuthenticationRespone {
    private String token;
    private String message;

    public AuthenticationRespone(String token, String message) {
        this.token = token;
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public String getMessage() {
        return message;
    }
}
