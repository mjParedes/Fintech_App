package com.practice.Objectives.dtoResponse;

public record ObjectivesResponseCreateDto(
        Long id,
        String description,
        String objectiveType,
        Double amountObjective,
        Double annualProgress,
        String priority,
        String frequency,
        Long idFinancingProfile
) {
}
