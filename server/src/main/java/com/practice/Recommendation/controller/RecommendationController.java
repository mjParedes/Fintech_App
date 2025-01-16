package com.practice.Recommendation.controller;

import com.practice.Recommendation.dtoResponse.RecommendationPageResponseDto;
import com.practice.Recommendation.service.RecommendationServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("")
@Tag(name = "Recomendaciones", description = "Recommendation API")
public class RecommendationController {
    private final RecommendationServiceImpl recommendationServiceImpl;

    @GetMapping("/recommendation")
    public ResponseEntity<RecommendationPageResponseDto> findAllRecommendation(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        RecommendationPageResponseDto response = recommendationServiceImpl.findAllRecommendation(page, size);
        return ResponseEntity.ok(response);
    }
}
