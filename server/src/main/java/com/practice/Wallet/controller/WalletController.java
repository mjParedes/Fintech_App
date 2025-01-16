package com.practice.Wallet.controller;

import com.practice.Wallet.dtoResponse.WalletPageResponseDto;
import com.practice.Wallet.service.WalletServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
@Validated
@Tag(name = "Wallet", description = "Wallet API")
public class WalletController {
    private final WalletServiceImpl walletServiceImpl;

    @GetMapping("/wallet")
    public ResponseEntity<WalletPageResponseDto> findAllWallets(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        WalletPageResponseDto response = walletServiceImpl.findAllWallet(page, size);
        return ResponseEntity.ok(response);
    }


}
