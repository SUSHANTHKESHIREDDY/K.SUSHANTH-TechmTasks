package com.app.service;


import com.app.dto.LoginRequest;
import com.app.model.User;
import com.app.repo.UserRepository;
import com.app.utility.JwtUtil;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public Map<String, Object> login(String email, String password) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        String roleAsString = user.getRole().name();
        String token = jwtUtil.generateToken(user.getUsername(), roleAsString);

        // Prepare response
        Map<String, Object> response = new HashMap<>();
        response.put("token", token);
        response.put("role", roleAsString);
        response.put("user", user);  // ✅ Send full user object

        return response;
    }




    public User register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
