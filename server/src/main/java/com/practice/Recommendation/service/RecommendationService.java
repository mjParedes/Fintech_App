package com.practice.Recommendation.service;

import com.practice.Recommendation.dtoResponse.RecommendationPageResponseDto;

public interface RecommendationService {
    RecommendationPageResponseDto findAllRecommendation(int page, int size);
}
