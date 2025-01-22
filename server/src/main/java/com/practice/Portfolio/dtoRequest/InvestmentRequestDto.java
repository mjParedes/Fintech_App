package com.practice.Portfolio.dtoRequest;

import com.practice.Transactions.Enum.EnumTransactionType;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InvestmentRequestDto {
    @NotNull(message = "El ID del instrumento no puede ser nulo")
    private Long instrumentId;

    @Min(value = 1, message = "La cantidad debe ser mayor a 0")
    private int quantity;

    @DecimalMin(value = "0.0", inclusive = false, message = "El precio unitario debe ser mayor a 0")
    private double unitPrice;

    @DecimalMin(value = "0.0", inclusive = true, message = "La comisión no puede ser negativa")
    private double commission;

    @NotNull(message = "El tipo de transacción no puede ser nulo")
    private EnumTransactionType transactionType;
}
