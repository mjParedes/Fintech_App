package com.practice.Notification.dtoResponse;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NotificationResponseDto {
    private Long id;
    private String type;
    private String message;
    private Boolean isRead;
    private NotificationUserRequestDto user;

}
