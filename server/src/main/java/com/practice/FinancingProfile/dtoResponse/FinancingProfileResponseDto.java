package com.practice.FinancingProfile.dtoResponse;

import com.practice.FinancingProfile.Enum.EnumKnowledgeLevel;
import com.practice.User.model.UserModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FinancingProfileResponseDto {
    private Long id;
    private String knowledgeLevel;
    private String riskProfile;
    private Double incomeMonthly;
    private Double expensesMonthly;
    private Double percentageSave;
    private Double totalDebt;
    private Double savingsTotal;
    private Double patrimonyTotal;
    private Long userId;
}
