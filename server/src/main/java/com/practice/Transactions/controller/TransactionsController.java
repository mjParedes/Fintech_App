package com.practice.Transactions.controller;

import com.practice.Transactions.service.TransactionsServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("")
@Tag(name = "Transacciones", description = "Transactions API")
public class TransactionsController {
    private final TransactionsServiceImpl transactionsServiceImpl;
}
