package com.practice.Transactions.service;


import com.practice.Transactions.dtoRequest.TransactionsCreateRequestDto;
import com.practice.Transactions.dtoResponse.TransactionCreateResponseDto;
import com.practice.Transactions.dtoResponse.TransactionPageResponseDto;
import com.practice.Transactions.dtoResponse.TransactionResponseDto;
import org.springframework.validation.annotation.Validated;

public interface TransactionsService {
    TransactionPageResponseDto findAllTransactions(int page , int size);
    TransactionResponseDto getTransactionById(Long id);
    TransactionCreateResponseDto createTransaction(@Validated TransactionsCreateRequestDto transactionsCreateRequestDto);
    void deleteTransaction(Long id);

}
