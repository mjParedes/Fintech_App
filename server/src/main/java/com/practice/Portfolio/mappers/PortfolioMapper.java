package com.practice.Portfolio.mappers;

import com.practice.Portfolio.dtoRequest.PortfolioRequestDto;
import com.practice.Portfolio.model.PortfolioModel;
import com.practice.Transactions.dtoRequest.TransactionRequestDto;
import com.practice.Transactions.model.TransactionModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Component
public class PortfolioMapper {

    public PortfolioRequestDto toDto(PortfolioModel portfolioModel) {
        PortfolioRequestDto dto = new PortfolioRequestDto();
        dto.setId(portfolioModel.getId());
        dto.setQuantity(portfolioModel.getQuantity());
        dto.setPriceBuy(portfolioModel.getPriceBuy());
        dto.setUserId(portfolioModel.getUser().getId().toString());
        dto.setInstrumentId(portfolioModel.getInstrument().getId().toString());
//        dto.setTransactionModels(mapTransactions(new ArrayList<>(portfolioModel.getTransactionModels())));
        return dto;
    }

//    private List<TransactionRequestDto> mapTransactions(List<TransactionModel> transactionModels) {
//        return transactionModels.stream()
//                .map(this::mapTransaction)
//                .collect(Collectors.toList());
//    }
//
//    private TransactionRequestDto mapTransaction(TransactionModel transactionModel) {
//        TransactionRequestDto dto = new TransactionRequestDto();
//        dto.setId(transactionModel.getId());
//        dto.setQuantity(transactionModel.getQuantity());
//        dto.setCommission(transactionModel.getCommission());
//        dto.setTransactionType(transactionModel.getEnumTransactionType().name());
//        dto.setUnitPrice(transactionModel.getUnitPrice());
//        dto.setPortfolio(toDto(transactionModel.getPortfolio()));
//        return dto;
//    }
}