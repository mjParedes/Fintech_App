package com.practice.Wallet.controller;

import com.practice.Wallet.service.WalletServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
@Validated
@Tag(name = "Wallet", description = "Wallet API")
public class WalletController {
    private final WalletServiceImpl walletServiceImpl;
}
