package com.practice.Transactions.dtoRequest;


import com.practice.Portfolio.dtoRequest.PortfolioRequestDto;
import com.practice.Transactions.dtoResponse.TransactionPortfolioInfoDto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@Schema(description = "Objeto de transacciones o movimientos")
public class TransactionRequestDto {
    @Schema(
            description = "ID del portafolio donde se realizará el movimiento",
            example = "1",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotNull(message = "El ID del portafolio es obligatorio")
    private Long portfolioId;
    @Schema(
            description = "Tipo de movimiento (COMPRA o VENTA)",
            example = "COMPRA",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotBlank(message = "El tipo de movimiento es obligatorio")
    private String enumTransactionType;
    @Schema(
            description = "Precio unitario de la operación",
            example = "105.75",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotNull(message = "El precio unitario de la operación es obligatorio")
    private Double unitPrice;
    @Schema(
            description = "Cantidad de unidades a operar",
            example = "5",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotNull(message = "La cantidad de unidades es obligatoria")
    private Integer quantity;
    @Schema(
            description = "Comisión de la operación",
            example = "10.50",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotNull(message = "La comisión es obligatoria")
    private Double commission;

    @Schema(
            description = "Fecha del movimiento",
            example = "2024-01-20",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotNull(message = "La fecha es obligatoria")
    private LocalDate operationDate;
}