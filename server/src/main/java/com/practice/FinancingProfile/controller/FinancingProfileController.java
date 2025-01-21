package com.practice.FinancingProfile.controller;

import com.practice.FinancingProfile.dtoRequest.FinancingProfileOnboardingDto;
import com.practice.FinancingProfile.dtoResponse.FinancingProfilePageResponse;
import com.practice.FinancingProfile.model.FinancingProfileModel;
import com.practice.FinancingProfile.service.FinancingProfileServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
@Validated
@RequiredArgsConstructor
@Tag(name = "Perfil Financiero", description = "FinancingProfile API")
public class FinancingProfileController {
    private final FinancingProfileServiceImpl financingProfileServiceImpl;

    @GetMapping("/financing-profile")
    public ResponseEntity<FinancingProfilePageResponse> getAllFinancingProfiles(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        FinancingProfilePageResponse response = financingProfileServiceImpl.findAllFinancingProfiles(page, size);

        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Guardar onboarding", description = "Guarda el Onboarding del perfil financiero")
    @ApiResponse(responseCode = "200", description = "Onboarding guardado correctamente")
    @ApiResponse(responseCode = "404", description = "Onboarding no guardado")
    @PostMapping("/onboarding")
    public ResponseEntity<FinancingProfileModel> saveOnboarding(@RequestBody @Valid FinancingProfileOnboardingDto onboardingDto) {
        FinancingProfileModel financingProfileModel = financingProfileServiceImpl.saveOnboarding(onboardingDto);
        return ResponseEntity.ok(financingProfileModel);
    }


}
