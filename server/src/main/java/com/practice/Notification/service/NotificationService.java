package com.practice.Notification.service;

import com.practice.Notification.dtoRequest.NotificationCreateRequestDto;
import com.practice.Notification.dtoRequest.NotificationUpdateRequestDto;
import com.practice.Notification.dtoResponse.NotificationCreateResponseDto;
import com.practice.Notification.dtoResponse.NotificationPageResponseDto;
import com.practice.Notification.dtoResponse.NotificationResponseDto;
import org.springframework.validation.annotation.Validated;

public interface NotificationService {
    NotificationPageResponseDto findAllNotification(int page, int size);

    NotificationResponseDto getNotificationById(Long id);

    NotificationCreateResponseDto createNotification(@Validated NotificationCreateRequestDto notificationCreateRequestDto);

    NotificationResponseDto updateNotification(Long id , @Validated NotificationUpdateRequestDto notificationUpdateRequestDto);

    void deleteNotification(Long id);

}
