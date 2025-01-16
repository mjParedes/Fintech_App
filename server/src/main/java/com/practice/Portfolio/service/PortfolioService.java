package com.practice.Portfolio.service;

import com.practice.Portfolio.dtoResponse.PortfolioPageResponseDto;

public interface PortfolioService {
    PortfolioPageResponseDto findAllPortfolio(int page, int size);
}
