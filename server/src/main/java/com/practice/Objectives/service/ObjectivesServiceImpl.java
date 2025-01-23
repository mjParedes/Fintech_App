package com.practice.Objectives.service;

import com.practice.FinancingProfile.model.FinancingProfileModel;
import com.practice.FinancingProfile.repository.FinancingProfileRepository;
import com.practice.Objectives.Enum.EnumFrequency;
import com.practice.Objectives.Enum.EnumObjectiveType;
import com.practice.Objectives.Enum.EnumPriority;
import com.practice.Objectives.dtoRequest.ObjectivesCreateRequestDto;
import com.practice.Objectives.dtoRequest.ObjectivesRequestDto;
import com.practice.Objectives.dtoRequest.ObjectivesUpdateRequestDto;
import com.practice.Objectives.dtoResponse.ObjectivePageResponse;
import com.practice.Objectives.dtoResponse.ObjectivesResponseCreateDto;
import com.practice.Objectives.dtoResponse.ObjectivesResponseDto;
import com.practice.Objectives.mappers.ObjectiveMapper;
import com.practice.Objectives.model.ObjectiveModel;
import com.practice.Objectives.repository.ObjectiveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ObjectivesServiceImpl implements ObjectivesService {
    private final ObjectiveRepository objectiveRepository;
    private final ObjectiveMapper objectiveMapper;
    private final FinancingProfileRepository financingProfileRepository;

    @Override
    public ObjectivePageResponse findAllObjectives(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ObjectiveModel> objectivePage = objectiveRepository.findAll(pageable);
        List<ObjectivesRequestDto> objectiveDtos = objectivePage.getContent()
                .stream()
                .map(objectiveMapper::toDto)
                .collect(Collectors.toList());

        return new ObjectivePageResponse(objectiveDtos, objectivePage.getTotalPages(), objectivePage.getTotalElements());
    }

    @Override
    public ObjectivesResponseDto findObjectiveById(Long id) {
        ObjectiveModel objective = objectiveRepository.findById(id).orElseThrow();
        return objectiveMapper.toDtoObjective(objective);
    }

    @Override
    public ObjectivesResponseCreateDto createObjective(ObjectivesCreateRequestDto objectivesCreateRequestDto) {

        return null;
    }

    @Override
    public ObjectivesResponseDto updateObjective(Long id, ObjectivesUpdateRequestDto objectivesUpdateRequestDto) {
        return objectiveRepository.findById(id)
                .map(objective -> {
                    if (objectivesUpdateRequestDto.getObjectiveType() != null) {
                        EnumObjectiveType objectiveType = EnumObjectiveType.valueOf(objectivesUpdateRequestDto.getObjectiveType());
                        objective.setEnumObjectiveType(objectiveType);
                    }
                    if (objectivesUpdateRequestDto.getEnumPriority() != null) {
                        EnumPriority priority = EnumPriority.valueOf(String.valueOf(objectivesUpdateRequestDto.getEnumPriority()));
                        objective.setEnumPriority(priority);
                    }
                    if (objectivesUpdateRequestDto.getEnumFrequency() != null) {
                        EnumFrequency frequency = EnumFrequency.valueOf(String.valueOf(objectivesUpdateRequestDto.getEnumFrequency()));
                        objective.setEnumFrequency(frequency);
                    }
                    if (objectivesUpdateRequestDto.getIdFinancingProfile() != null) {
                        FinancingProfileModel profileModel = financingProfileRepository
                                .findById(
                                        objectivesUpdateRequestDto.getIdFinancingProfile()
                                ).orElseThrow();
                        objective.setFinancingProfile(profileModel);
                    }
                    objective.setDescription(objectivesUpdateRequestDto.getDescription());
                    objective.setAmountObjective(objectivesUpdateRequestDto.getAmountObjective());
                    objective.setAnnualProgress(objectivesUpdateRequestDto.getAnnualProgress());
                    ObjectiveModel updateObjective  = objectiveRepository.save(objective);
                    return objectiveMapper.toDtoObjective(updateObjective);
                }).orElseThrow();
    }

    @Override
    public void deleteObjective(Long id) {
        if (!objectiveRepository.existsById(id)) {
            throw new IllegalArgumentException("Objectivo con id" + id + "no existe");

        }
        objectiveRepository.deleteById(id);
    }
}
