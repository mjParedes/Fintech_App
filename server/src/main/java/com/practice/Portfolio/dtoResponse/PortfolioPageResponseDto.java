package com.practice.Portfolio.dtoResponse;

import com.practice.Portfolio.dtoRequest.PortfolioRequestDto;

import java.util.List;

public record PortfolioPageResponseDto(
        List<PortfolioRequestDto> portfolioDtos,
        int page,
        long totalElements
) {
}
