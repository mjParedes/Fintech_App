package com.practice.Notification.repository;

import com.practice.Notification.model.NotificationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<NotificationModel, Long> {
}
