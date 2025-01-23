package com.practice.Objectives.dtoRequest;

import com.practice.Objectives.Enum.EnumFrequency;
import com.practice.Objectives.Enum.EnumPriority;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ObjectivesUpdateRequestDto {
    private Long id;
    private String description;
    private String objectiveType;
    private Double amountObjective;
    private Double annualProgress;
    private EnumPriority enumPriority;
    private EnumFrequency enumFrequency;
    private LocalDateTime startDate = LocalDateTime.now();
    private LocalDateTime targetDate = LocalDateTime.now();
    private Long  idFinancingProfile;

}
