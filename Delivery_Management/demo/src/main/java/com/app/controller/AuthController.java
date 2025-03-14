package com.app.controller;

import com.app.dto.LoginRequest;
import com.app.model.*;
import com.app.service.AuthService;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/auth")
@RequiredArgsConstructor

public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody LoginRequest loginRequest) {
        Map<String, Object> response = authService.login(loginRequest.getEmail(), loginRequest.getPassword());
        return ResponseEntity.ok(response);
    }

    

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, Object> requestBody) {
        String role = (String) requestBody.get("role"); // Identify role

        if ("DRIVER".equalsIgnoreCase(role)) {
            // Convert request body to Driver object
            ObjectMapper mapper = new ObjectMapper();
            Driver driver = mapper.convertValue(requestBody, Driver.class);
            User registeredDriver = authService.register(driver);
            return ResponseEntity.ok(registeredDriver);
        } else {
            // Convert request body to User object
            ObjectMapper mapper = new ObjectMapper();
            User user = mapper.convertValue(requestBody, User.class);
            User registeredUser = authService.register(user);
            return ResponseEntity.ok(registeredUser);
        }
    }
}
