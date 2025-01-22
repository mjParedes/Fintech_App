package com.practice.Portfolio.mappers;

import com.practice.Portfolio.dtoRequest.PortfolioRequestDto;
import com.practice.Portfolio.dtoResponse.PortfolioResponseDto;
import com.practice.Portfolio.model.PortfolioModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;



@Component
public class PortfolioMapper {

    public static PortfolioResponseDto toDto(PortfolioModel portfolio, ModelMapper modelMapper) {
        return modelMapper.map(portfolio, PortfolioResponseDto.class);
    }

    public static PortfolioModel toEntity(PortfolioRequestDto dto, ModelMapper modelMapper) {
        return modelMapper.map(dto, PortfolioModel.class);
    }
}