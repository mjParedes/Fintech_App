package com.practice.Transactions.controller;

import com.practice.Transactions.dtoRequest.TransactionRequestDto;
import com.practice.Transactions.dtoResponse.TransactionPageResponseDto;
import com.practice.Transactions.dtoResponse.TransactionResponseDto;
import com.practice.Transactions.service.TransactionsServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
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

    @Operation(summary = "Obtener todas las transacciones", description = "Devuelve todas las transacciones")
    @ApiResponse(responseCode = "200", description = "Transacciones obtenidas correctamente")
    @ApiResponse(responseCode = "404", description = "No se encontraron transacciones")
    @GetMapping("/")
    public ResponseEntity<TransactionPageResponseDto> findAllTransaction(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        TransactionPageResponseDto response = transactionsServiceImpl.findAllTransactions(page, size);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Obtener transacción por ID", description = "Devuelve una transacción por id")
    @ApiResponse(responseCode = "200", description = "Transacción obtenida correctamente")
    @ApiResponse(responseCode = "404", description = "Transacción no encontrada")
    @GetMapping("/{id}")
    public ResponseEntity<TransactionResponseDto> getTransactionById(@PathVariable Long id) {
        TransactionResponseDto transactionResponse = transactionsServiceImpl.getTransactionById(id);
        return ResponseEntity.ok(transactionResponse);
    }

    @Operation(summary = "Guardar transacción", description = "Guarda una transacción o movimiento")
    @ApiResponse(responseCode = "200", description = "Transacción guardada correctamente")
    @ApiResponse(responseCode = "400", description = "Error al guardar la transacción")
    @PostMapping("/save")
    public ResponseEntity<TransactionResponseDto> saveTransaction(@RequestBody @Valid TransactionRequestDto dto) {
        TransactionResponseDto transactionResponse = transactionsServiceImpl.saveTransaction(dto);
        return ResponseEntity.ok(transactionResponse);
    }

    @Operation(summary = "Actualizar transacción", description = "Actualiza una transacción")
    @ApiResponse(responseCode = "200", description = "Transacción actualizada correctamente")
    @ApiResponse(responseCode = "400", description = "Error al actualizar la transacción")
    @PatchMapping("/update/{id}")
    public ResponseEntity<TransactionResponseDto> updateTransaction(@PathVariable Long id, @RequestBody @Valid TransactionRequestDto dto) {
        TransactionResponseDto transactionResponse = transactionsServiceImpl.updateTransaction(id, dto);
        return ResponseEntity.ok(transactionResponse);
    }

    @Operation(summary = "Eliminar transacción", description = "Elimina una transacción")
    @ApiResponse(responseCode = "200", description = "Transacción eliminada correctamente")
    @ApiResponse(responseCode = "404", description = "Transacción no encontrada")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable Long id) {
        transactionsServiceImpl.deleteTransaction(id);
        return ResponseEntity.ok().build();
    }

}
