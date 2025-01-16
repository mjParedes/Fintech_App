package com.practice.Recommendation.dtoRequest;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Schema(description = "")
public class RecommendationRequestDto {
    private Long id;
    private String recommendationType;
    private String motion;
    private Boolean state;
    private Long userId;
    private Long instrumentId;


}
