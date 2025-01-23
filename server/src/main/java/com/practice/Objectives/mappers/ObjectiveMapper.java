package com.practice.Objectives.mappers;

import com.practice.FinancingProfile.model.FinancingProfileModel;
import com.practice.Objectives.dtoRequest.ObjectivesRequestDto;
import com.practice.Objectives.dtoResponse.ObjectiveFinancingProfileInfoDto;
import com.practice.Objectives.dtoResponse.ObjectivesResponseDto;
import com.practice.Objectives.model.ObjectiveModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ObjectiveMapper {
    private final ModelMapper modelMapper;

    public ObjectiveMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ObjectivesRequestDto toDto(ObjectiveModel objective) {
        if (objective == null) {
            return null;
        }

        ObjectivesRequestDto dto = new ObjectivesRequestDto();

        dto.setId(objective.getId());
        dto.setDescription(objective.getDescription());
        dto.setAnnualProgress(objective.getAnnualProgress());
        dto.setPriority(String.valueOf(objective.getEnumPriority()));
        dto.setFrequency(String.valueOf(objective.getEnumFrequency()));
        dto.setObjectiveType(String.valueOf(objective.getEnumObjectiveType()));
        dto.setStartDate(objective.getStartDate());
        dto.setTargetDate(objective.getTargetDate());
        return dto;
    }

    public ObjectivesResponseDto toDtoObjective(ObjectiveModel objectiveModel) {
        if (objectiveModel == null) {
            return null;
        }
        ObjectivesResponseDto dto = modelMapper.map(objectiveModel, ObjectivesResponseDto.class);
        dto.setFinancingProfile(toObjectivesFinancingProfileResponseDto(objectiveModel.getFinancingProfile()));
        return dto;

    }

    private ObjectiveFinancingProfileInfoDto toObjectivesFinancingProfileResponseDto(FinancingProfileModel profileModel) {
        if (profileModel == null) {
            return null;
        }
        return ObjectiveFinancingProfileInfoDto
                .builder()
                .id(profileModel.getId())
                .knowledgeLevel(profileModel.getKnowledgeLevel())
                .riskProfile(profileModel.getRiskProfile())
                .incomeMonthly(profileModel.getIncomeMonthly())
                .expensesMonthly(profileModel.getExpensesMonthly())
                .percentageSave(profileModel.getPercentageSave())
                .totalDebt(profileModel.getTotalDebt())
                .savingsTotal(profileModel.getSavingsTotal())
                .patrimonyTotal(profileModel.getSavingsTotal())
                .build();
    }
}
