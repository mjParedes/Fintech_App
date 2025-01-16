package com.practice.Cost.service;

import com.practice.Cost.dtoResponse.CostPageResponseDto;

public interface CostService {
    CostPageResponseDto findAllCost(int page, int size);
}
