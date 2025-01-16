package com.practice.Notification.mappers;

import com.practice.Notification.dtoRequest.NotificationRequestDto;
import com.practice.Notification.model.NotificationModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class NotificationMapper {
    private final ModelMapper modelMapper;


    public NotificationMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public NotificationRequestDto toDto(NotificationModel notificationModel) {
        return modelMapper.map(notificationModel, NotificationRequestDto.class);
    }


}
