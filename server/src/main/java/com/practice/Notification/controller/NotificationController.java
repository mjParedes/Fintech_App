package com.practice.Notification.controller;

import com.practice.Notification.dtoRequest.NotificationRequestDto;
import com.practice.Notification.dtoResponse.NotificationResponseDto;
import com.practice.Notification.model.NotificationModel;
import com.practice.Notification.service.NotificationServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name = "Notification")
@RequiredArgsConstructor
public class NotificationController {
    private final NotificationServiceImpl notificationServiceImpl;

    @GetMapping("/")
    public ResponseEntity<List<NotificationModel>> getAllNotification() {
        var response = notificationServiceImpl.findAllNotification();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
