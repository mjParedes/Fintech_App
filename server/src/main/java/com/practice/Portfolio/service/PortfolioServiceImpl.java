package com.practice.Portfolio.service;

import com.practice.Portfolio.dtoRequest.PortfolioRequestDto;
import com.practice.Portfolio.dtoResponse.PortfolioPageResponseDto;
import com.practice.Portfolio.mappers.PortfolioMapper;
import com.practice.Portfolio.model.PortfolioModel;
import com.practice.Portfolio.repository.PortfolioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PortfolioServiceImpl implements PortfolioService {
    private final PortfolioRepository portfolioRepository;
    private final PortfolioMapper portfolioMapper;

    @Override
    public PortfolioPageResponseDto findAllPortfolio(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<PortfolioModel> portfolioPage = portfolioRepository.findAll(pageable);

        List<PortfolioRequestDto> portfolioDtos = portfolioPage.getContent()
                .stream()
                .map(portfolioMapper::toDto)
                .collect(Collectors.toList());
        return new PortfolioPageResponseDto(portfolioDtos, portfolioPage.getTotalPages(), portfolioPage.getTotalElements());
    }
}