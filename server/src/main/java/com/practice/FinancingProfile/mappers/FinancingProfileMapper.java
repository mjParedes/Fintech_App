package com.practice.FinancingProfile.mappers;

import com.practice.FinancingProfile.dtoRequest.FinancingProfileRequestDto;
import com.practice.FinancingProfile.model.FinancingProfileModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class FinancingProfileMapper {
    private final ModelMapper modelMapper;

    public FinancingProfileMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public FinancingProfileRequestDto toDto(FinancingProfileModel profileModel) {
        return modelMapper.map(profileModel, FinancingProfileRequestDto.class);
    }


}
