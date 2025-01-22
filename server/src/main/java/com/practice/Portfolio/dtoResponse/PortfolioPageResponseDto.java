package com.practice.Portfolio.dtoResponse;

import com.practice.Portfolio.dtoRequest.PortfolioRequestDto;

import java.util.List;

public record PortfolioPageResponseDto(
        List<PortfolioResponseDto> portfolioDtos,
        int page,
        long totalElements
) {
}
