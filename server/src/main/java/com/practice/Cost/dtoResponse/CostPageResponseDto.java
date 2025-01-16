package com.practice.Cost.dtoResponse;

import com.practice.Cost.dtoRequest.CostRequestDto;

import java.util.List;

public record CostPageResponseDto(
        List<CostRequestDto> costDtos,
        int totalPage,
        long totalElements
) {
}
