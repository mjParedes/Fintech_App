package com.practice.Notification.dtoResponse;

import java.time.LocalDateTime;

public record NotificationResponseDto(Long id,
                                      String type_notification,
                                      String message,
                                      Boolean isRead,
                                      LocalDateTime dateCreate) {
}
