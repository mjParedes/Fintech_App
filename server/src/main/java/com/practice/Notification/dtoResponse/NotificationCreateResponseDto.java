package com.practice.Notification.dtoResponse;

public record NotificationCreateResponseDto(
        Long id,
        String typeNotification,
        String message,
        Boolean isRead,
        Long idUser
) {
}
