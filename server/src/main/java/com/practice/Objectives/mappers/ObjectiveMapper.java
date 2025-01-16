package com.practice.Objectives.mappers;

import com.practice.Objectives.dtoRequest.ObjectivesRequestDto;
import com.practice.Objectives.model.ObjectiveModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ObjectiveMapper {
    private final ModelMapper modelMapper;

    public ObjectiveMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ObjectiveModel toEntity(ObjectivesRequestDto dto) {
        return modelMapper.map(dto, ObjectiveModel.class);
    }

    public ObjectivesRequestDto toDto(ObjectiveModel objective) {
        return modelMapper.map(objective, ObjectivesRequestDto.class);
    }

}
