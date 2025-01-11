package com.practice.User.mapper;

import com.practice.User.dtoRequest.UserRequestDto;
import com.practice.User.model.UserModel;
import org.springframework.stereotype.Component;
import org.modelmapper.ModelMapper;

@Component
public class UserMapper {

    private final ModelMapper modelMapper;

    public UserMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    // Mapea de DTO a entidad
    public UserModel toEntity(UserRequestDto dto) {
        return modelMapper.map(dto, UserModel.class);
    }

    // Mapea de entidad a DTO
    public UserRequestDto toDto(UserModel user) {
        return modelMapper.map(user, UserRequestDto.class);
    }
}
