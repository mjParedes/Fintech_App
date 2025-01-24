package com.practice.Wallet.controller;

import com.practice.Wallet.dtoRequest.WalletCreateRequestDto;
import com.practice.Wallet.dtoRequest.WalletUpdateRequestDto;
import com.practice.Wallet.dtoResponse.WalletPageResponseDto;
import com.practice.Wallet.dtoResponse.WalletResponseCreateDto;
import com.practice.Wallet.dtoResponse.WalletResponseDto;
import com.practice.Wallet.service.WalletServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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

    @Operation(summary = "Obtener todos los Wallet", description = "Devuelve todo los Wallet existentes")
    @ApiResponse(responseCode = "200", description = "Wallets obtenidos correctamente")
    @ApiResponse(responseCode = "404", description = "No se encontraron Wallets")
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

    @Operation(summary = "Crear un wallet", description = "Guarda un wallet")
    @ApiResponse(responseCode = "200", description = "Wallets creado correctamente")
    @ApiResponse(responseCode = "404", description = "No se pudo crear el wallet")
    @PostMapping("/create")
    @Transactional
    public ResponseEntity<WalletResponseCreateDto> createWallet(@RequestBody WalletCreateRequestDto walletCreateRequestDto) {
        WalletResponseCreateDto response = walletServiceImpl.createWallet(walletCreateRequestDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Operation(summary = "Actualizar  wallet por ID", description = "Actualizar el wallet por ID")
    @ApiResponse(responseCode = "200", description = "Wallets actualizado correctamente")
    @ApiResponse(responseCode = "404", description = "No se encontraron el wallet por ID")
    @Transactional
    @PatchMapping("/{id}")
    public ResponseEntity<WalletResponseDto> updateWallet(@PathVariable Long id, @Validated @RequestBody WalletUpdateRequestDto walletUpdateRequestDto) {
        WalletResponseDto updateWallet = walletServiceImpl.updateWallet(id, walletUpdateRequestDto);
        return new ResponseEntity<>(updateWallet, HttpStatus.OK);
    }

    @Operation(summary = "Eliminar  wallet por ID", description = "Eliminar  el wallet por ID")
    @ApiResponse(responseCode = "200", description = "Wallet eliminado correctamente")
    @ApiResponse(responseCode = "404", description = "ERROR no se pudo eliminar el wallet")
    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWallet(@PathVariable Long id) {
        walletServiceImpl.deleteWallet(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
