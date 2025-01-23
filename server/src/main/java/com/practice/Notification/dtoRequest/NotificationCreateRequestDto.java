package com.practice.Notification.dtoRequest;

public record NotificationCreateRequestDto(
        String typeNotification,
        String message,
        Boolean isRead,
        Long idUser
) {
}
