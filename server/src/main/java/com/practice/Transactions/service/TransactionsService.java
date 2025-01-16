package com.practice.Transactions.service;


import com.practice.Transactions.dtoResponse.TransactionPageResponseDto;

public interface TransactionsService {
    TransactionPageResponseDto findAllTransacctions(int page , int size);
}
