package com.app.controller;

import com.app.model.Driver;
import com.app.service.DriverService;
import com.app.utility.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/drivers")
public class DriverController {

    private final DriverService driverService;
    private final JwtUtil jwtUtil;

    public DriverController(DriverService driverService, JwtUtil jwtUtil) {
        this.driverService = driverService;
        this.jwtUtil = jwtUtil;
    }

    // ✅ Admin-only: Get all drivers
    @GetMapping
    public ResponseEntity<?> getAllDrivers(HttpServletRequest request) {
        if (!isAdmin(request)) {
            return new ResponseEntity<>("Access Denied: Admins Only", HttpStatus.FORBIDDEN);
        }
        return ResponseEntity.ok(driverService.getAllDrivers());
    }

    // ✅ Public: Get available drivers
    @GetMapping("/available")
    public ResponseEntity<List<Driver>> getAvailableDrivers() {
        return ResponseEntity.ok(driverService.getAvailableDrivers());
    }

    // ✅ Admin-only: Get top-performing drivers
    @GetMapping("/top-performers")
    public ResponseEntity<?> getTopPerformingDrivers(@RequestParam(defaultValue = "10") int limit, HttpServletRequest request) {
        if (!isAdmin(request)) {
            return new ResponseEntity<>("Access Denied: Admins Only", HttpStatus.FORBIDDEN);
        }
        return ResponseEntity.ok(driverService.getTopPerformingDrivers(limit));
    }

    // ✅ Public: Get driver by ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Driver>> getDriverById(@PathVariable Long id) {
        return ResponseEntity.ok(driverService.getDriverById(id));
    }

    // ✅ Driver-only: Update location
    @PatchMapping("/{driverId}/location")
    public ResponseEntity<?> updateDriverLocation(
            @PathVariable Long driverId,
            @RequestParam double latitude,
            @RequestParam double longitude,
            HttpServletRequest request) {

        if (!isDriver(request)) {
            return new ResponseEntity<>("Access Denied: Drivers Only", HttpStatus.FORBIDDEN);
        }

        return ResponseEntity.ok(driverService.updateDriverLocation(driverId, latitude, longitude));
    }

    // ✅ Driver-only: Update availability
    @PatchMapping("/{driverId}/availability")
    public ResponseEntity<?> updateDriverAvailability(@PathVariable Long driverId, @RequestParam boolean isAvailable, HttpServletRequest request) {
        if (!isDriver(request)) {
            return new ResponseEntity<>("Access Denied: Drivers Only", HttpStatus.FORBIDDEN);
        }
        return ResponseEntity.ok(driverService.updateDriverAvailability(driverId, isAvailable));
    }

    // ✅ Utility methods for role checking
    private boolean isAdmin(HttpServletRequest request) {
        String token = extractToken(request);
        return "ADMIN".equals(jwtUtil.extractRole(token));
    }

    private boolean isDriver(HttpServletRequest request) {
        String token = extractToken(request);
        return "DRIVER".equals(jwtUtil.extractRole(token));
    }

    private String extractToken(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer ")) {
            return header.substring(7);
        }
        return null;
    }
}

