package com.practice.FinancingProfile.dtoRequest;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "DTO para el onboarding del perfil de financiamiento")
public class FinancingProfileOnboardingDto {
    @Schema(description = "ID del usuario", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "El ID del usuario es requerido")
    private Long userId;

    @Schema(description = "Nivel de conocimiento del perfil", example = "MODERADO", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "El nivel de riego es requerido")
    private String riskProfile;
}
