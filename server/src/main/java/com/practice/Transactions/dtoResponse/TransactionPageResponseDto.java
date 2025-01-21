package com.practice.Transactions.dtoResponse;

import com.practice.Transactions.dtoRequest.TransactionRequestDto;

import java.util.List;

public record TransactionPageResponseDto(
        List<TransactionResponseDto> transactionDtos,
        int page,
        long totalElement
) {
}
