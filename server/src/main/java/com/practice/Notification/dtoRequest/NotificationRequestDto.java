package com.practice.Notification.dtoRequest;

import com.practice.Notification.dtoResponse.NotificationUserRequestDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "")
public class NotificationRequestDto {
    private Long id;
    private String typeNotification;
    private String message;
    private Boolean isRead;
    private List<NotificationUserRequestDto> user;
}
