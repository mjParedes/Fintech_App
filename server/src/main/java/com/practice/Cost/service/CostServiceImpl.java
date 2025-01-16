package com.practice.Cost.service;

import com.practice.Cost.dtoRequest.CostRequestDto;
import com.practice.Cost.dtoResponse.CostPageResponseDto;
import com.practice.Cost.mappers.CostMapper;
import com.practice.Cost.model.CostModel;
import com.practice.Cost.repository.CostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CostServiceImpl implements CostService {
    private final CostRepository costRepository;
    private final CostMapper costMapper;

    @Override
    public CostPageResponseDto findAllCost(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);

        Page<CostModel> costPage = costRepository.findAll(pageable);

        List<CostRequestDto> costDto = costPage.getContent()
                .stream()
                .map(dto -> costMapper.toDto(dto))
                .collect(Collectors.toList());

        return new CostPageResponseDto(costDto, costPage.getTotalPages(), costPage.getTotalElements());
    }
}
