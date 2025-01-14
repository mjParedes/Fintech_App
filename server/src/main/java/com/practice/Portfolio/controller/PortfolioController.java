package com.practice.Portfolio.controller;

import com.practice.Portfolio.service.PortfolioServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping()
@Tag(name = "Portfolio", description = "Portfolio API")
public class PortfolioController {
    private final PortfolioServiceImpl portfolioServiceImpl;
}
