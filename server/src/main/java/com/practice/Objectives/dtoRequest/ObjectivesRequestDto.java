package com.practice.Objectives.dtoRequest;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Schema(description = "DTO para representar un Objetivo")
public class ObjectivesRequestDto {
    private Long id;
    @Schema(description = "La description es requerida")
    @NotBlank(message = "La descripción es requerida")
    private String description;
    @Schema(description = "Descripción del objetivo")
    @NotBlank(message = "El tipo de objeto es requerido")
    private String objectiveType;
    @Schema(description = "Progreso anual del objetivo")
    @NotBlank(message = "El progreso anual es requerido")
    private Double annualProgress;
    @Schema(description = "Prioridad del objetivo")
    @NotBlank(message = "La prioridad es requerida")
    private String priority;
    @Schema(name = "Frecuencia del objetivo")
    @NotBlank(message = "La frecuencia es requerida")
    private String frequency;
    @Schema(description = "Fecha de inicio del objetivo")
    @NotBlank(message = "La fecha de inicio es obligatoria")
    private LocalDateTime startDate;
    @Schema(description = "Fecha del objetivo")
    @NotBlank(message = "La fecha del objetivo es obligatoria")
    private LocalDateTime targetDate;
}
