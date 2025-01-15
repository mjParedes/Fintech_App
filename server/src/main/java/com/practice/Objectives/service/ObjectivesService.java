package com.practice.Objectives.service;

import com.practice.Objectives.dtoResponse.ObjectivePageResponse;

public interface ObjectivesService {
    ObjectivePageResponse findAllObjectives(int page, int size);
}
