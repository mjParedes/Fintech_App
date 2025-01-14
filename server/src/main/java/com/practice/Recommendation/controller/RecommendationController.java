package com.practice.Recommendation.controller;

import com.practice.Recommendation.service.RecommendationServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("")
@Tag(name = "Recomendaciones", description = "Recommendation API")
public class RecommendationController {
    private final RecommendationServiceImpl recommendationServiceImpl;

}
