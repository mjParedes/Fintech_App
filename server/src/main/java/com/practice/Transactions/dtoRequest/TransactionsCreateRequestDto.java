package com.practice.Transactions.dtoRequest;

public record TransactionsCreateRequestDto(
        String transactionType,
        Double unitPrice,
        Integer quantity,
        Double commission,
        Long idPortfolio
) {
}
