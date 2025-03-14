package com.app.repo;



import com.app.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByUserId(Long userId);  // Get all notifications for a specific user
    Long countByUserIdAndIsReadFalse(Long userId);   // Get unread notification count
}
