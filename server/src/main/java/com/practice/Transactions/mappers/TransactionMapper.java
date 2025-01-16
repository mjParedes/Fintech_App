package com.practice.Transactions.mappers;

import com.practice.Portfolio.mappers.PortfolioMapper;
import com.practice.Transactions.dtoRequest.TransactionRequestDto;
import com.practice.Transactions.model.TransactionModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class TransactionMapper {
    private final PortfolioMapper portfolioMapper;

    public TransactionRequestDto toDto(TransactionModel transactionModel) {
        TransactionRequestDto dto = new TransactionRequestDto();
        dto.setId(transactionModel.getId());
        dto.setTransactionType(transactionModel.getEnumTransactionType().name());
        dto.setQuantity(transactionModel.getQuantity());
        dto.setUnitPrice(transactionModel.getUnitPrice());
        dto.setCommission(transactionModel.getCommission());
//        dto.setPortfolio(portfolioMapper.toDto(transactionModel.getPortfolio()));
        return dto;
    }
}
