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
    private final ModelMapper modelMapper;

    public TransactionRequestDto toDto(TransactionModel transactionModel) {
        if (transactionModel == null) {
            return null;
        }
//        TransactionRequestDto dto = modelMapper.map(transactionModel,TransactionRequestDto.class);
        TransactionRequestDto dto = new TransactionRequestDto();
        dto.setId(transactionModel.getId());
        dto.setTransactionType(String.valueOf(transactionModel.getEnumTransactionType()));
        dto.setUnitPrice(transactionModel.getUnitPrice());
        dto.setQuantity(transactionModel.getQuantity());
        dto.setCommission(transactionModel.getCommission());

        TransactionPortfolioInfoDto portfolioInfo = toDtoTransactionPortfolio(transactionModel.getPortfolio());
        List<TransactionPortfolioInfoDto> portfolioInfoList = Collections.singletonList(portfolioInfo);
        dto.setPortfolio(portfolioInfoList);
        return dto;
    }


    public TransactionResponseDto toDtoTransaction(TransactionModel transactionModel) {
        if (transactionModel == null) {
            return null;
        }

        TransactionResponseDto dto = modelMapper.map(transactionModel, TransactionResponseDto.class);

        dto.setPortfolio(toDtoTransactionPortfolio(transactionModel.getPortfolio()));
        return dto;
    }


    private TransactionPortfolioInfoDto toDtoTransactionPortfolio(PortfolioModel portfolioModel) {
        if (portfolioModel == null) {
            return null;
        }
        return TransactionPortfolioInfoDto.builder().id(portfolioModel.getId()).quantity(portfolioModel.getQuantity()).priceBuy(portfolioModel.getPriceBuy()).build();
    }
}
