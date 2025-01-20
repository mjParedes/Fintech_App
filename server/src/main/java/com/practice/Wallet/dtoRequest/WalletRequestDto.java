package com.practice.Wallet.dtoRequest;

import com.practice.Wallet.dtoResponse.WalletUserInfoDto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Schema(description = "DTO para representar el Wallet")
public class WalletRequestDto {
    private Long id;
    @Schema(description = "Id del usuario")
    private List<WalletUserInfoDto> user;
    @Schema(description = "Saldo actual de la billetera")
    @NotBlank(message = "Salgo actual requerido")
    private Double currentBalance;
}
