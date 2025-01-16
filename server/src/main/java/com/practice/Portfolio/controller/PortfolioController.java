package com.practice.Portfolio.controller;

import com.practice.Portfolio.dtoResponse.PortfolioPageResponseDto;
import com.practice.Portfolio.service.PortfolioServiceImpl;
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
@RequestMapping
@Tag(name = "Portfolio", description = "Portfolio API")
public class PortfolioController {
    private final PortfolioServiceImpl portfolioServiceImpl;

    @GetMapping("/portfolio")
    public ResponseEntity<PortfolioPageResponseDto> findAllPortfolio(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        PortfolioPageResponseDto response = portfolioServiceImpl.findAllPortfolio(page, size);
        return ResponseEntity.ok(response);
    }
}
