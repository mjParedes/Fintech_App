package com.practice.Notification.controller;

import com.practice.Notification.dtoRequest.NotificationCreateRequestDto;
import com.practice.Notification.dtoRequest.NotificationUpdateRequestDto;
import com.practice.Notification.dtoResponse.NotificationCreateResponseDto;
import com.practice.Notification.dtoResponse.NotificationPageResponseDto;

import com.practice.Notification.dtoResponse.NotificationResponseDto;
import com.practice.Notification.dtoResponse.NotificationUserRequestDto;
import com.practice.Notification.service.NotificationServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/notification")
@RequiredArgsConstructor
@Tag(name = "Notificación", description = "Notification API")
public class NotificationController {
    private final NotificationServiceImpl notificationServiceImpl;

    @Operation(summary = "Obtener todas las notificaciones", description = "Devuelve todas las notificaciones")
    @ApiResponse(responseCode = "200", description = "Notificaciones obtenidas correctamente")
    @ApiResponse(responseCode = "404", description = "no se encontraron Notificaciones")
    @GetMapping("/")
    public ResponseEntity<NotificationPageResponseDto> findAllNotification(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        NotificationPageResponseDto response = notificationServiceImpl.findAllNotification(page, size);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Obtener notificacion por ID", description = "Devuelve una notificacion por ID")
    @ApiResponse(responseCode = "200", description = "Notificación obtenida correctamente")
    @ApiResponse(responseCode = "404", description = "Notificación no encontrada")
    @GetMapping("/{id}")
    public ResponseEntity<NotificationResponseDto> getNotificationBy(@PathVariable Long id) {
        NotificationResponseDto notification = notificationServiceImpl.getNotificationById(id);
        return ResponseEntity.ok(notification);
    }

    @Operation(summary = "Obtener notificacion por ID", description = "Devuelve una notificacion por ID")
    @ApiResponse(responseCode = "200", description = "Notificación obtenida correctamente")
    @ApiResponse(responseCode = "404", description = "Notificación no encontrada")
    @Transactional
    @PatchMapping("/{id}")
    public ResponseEntity<NotificationResponseDto> updateNotification(@PathVariable Long id, @RequestBody @Validated NotificationUpdateRequestDto notificationUpdateRequestDto) {
        NotificationResponseDto updateNotification = notificationServiceImpl.updateNotification(id, notificationUpdateRequestDto);
        return new ResponseEntity<>(updateNotification, HttpStatus.OK);
    }

    @Operation(summary = "Guardar una Notificación", description = "Guarda una notificación")
    @ApiResponse(responseCode = "200", description = "Notificación guardada correctamente")
    @ApiResponse(responseCode = "404", description = "ERROR al guardar una notificación ")
    @PostMapping("/create")
    @Transactional
    public ResponseEntity<NotificationCreateResponseDto> createNotification(@RequestBody @Validated NotificationCreateRequestDto notificationCreateRequestDto) {
        NotificationCreateResponseDto response =
                notificationServiceImpl.createNotification(notificationCreateRequestDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Operation(summary = "Eliminar notification por ID", description = "Elimina una notification por ID")
    @ApiResponse(responseCode = "200", description = "Notificación eliminada correctamente")
    @ApiResponse(responseCode = "404", description = "Notificación no eliminada ")
    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotification(@PathVariable Long id) {
        notificationServiceImpl.deleteNotification(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
