package com.practice.Transactions.controller;

import com.practice.Transactions.dtoResponse.TransactionPageResponseDto;
import com.practice.Transactions.service.TransactionsServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("")
@Tag(name = "Transacciones", description = "Transactions API")
public class TransactionsController {
    private final TransactionsServiceImpl transactionsServiceImpl;

    @GetMapping("/transaction")
    public ResponseEntity<TransactionPageResponseDto> findAllTransaction(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        TransactionPageResponseDto response = transactionsServiceImpl.findAllTransacctions(page, size);
        return ResponseEntity.ok(response);
    }
}
