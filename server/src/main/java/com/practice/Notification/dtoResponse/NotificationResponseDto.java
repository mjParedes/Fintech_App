package com.practice.Notification.dtoResponse;

import com.practice.Notification.dtoRequest.NotificationRequestDto;

import java.time.LocalDateTime;
import java.util.List;

public record NotificationResponseDto(
        List<NotificationRequestDto> notificationDtos,
        int page, long totalElement
) {
}
