package com.practice.Wallet.controller;

import com.practice.Wallet.dtoResponse.WalletPageResponseDto;
import com.practice.Wallet.dtoResponse.WalletResponseDto;
import com.practice.Wallet.service.WalletServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wallet")
@RequiredArgsConstructor
@Validated
@Tag(name = "Wallet", description = "Wallet API")
public class WalletController {
    private final WalletServiceImpl walletServiceImpl;

    @GetMapping("/")
    public ResponseEntity<WalletPageResponseDto> findAllWallets(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        WalletPageResponseDto response = walletServiceImpl.findAllWallet(page, size);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Obtener Wallet por ID", description = "Devuelve un Wallet por id")
    @ApiResponse(responseCode = "200", description = "Wallet obtenido correctamente")
    @ApiResponse(responseCode = "404", description = "Wallet no encontrado")
    @GetMapping("/{id}")
    public ResponseEntity<WalletResponseDto> getWalletById(@PathVariable Long id) {
        WalletResponseDto wallet = walletServiceImpl.getWalletById(id);
        return ResponseEntity.ok(wallet);
    }

}
