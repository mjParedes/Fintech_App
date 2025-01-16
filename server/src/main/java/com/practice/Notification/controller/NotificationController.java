package com.practice.Notification.controller;

import com.practice.Notification.dtoResponse.NotificationResponseDto;

import com.practice.Notification.service.NotificationServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
//@RequestMapping("/api")
@RequiredArgsConstructor
@Tag(name = "Notificación", description = "Notification API")
public class NotificationController {
    private final NotificationServiceImpl notificationServiceImpl;

    @GetMapping("/notification")
    public ResponseEntity<NotificationResponseDto> findAllNotification(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
            ) {
        NotificationResponseDto response = notificationServiceImpl.findAllNotification(page, size);
        return ResponseEntity.ok(response);
    }
}
