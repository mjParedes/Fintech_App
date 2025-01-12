package com.practice.FinancingProfile.controller;

import com.practice.FinancingProfile.service.FinancingProfileServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
@Validated
@RequiredArgsConstructor
@Tag(name = "Perfil Financiero", description = "FinancingProfile API")
public class FinancingProfileController {
    private final FinancingProfileServiceImpl financingProfileServiceImpl;
}
