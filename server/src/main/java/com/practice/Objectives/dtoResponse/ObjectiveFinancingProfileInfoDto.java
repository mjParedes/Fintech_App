package com.practice.Objectives.dtoResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ObjectiveFinancingProfileInfoDto {
    private Long id;
    private String knowledgeLevel;
    private String riskProfile;
    private Double incomeMonthly;
    private Double expensesMonthly;
    private Double percentageSave;
    private Double totalDebt;
    private Double savingsTotal;
    private Double patrimonyTotal;
}
