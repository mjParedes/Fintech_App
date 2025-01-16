package com.practice.Objectives.controller;

import com.practice.Objectives.dtoResponse.ObjectivePageResponse;
import com.practice.Objectives.service.ObjectivesServiceImpl;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@Validated
@RequiredArgsConstructor
@Tag(name = "Objetivos", description = "Objectives API")
public class ObjectivesController {
    private final ObjectivesServiceImpl objectivesServiceImpl;

    @ApiResponse(responseCode = "200", description = "Objetivos obtenidos correctamente")
    @GetMapping("/objective")
    public ResponseEntity<ObjectivePageResponse> getAllObjectives(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        ObjectivePageResponse response = objectivesServiceImpl.findAllObjectives(page, size);
        return ResponseEntity.ok(response);

    }

    ;
}
