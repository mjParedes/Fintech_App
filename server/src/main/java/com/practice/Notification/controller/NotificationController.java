package com.practice.Notification.controller;

import com.practice.Notification.dtoResponse.NotificationPageResponseDto;

import com.practice.Notification.dtoResponse.NotificationResponseDto;
import com.practice.Notification.dtoResponse.NotificationUserRequestDto;
import com.practice.Notification.service.NotificationServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/notification")
@RequiredArgsConstructor
@Tag(name = "Notificación", description = "Notification API")
public class NotificationController {
    private final NotificationServiceImpl notificationServiceImpl;

    @GetMapping("/")
    public ResponseEntity<NotificationPageResponseDto> findAllNotification(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        NotificationPageResponseDto response = notificationServiceImpl.findAllNotification(page, size);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotificationResponseDto> getNotificationBy(@PathVariable Long id) {
        NotificationResponseDto notification = notificationServiceImpl.getNotificationById(id);
        return ResponseEntity.ok(notification);
    }
}
