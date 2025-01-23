package com.practice.Wallet.dtoRequest;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Schema(description = "DTO para representar el Wallet")
public class WalletUpdateRequestDto {
    private Long id;
    @Schema(description = "Id del usuario")
    private Long idUser;
    @Schema(description = "Saldo actual de la billetera")
    private Double currentBalance;
}