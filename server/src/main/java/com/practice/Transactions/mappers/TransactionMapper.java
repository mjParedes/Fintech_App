package com.practice.Transactions.mappers;

import com.practice.Portfolio.model.PortfolioModel;
import com.practice.Transactions.dtoRequest.TransactionRequestDto;
import com.practice.Transactions.dtoResponse.TransactionPortfolioInfoDto;
import com.practice.Transactions.dtoResponse.TransactionResponseDto;
import com.practice.Transactions.model.TransactionModel;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;


@Component
@RequiredArgsConstructor
public class TransactionMapper {


    public static TransactionResponseDto toDtoTransaction(TransactionModel transactionModel, ModelMapper modelMapper) {
        return modelMapper.map(transactionModel, TransactionResponseDto.class);
    }


    public static TransactionModel toEntity(TransactionRequestDto dto, ModelMapper modelMapper) {
        return modelMapper.map(dto, TransactionModel.class);
    }
}
