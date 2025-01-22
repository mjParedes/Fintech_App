package com.practice.config;

import com.practice.FinancingProfile.dtoRequest.FinancingProfileRequestDto;
import com.practice.FinancingProfile.dtoResponse.FinancingProfileResponseDto;
import com.practice.FinancingProfile.model.FinancingProfileModel;
import com.practice.Portfolio.dtoRequest.PortfolioRequestDto;
import com.practice.Portfolio.dtoResponse.PortfolioResponseDto;
import com.practice.Portfolio.model.PortfolioModel;
import com.practice.Transactions.dtoResponse.TransactionResponseDto;
import com.practice.Transactions.model.TransactionModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                .setMatchingStrategy(MatchingStrategies.STRICT);

        // Mapeo personalizado: PortfolioModel -> PortfolioResponseDto
        modelMapper.typeMap(PortfolioModel.class, PortfolioResponseDto.class).addMappings(mapper -> {
            mapper.map(src -> src.getUser().getId(), PortfolioResponseDto::setUserId);
        });

        // Mapeo personalizado: PortfolioRequestDto -> PortfolioModel
        modelMapper.typeMap(PortfolioRequestDto.class, PortfolioModel.class).addMappings(mapper -> {
            mapper.skip(PortfolioModel::setId);
        });

        //--------------------------------------------------------------------------------------------

        //Mapeo personalizado: TransactionModel -> TransactionResponseDto
        modelMapper.typeMap(TransactionModel.class, TransactionResponseDto.class).addMappings(mapper -> {
            mapper.map(src -> src.getPortfolio().getId(), TransactionResponseDto::setPortfolioId);
        });

        //Mapeo personalizado: TransactionResponseDto -> TransactionModel
        modelMapper.typeMap(TransactionResponseDto.class,TransactionModel.class).addMappings(mapper -> {
            mapper.skip(TransactionModel::setId);
        });

        //--------------------------------------------------------------------------------------------

        //Mapeo personalizado: FinancingProfileModel -> FinancingProfileResponseDto
        modelMapper.typeMap(FinancingProfileModel.class, FinancingProfileResponseDto.class).addMappings(mapper -> {
            mapper.map(src -> src.getUser().getId(), FinancingProfileResponseDto::setUserId);
        });

        //Mapeo personalizado: FinancingProfileRequestDto -> FinancingProfileModel
        modelMapper.typeMap(FinancingProfileRequestDto.class, FinancingProfileModel.class).addMappings(mapper -> {
            mapper.skip(FinancingProfileModel::setId);
        });


        return modelMapper;
    }
}

