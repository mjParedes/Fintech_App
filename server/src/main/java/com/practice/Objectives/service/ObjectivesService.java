package com.practice.Objectives.service;

import com.practice.Objectives.dtoRequest.ObjectivesCreateRequestDto;
import com.practice.Objectives.dtoRequest.ObjectivesUpdateRequestDto;
import com.practice.Objectives.dtoResponse.ObjectivePageResponse;
import com.practice.Objectives.dtoResponse.ObjectivesResponseCreateDto;
import com.practice.Objectives.dtoResponse.ObjectivesResponseDto;
import org.springframework.validation.annotation.Validated;

public interface ObjectivesService {
    ObjectivePageResponse findAllObjectives(int page, int size);
    ObjectivesResponseDto findObjectiveById(Long id);
    ObjectivesResponseCreateDto createObjective(ObjectivesCreateRequestDto objectivesCreateRequestDto);
    ObjectivesResponseDto updateObjective(Long id , @Validated ObjectivesUpdateRequestDto objectivesUpdateRequestDto);
    void deleteObjective(Long id);
}
