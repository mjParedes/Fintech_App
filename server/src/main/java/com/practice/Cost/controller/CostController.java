package com.practice.Cost.controller;

import com.practice.Cost.service.CostServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("")
@Tag(name = "Gastos", description = "Gastos API")
@Validated
public class CostController {
    private final CostServiceImpl costServiceImpl;
}
