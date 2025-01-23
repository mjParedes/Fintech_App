package com.practice.Portfolio.controller;

import com.practice.Portfolio.dtoRequest.PortfolioRequestDto;
import com.practice.Portfolio.dtoResponse.PortfolioPageResponseDto;
import com.practice.Portfolio.dtoResponse.PortfolioResponseDto;
import com.practice.Portfolio.service.PortfolioServiceImpl;
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
@Validated
@RequiredArgsConstructor
@RequestMapping
@Tag(name = "Portfolio", description = "Portfolio API")
public class PortfolioController {
    private final PortfolioServiceImpl portfolioServiceImpl;


    @Operation(summary = "Obtener todos los Portfolio", description = "Devuelve todos los Portfolio")
    @ApiResponse(responseCode = "200", description = "Portfolios obtenidos correctamente")
    @ApiResponse(responseCode = "404", description = "No se encontraron Portfolios")
    @GetMapping("/portfolio")
    public ResponseEntity<PortfolioPageResponseDto> findAllPortfolio(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        PortfolioPageResponseDto response = portfolioServiceImpl.findAllPortfolio(page, size);
        return ResponseEntity.ok(response);
    }


    @Operation(summary = "Obtener Portfolio por ID", description = "Devuelve un Portfolio por id")
    @ApiResponse(responseCode = "200", description = "Portfolio obtenido correctamente")
    @ApiResponse(responseCode = "404", description = "Portfolio no encontrado")
    @GetMapping("/portfolio/{id}")
    public ResponseEntity<PortfolioResponseDto> findPortfolioById(@PathVariable Long id) {
        PortfolioResponseDto portfolio = portfolioServiceImpl.findPortfolioById(id);
        return new ResponseEntity<>(portfolio, HttpStatus.OK);
    }


    @Operation(summary = "Guardar Portfolio", description = "Guarda un Portfolio")
    @ApiResponse(responseCode = "200", description = "Portfolio guardado correctamente")
    @ApiResponse(responseCode = "404", description = "Portfolio no guardado")
    @PostMapping("/portfolio")
    public ResponseEntity<PortfolioResponseDto> savePortfolio(@RequestBody @Valid PortfolioRequestDto portfolioRequest) {
        PortfolioResponseDto portfolio = portfolioServiceImpl.savePortfolio(portfolioRequest);
        return new ResponseEntity<>(portfolio,HttpStatus.OK);
    }


    @Operation(summary = "Actualizar Portfolio", description = "Actualiza un Portfolio")
    @ApiResponse(responseCode = "200", description = "Portfolio actualizado correctamente")
    @ApiResponse(responseCode = "404", description = "Portfolio no actualizado")
    @PatchMapping("/portfolio/{id}")
    public ResponseEntity<PortfolioResponseDto> updatePortfolio(@PathVariable Long id, @RequestBody @Valid PortfolioRequestDto portfolioRequest) {
        PortfolioResponseDto portfolio = portfolioServiceImpl.updatePortfolio(id, portfolioRequest);
        return new ResponseEntity<>(portfolio, HttpStatus.OK);
    }


    @Operation(summary = "Eliminar Portfolio", description = "Elimina un Portfolio")
    @ApiResponse(responseCode = "200", description = "Portfolio eliminado correctamente")
    @ApiResponse(responseCode = "404", description = "Portfolio no eliminado")
    @DeleteMapping("/portfolio/{id}")
    public ResponseEntity<String> deletePortfolio(@PathVariable Long id) {
        portfolioServiceImpl.deletePortfolio(id);
        return new ResponseEntity<>("Portfolio eliminado correctamente", HttpStatus.OK);
    }
}
