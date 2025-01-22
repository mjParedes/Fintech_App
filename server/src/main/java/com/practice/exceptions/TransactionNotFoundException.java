package com.practice.exceptions;

public class TransactionNotFoundException extends RuntimeException {
    public TransactionNotFoundException(String transactionNotFound) {
        super(transactionNotFound);
    }
}
