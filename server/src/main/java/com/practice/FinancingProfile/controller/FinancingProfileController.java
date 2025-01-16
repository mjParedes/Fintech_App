package com.practice.FinancingProfile.controller;

import com.practice.FinancingProfile.dtoResponse.FinancingProfilePageResponse;
import com.practice.FinancingProfile.service.FinancingProfileServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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


}
