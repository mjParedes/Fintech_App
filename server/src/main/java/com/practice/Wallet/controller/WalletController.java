package com.practice.Wallet.controller;

import com.practice.Wallet.dtoRequest.WalletCreateRequestDto;
import com.practice.Wallet.dtoResponse.WalletPageResponseDto;
import com.practice.Wallet.dtoResponse.WalletResponseCreateDto;
import com.practice.Wallet.dtoResponse.WalletResponseDto;
import com.practice.Wallet.service.WalletServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
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

    @PostMapping("/create")
    public ResponseEntity<WalletResponseCreateDto> createWallet(@RequestBody WalletCreateRequestDto walletCreateRequestDto) {
        WalletResponseCreateDto response = walletServiceImpl.createWallet(walletCreateRequestDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWallet(@PathVariable Long id){
        walletServiceImpl.deleteWallet(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
