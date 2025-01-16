package com.practice.Recommendation.dtoResponse;

import com.practice.Recommendation.dtoRequest.RecommendationRequestDto;

import java.util.List;

public record RecommendationPageResponseDto(
        List<RecommendationRequestDto> recommendationDtos,
        int page,
        long size
) {
}
