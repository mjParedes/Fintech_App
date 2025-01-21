package com.practice.Transactions.dtoResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionResponseDto {
    private Long id;
    private String transactionType;
    private Double unitPrice;
    private Integer quantity;
    private Double commission;
    private Long portfolioId;
    //private TransactionPortfolioInfoDto portfolio;
}
