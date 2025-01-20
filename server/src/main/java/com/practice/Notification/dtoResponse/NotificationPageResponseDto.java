package com.practice.Notification.dtoResponse;

import com.practice.Notification.dtoRequest.NotificationRequestDto;

import java.util.List;

public record NotificationPageResponseDto(
        List<NotificationRequestDto> notificationDtos,
        int page, long totalElement
) {
}
