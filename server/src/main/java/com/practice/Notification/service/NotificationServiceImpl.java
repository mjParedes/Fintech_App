package com.practice.Notification.service;

import com.practice.Notification.dtoRequest.NotificationRequestDto;
import com.practice.Notification.dtoResponse.NotificationPageResponseDto;
import com.practice.Notification.dtoResponse.NotificationResponseDto;
import com.practice.Notification.mappers.NotificationMapper;
import com.practice.Notification.model.NotificationModel;
import com.practice.Notification.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;
    private final NotificationMapper notificationMapper;

    @Override
    public NotificationPageResponseDto findAllNotification(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        Page<NotificationModel> notificationPage = notificationRepository.findAll(pageable);

        List<NotificationRequestDto> notificationDtos = notificationPage.getContent()
                .stream()
                .map(notificationMapper::toDto)
                .collect(Collectors.toList());

        return new NotificationPageResponseDto(notificationDtos, notificationPage.getTotalPages(), notificationPage.getTotalElements());
    }

    @Override
    public NotificationResponseDto getNotificationById(Long id) {
        NotificationModel notificationModel = notificationRepository.findById(id).orElseThrow();
        return notificationMapper.toDtoNotification(notificationModel);
    }
}