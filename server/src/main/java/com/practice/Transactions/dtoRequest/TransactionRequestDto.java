package com.practice.Transactions.dtoRequest;


import com.practice.Portfolio.dtoRequest.PortfolioRequestDto;
import com.practice.Transactions.dtoResponse.TransactionPortfolioInfoDto;
import io.swagger.v3.oas.annotations.media.Schema;
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
    private Long portfolioId;
    @Schema(
            description = "Tipo de movimiento (COMPRA o VENTA)",
            example = "COMPRA",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String transactionType;
    @Schema(
            description = "Precio unitario de la operación",
            example = "105.75",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private Double unitPrice;
    @Schema(
            description = "Cantidad de unidades a operar",
            example = "5",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private Integer quantity;
    @Schema(
            description = "Comisión de la operación",
            example = "10.50",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private Double commission;

    @Schema(
            description = "Fecha del movimiento",
            example = "2024-01-20",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private LocalDate operationDate;
}