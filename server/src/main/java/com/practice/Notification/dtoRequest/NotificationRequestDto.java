package com.practice.Notification.dtoRequest;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record NotificationRequestDto(
        @NotBlank(message = "El tipo de notificacion es obligatorio") List<String>  type_notification,
        @NotBlank(message = "El mensaje es obligatorio") String message,
        @NotBlank(message = "Campo leido marcar correctamente") Boolean isRead) {
}
