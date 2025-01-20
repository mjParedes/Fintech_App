package com.practice.Notification.mappers;

import com.practice.Notification.dtoRequest.NotificationRequestDto;
import com.practice.Notification.dtoResponse.NotificationResponseDto;
import com.practice.Notification.dtoResponse.NotificationUserRequestDto;
import com.practice.Notification.model.NotificationModel;
import com.practice.User.model.UserModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class NotificationMapper {
    private final ModelMapper modelMapper;


    public NotificationMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public NotificationRequestDto toDto(NotificationModel notificationModel) {
        if (notificationModel == null) {
            return null;
        }
        NotificationRequestDto dto = new NotificationRequestDto();
        dto.setId(notificationModel.getId());
        dto.setTypeNotification(String.valueOf(notificationModel.getType()));
        dto.setMessage(notificationModel.getMessage());
        dto.setIsRead(notificationModel.getIsRead());
        NotificationUserRequestDto userInfo = toNotificationUserResponseDto(notificationModel.getUser());
        List<NotificationUserRequestDto> userInfoList = Collections.singletonList(userInfo);
        dto.setUser(userInfoList);
        return dto;
    }


    public NotificationResponseDto toDtoNotification(NotificationModel notificationModel) {
        if (notificationModel == null) {
            return null;
        }
        NotificationResponseDto dto = modelMapper.map(notificationModel, NotificationResponseDto.class);
        dto.setUser(toNotificationUserResponseDto(notificationModel.getUser()));
        return dto;
    }

    private NotificationUserRequestDto toNotificationUserResponseDto(UserModel userModel) {
        if (userModel == null) {
            return null;
        }
        return NotificationUserRequestDto.builder()
                .id(userModel.getId())
                .id(userModel.getId())
                .photoUrl(userModel.getPhotoUrl())
                .email(userModel.getEmail())
                .name(userModel.getName())
                .lastName(userModel.getLastName())
                .phoneNumber(userModel.getPhoneNumber())
                .birthDate(userModel.getBirthDate())
                .build();
    }

}
