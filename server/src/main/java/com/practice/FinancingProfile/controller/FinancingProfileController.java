package com.practice.FinancingProfile.controller;

import com.practice.FinancingProfile.dtoRequest.FinancingProfileOnboardingDto;
import com.practice.FinancingProfile.dtoRequest.FinancingProfileRequestDto;
import com.practice.FinancingProfile.dtoResponse.FinancingProfilePageResponse;
import com.practice.FinancingProfile.dtoResponse.FinancingProfileResponseDto;
import com.practice.FinancingProfile.service.FinancingProfileServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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

    @Operation(summary = "Obtener todos los perfiles financieros", description = "Devuelve todos los perfiles financieros")
    @ApiResponse(responseCode = "200", description = "Perfiles financieros obtenidos correctamente")
    @ApiResponse(responseCode = "404", description = "Perfiles financieros no obtenidos")
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
    public ResponseEntity<FinancingProfileResponseDto> saveOnboarding(@RequestBody @Valid FinancingProfileOnboardingDto onboardingDto) {
        FinancingProfileResponseDto financingProfileModel = financingProfileServiceImpl.saveOnboarding(onboardingDto);
        return ResponseEntity.ok(financingProfileModel);
    }

    @Operation(summary = "Obtener perfil financiero por ID", description = "Devuelve el perfil financiero por ID")
    @ApiResponse(responseCode = "200", description = "Perfil financiero obtenido correctamente")
    @ApiResponse(responseCode = "404", description = "Perfil financiero no obtenido")
    @GetMapping("/financing-profile/{id}")
    public ResponseEntity<FinancingProfileResponseDto> findFinancingProfileById(Long id) {
        FinancingProfileResponseDto response = financingProfileServiceImpl.findFinancingProfileById(id);
        return ResponseEntity.ok(response);
    }


//    @Operation(summary = "Guardar perfil financiero", description = "Guarda el perfil financiero, sin onboarding debido a que éste se crea en el endpoint de onboarding")
//    @ApiResponse(responseCode = "200", description = "Perfil financiero guardado correctamente")
//    @ApiResponse(responseCode = "404", description = "Perfil financiero no guardado")
//    @PostMapping("/financing-profile")
//    public ResponseEntity<FinancingProfileResponseDto> saveFinancingProfile(Long userId, @RequestBody @Valid FinancingProfileRequestDto financingProfileRequest) {
//        FinancingProfileResponseDto response = financingProfileServiceImpl.saveFinancingProfile(financingProfileRequest);
//        return ResponseEntity.ok(response);
//    }

    @Operation(summary = "Actualizar perfil financiero", description = "Actualiza el perfil financiero")
    @ApiResponse(responseCode = "200", description = "Perfil financiero actualizado correctamente")
    @ApiResponse(responseCode = "404", description = "Perfil financiero no actualizado")
    @PatchMapping("/financing-profile/{id}")
    public ResponseEntity<FinancingProfileResponseDto> updateFinancingProfile(@PathVariable Long id, @RequestBody @Valid FinancingProfileRequestDto financingProfileRequest) {
        FinancingProfileResponseDto response = financingProfileServiceImpl.updateFinancingProfile(id, financingProfileRequest);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Eliminar perfil financiero", description = "Elimina el perfil financiero")
    @ApiResponse(responseCode = "200", description = "Perfil financiero eliminado correctamente")
    @ApiResponse(responseCode = "404", description = "Perfil financiero no eliminado")
    @DeleteMapping("/financing-profile/{id}")
    public ResponseEntity<String> deletePortfolio(Long id) {
        financingProfileServiceImpl.deletePortfolio(id);
        return new ResponseEntity<>("Perfil financiero eliminado correctamente", HttpStatus.OK);
    }

    @GetMapping("/financing-profile/user/{userId}")
    @Operation(summary = "Obtener perfil financiero por ID", description = "Devuelve el perfil financiero por el ID del usuario")
    @ApiResponse(responseCode = "200", description = "Perfil financiero obtenido correctamente")
    @ApiResponse(responseCode = "404", description = "Perfil financiero no obtenido")
    public ResponseEntity<FinancingProfileResponseDto> findFinancingProfileByUserId(@PathVariable Long userId) {
        FinancingProfileResponseDto response = financingProfileServiceImpl.findFinancingProfileByUserId(userId);
        return ResponseEntity.ok(response);
    }


}
