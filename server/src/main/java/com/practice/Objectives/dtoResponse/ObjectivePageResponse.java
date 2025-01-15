package com.practice.Objectives.dtoResponse;

import com.practice.Objectives.dtoRequest.ObjectivesRequestDto;

import java.util.List;

public record ObjectivePageResponse(
        List<ObjectivesRequestDto> objectives,
        int totalPages,
        long totalElements
) {
}
