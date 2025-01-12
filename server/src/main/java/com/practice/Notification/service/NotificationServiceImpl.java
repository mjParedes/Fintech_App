package com.practice.Notification.service;

import com.practice.Notification.Enum.EnumTypeNotification;
import com.practice.Notification.dtoRequest.NotificationRequestDto;
import com.practice.Notification.dtoResponse.NotificationResponseDto;
import com.practice.Notification.model.NotificationModel;
import com.practice.Notification.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;

    @Override
    public List<NotificationModel> findAllNotification() {
        return notificationRepository.findAll();
    }

    @Override
    public NotificationResponseDto createNotification(NotificationRequestDto requestDto) {
        NotificationModel notificationModel = new NotificationModel();
        notificationModel.setType(EnumTypeNotification.valueOf(requestDto.type_notification().get(0)));
        notificationModel.setMessage(requestDto.message());
        notificationModel.setIsRead(requestDto.isRead());
        notificationModel.setDateCreate(LocalDateTime.now());
        NotificationModel savedNotificationModel = notificationRepository.save(notificationModel);
        return new NotificationResponseDto(
                savedNotificationModel.getId(),
                savedNotificationModel.getType().name(),
                savedNotificationModel.getMessage(),
                savedNotificationModel.getIsRead(),
                savedNotificationModel.getDateCreate()
        );
    }
}