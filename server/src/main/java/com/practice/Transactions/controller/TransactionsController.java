package com.practice.Transactions.controller;

import com.practice.Transactions.dtoResponse.TransactionPageResponseDto;
import com.practice.Transactions.dtoResponse.TransactionResponseDto;
import com.practice.Transactions.service.TransactionsServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/transaction")
@Tag(name = "Transacciones", description = "Transactions API")
public class TransactionsController {
    private final TransactionsServiceImpl transactionsServiceImpl;

    @GetMapping("/")
    public ResponseEntity<TransactionPageResponseDto> findAllTransaction(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        TransactionPageResponseDto response = transactionsServiceImpl.findAllTransactions(page, size);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionResponseDto> getTransactionById(@PathVariable Long id) {
        TransactionResponseDto transactionResponse = transactionsServiceImpl.getTransactionById(id);
        return ResponseEntity.ok(transactionResponse);
    }

}
