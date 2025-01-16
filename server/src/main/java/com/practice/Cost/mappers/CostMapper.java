package com.practice.Cost.mappers;


import com.practice.Cost.dtoRequest.CostRequestDto;
import com.practice.Cost.model.CostModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CostMapper {
    private final ModelMapper modelMapper;


    public CostMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public CostRequestDto toDto(CostModel costModel) {
        return modelMapper.map(costModel, CostRequestDto.class);
    }


}
