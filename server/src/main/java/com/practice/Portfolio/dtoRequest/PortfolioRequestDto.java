package com.practice.Portfolio.dtoRequest;

import com.practice.Instrument.model.InstrumentModel;
import com.practice.Transactions.dtoRequest.TransactionRequestDto;
import com.practice.Transactions.model.TransactionModel;
import com.practice.User.model.UserModel;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Detalles del portafolio")
public class PortfolioRequestDto {
    @Schema(
            description = "Cantidad de unidades del instrumento a comprar",
            example = "10",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private Integer quantity;

    @Schema(
            description = "Precio unitario de compra del instrumento",
            example = "100.50",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private Double purchasePrice;

    @Schema(
            description = "Fecha de compra del instrumento",
            example = "2024-01-20",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private LocalDate purchaseDate;

    @Schema(
            description = "ID del usuario dueño del portafolio",
            example = "1",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private Long userId;

}
