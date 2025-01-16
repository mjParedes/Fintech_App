package com.practice.Notification.service;

import com.practice.Notification.dtoRequest.NotificationRequestDto;
import com.practice.Notification.dtoResponse.NotificationResponseDto;
import com.practice.Notification.model.NotificationModel;

import java.util.List;

public interface NotificationService {
    NotificationResponseDto findAllNotification(int page, int size);

}
