package com.practice.Transactions.dtoResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionResponseDto {
    private Long id;
    private String enumTransactionType;
    private Double unitPrice;
    private Integer quantity;
    private Double commission;
    private LocalDate operationDate;
    private Long portfolioId;
}
