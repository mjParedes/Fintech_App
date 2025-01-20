package com.practice.Transactions.dtoResponse;

public record TransactionCreateResponseDto(
        Long id,
        String transactionType,
        Double unitPrice,
        Integer quantity,
        Double commission,
        Long idPortfolio
) {
}
