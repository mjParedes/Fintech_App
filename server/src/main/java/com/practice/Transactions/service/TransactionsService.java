package com.practice.Transactions.service;


import com.practice.Transactions.dtoResponse.TransactionPageResponseDto;
import com.practice.Transactions.dtoResponse.TransactionResponseDto;

public interface TransactionsService {
    TransactionPageResponseDto findAllTransactions(int page , int size);
    TransactionResponseDto getTransactionById(Long id);

}
