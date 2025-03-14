package com.app.controller;

import com.app.model.User;
import com.app.service.UserService;
import com.app.utility.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    // ✅ Get all users (Admins only)
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(HttpServletRequest request) {
        if (!isAuthorized(request, "ADMIN")) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN); // 403 if not an admin
        }

        List<User> users = userService.getAllUsers();
        return users.isEmpty()
                ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(users, HttpStatus.OK);
    }

    // ✅ Get a user by ID (Any authenticated user)
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id, HttpServletRequest request) {
        if (!isAuthenticated(request)) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        Optional<User> user = userService.getUserById(id);
        return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // ✅ Update user details (Admins only)
    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody User user, HttpServletRequest request) {
        if (!isAuthorized(request, "ADMIN")) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        String response = userService.updateUser(id, user);
        return response.equals("User not found!")
                ? new ResponseEntity<>(response, HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(response, HttpStatus.OK);
    }

    // ✅ Delete a user (Admins only)
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id, HttpServletRequest request) {
        if (!isAuthorized(request, "ADMIN")) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        String response = userService.deleteUser(id);
        return response.equals("User not found!")
                ? new ResponseEntity<>(response, HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(response, HttpStatus.OK);
    }

    // ✅ Helper method to extract token
    private String extractToken(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        return (authHeader != null && authHeader.startsWith("Bearer ")) ? authHeader.substring(7) : null;
    }

    // ✅ Check if Token is Valid
    private boolean isAuthenticated(HttpServletRequest request) {
        String token = extractToken(request);
        if (token == null) return false;

        try {
            String username = jwtUtil.extractUsername(token);
            return jwtUtil.validateToken(token, username);
        } catch (Exception e) {
            return false;
        }
    }

    // ✅ Check if User is Admin
    private boolean isAuthorized(HttpServletRequest request, String requiredRole) {
        String token = extractToken(request);
        if (token == null) return false;

        try {
            String username = jwtUtil.extractUsername(token);
            String role = jwtUtil.extractRole(token);
            return jwtUtil.validateToken(token, username) && role.equals(requiredRole);
        } catch (Exception e) {
            return false;
        }
    }
}

