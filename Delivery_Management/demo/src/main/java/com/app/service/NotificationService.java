
package com.app.service;

import com.app.model.Notification;
import com.app.model.User;
import com.app.repo.NotificationRepository;
import com.app.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationService {
    
    private final NotificationRepository notificationRepository;
    private final UserRepository userRepository;

    // Get all notifications for a user
    public List<Notification> getNotifications(Long userId) {
        return notificationRepository.findByUserId(userId);
    }

    // Get unread notifications count
    public Long getUnreadCount(Long userId) {
        return notificationRepository.countByUserIdAndIsReadFalse(userId);
    }

    // Mark a notification as read
    public void markAsRead(Long notificationId) {
        Notification notification = notificationRepository.findById(notificationId)
                .orElseThrow(() -> new RuntimeException("Notification not found"));
        notification.setRead(true);
        notificationRepository.save(notification);
    }

    // Mark all notifications as read
    public void markAllAsRead(Long userId) {
        List<Notification> notifications = notificationRepository.findByUserId(userId);
        notifications.forEach(notification -> notification.setRead(true));
        notificationRepository.saveAll(notifications);
    }

    // Delete a notification
    public void deleteNotification(Long notificationId) {
        notificationRepository.deleteById(notificationId);
    }

    // Create and save a new notification
    public void createNotification(Long userId, String message) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Notification notification = new Notification();
        notification.setUser(user);
        notification.setMessage(message);
        notification.setRead(false);
        notificationRepository.save(notification);
    }
}
