package com.practice.Recommendation.mappers;

import com.practice.Recommendation.dtoRequest.RecommendationRequestDto;
import com.practice.Recommendation.model.RecommendationModel;
import org.springframework.stereotype.Component;

@Component
public class RecommendationMapper {
    public RecommendationRequestDto toDto(RecommendationModel recommendationModel) {
        RecommendationRequestDto dto = new RecommendationRequestDto();

        dto.setId(recommendationModel.getId());
        dto.setRecommendationType(recommendationModel.getEnumRecommendationType().name());
        dto.setMotion(recommendationModel.getMotion());
        dto.setState(recommendationModel.getState());
        dto.setUserId(recommendationModel.getUser().getId());
        dto.setInstrumentId(recommendationModel.getInstrument().getId());
        return dto;
    }
}
