package com.practice.Wallet.dtoRequest;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

@Validated
@Schema(description = "DTO para crear un Wallet")
public record WalletCreateRequestDto(
        Double currentBalance,
        Long idUser

) {
}
