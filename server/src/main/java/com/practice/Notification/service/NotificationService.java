package com.practice.Notification.service;

import com.practice.Notification.dtoResponse.NotificationPageResponseDto;
import com.practice.Notification.dtoResponse.NotificationResponseDto;

public interface NotificationService {
    NotificationPageResponseDto findAllNotification(int page, int size);

    NotificationResponseDto getNotificationById(Long id);

}
