package com.practice.Transactions.service;


import com.practice.Transactions.dtoRequest.TransactionRequestDto;
import com.practice.Transactions.dtoResponse.TransactionPageResponseDto;
import com.practice.Transactions.dtoResponse.TransactionResponseDto;
import com.practice.Transactions.model.TransactionModel;
import jakarta.validation.Valid;


public interface TransactionsService {
    TransactionPageResponseDto findAllTransactions(int page , int size);
    TransactionResponseDto getTransactionById(Long id);
    TransactionCreateResponseDto createTransaction(@Validated TransactionsCreateRequestDto transactionsCreateRequestDto);
    void deleteTransaction(Long id);

    TransactionResponseDto saveTransaction(@Valid TransactionRequestDto dto);

    TransactionResponseDto updateTransaction(Long id, @Valid TransactionRequestDto dto);

    void deleteTransaction(Long id);
}
