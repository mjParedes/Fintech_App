package com.practice.FinancingProfile.dtoRequest;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Schema(description = "DTO para representar el Perfil Financiero")
public class FinancingProfileRequestDto {
    private Long id;
    @Schema(description = "Nivel de conocimiento del perfil")
    @NotBlank(message = "El nivel de conocimiento es requerido")
    private String knowledgeLevel;
    @Schema(description = "Perfil de riesgo del perfil")
    @NotBlank(message = "El perfil de riesgo es requerido")
    private String riskProfile;
    @Schema(description = "Ingresos mensuales del perfil")
    @NotBlank(message = "Los gastos mensasules son requeridos")
    private Double incomeMonthly;
    @Schema(description = "Gastos mensuales del perfil")
    @NotBlank(message = "El porcentaje de ahorro es requerido")
    private Double expensesMonthly;
    @Schema(description = "Porcentaje de ahorro del perfil")
    @NotBlank(message = "La deuda total es requerida")
    private Double percentageSave;
    @Schema(description = "Deuda total del perfil")
    @NotBlank(message = "Los ahorros totales son requeridos")
    private Double totalDebt;
    @Schema(description = "Ahorros totales del perfil")
    @NotBlank(message = "El patrimonio total es requerido")
    private Double savingsTotal;
    @Schema(description = "Patrimonio total del perfil")
    @NotBlank(message = "El patrimonio total es requerido")
    private Double patrimonyTotal;

}
