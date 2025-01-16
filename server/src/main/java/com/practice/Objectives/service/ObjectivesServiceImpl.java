package com.practice.Objectives.service;

import com.practice.Objectives.dtoRequest.ObjectivesRequestDto;
import com.practice.Objectives.dtoResponse.ObjectivePageResponse;
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
}
