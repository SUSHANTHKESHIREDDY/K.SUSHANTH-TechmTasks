package com.app.controller;

import com.app.model.Notification;
import com.app.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notifications")
@RequiredArgsConstructor
@CrossOrigin("*")
public class NotificationController {

    private final NotificationService notificationService;

    // ✅ Get notifications for the logged-in user (CUSTOMER, DRIVER, ADMIN)
    @GetMapping("/{userId}")
    @PreAuthorize("hasAnyRole('CUSTOMER', 'DRIVER', 'ADMIN')")
    public ResponseEntity<List<Notification>> getNotifications(@PathVariable Long userId) {
        return ResponseEntity.ok(notificationService.getNotifications(userId));
    }

    // ✅ Get unread notifications count (CUSTOMER, DRIVER, ADMIN)
    @GetMapping("/unread/count/{userId}")
    @PreAuthorize("hasAnyRole('CUSTOMER', 'DRIVER', 'ADMIN')")
    public ResponseEntity<Long> getUnreadCount(@PathVariable Long userId) {
        return ResponseEntity.ok(notificationService.getUnreadCount(userId));
    }

    // ✅ Mark a single notification as read (CUSTOMER, DRIVER, ADMIN)
    @PutMapping("/{notificationId}/read")
    @PreAuthorize("hasAnyRole('CUSTOMER', 'DRIVER', 'ADMIN')")
    public ResponseEntity<Void> markAsRead(@PathVariable Long notificationId) {
        notificationService.markAsRead(notificationId);
        return ResponseEntity.ok().build();
    }

    // ✅ Mark all notifications as read (CUSTOMER, DRIVER, ADMIN)
    @PutMapping("/{userId}/read-all")
    @PreAuthorize("hasAnyRole('CUSTOMER', 'DRIVER', 'ADMIN')")
    public ResponseEntity<Void> markAllAsRead(@PathVariable Long userId) {
        notificationService.markAllAsRead(userId);
        return ResponseEntity.ok().build();
    }

    // ✅ Delete a notification (CUSTOMER, DRIVER, ADMIN)
    @DeleteMapping("/{notificationId}")
    @PreAuthorize("hasAnyRole('CUSTOMER', 'DRIVER', 'ADMIN')")
    public ResponseEntity<Void> deleteNotification(@PathVariable Long notificationId) {
        notificationService.deleteNotification(notificationId);
        return ResponseEntity.ok().build();
    }

    // ✅ Create a notification (ADMIN ONLY)
    @PostMapping("/{userId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> createNotification(@PathVariable Long userId, @RequestBody String message) {
        notificationService.createNotification(userId, message);
        return ResponseEntity.ok().build();
    }
}
