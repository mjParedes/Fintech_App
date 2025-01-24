package com.practice.Objectives.dtoRequest;

public record ObjectivesCreateRequestDto(
         Long id ,
         String description ,
         String objectiveType ,
         Double amountObjective ,
         Double annualProgress ,
         String priority ,
         String frequency,
         Long  idFinancingProfile
) {
}
