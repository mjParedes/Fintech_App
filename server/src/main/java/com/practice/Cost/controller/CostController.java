package com.practice.Cost.controller;

import com.practice.Cost.dtoResponse.CostPageResponseDto;
import com.practice.Cost.service.CostServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cost")
@Tag(name = "Gastos", description = "Gastos API")
@Validated
public class CostController {
    private final CostServiceImpl costServiceImpl;

    @GetMapping("/")
    public ResponseEntity<CostPageResponseDto> findAllCost(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        CostPageResponseDto response = costServiceImpl.findAllCost(page, size);
        return ResponseEntity.ok(response);
    }

}
