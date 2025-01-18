package com.practice.Notification.dtoRequest;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "")
public class NotificationRequestDto {
    private Long id;
    private String typeNotification;
    private String message;
    private Boolean isRead;
    private Long userId;
}
