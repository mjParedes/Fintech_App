package com.practice.Objectives.service;

import com.practice.Objectives.repository.ObjectiveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ObjectivesServiceImpl implements ObjectivesService {
    private final ObjectiveRepository objectiveRepository;
}
