package com.practice.Portfolio.service;

import com.practice.Instrument.repository.InstrumentRepository;
import com.practice.Portfolio.dtoRequest.PortfolioRequestDto;
import com.practice.Portfolio.dtoResponse.PortfolioPageResponseDto;
import com.practice.Portfolio.dtoResponse.PortfolioResponseDto;
import com.practice.Portfolio.mappers.PortfolioMapper;
import com.practice.Portfolio.model.PortfolioModel;
import com.practice.Portfolio.repository.PortfolioRepository;
import com.practice.User.model.UserModel;
import com.practice.User.repository.UserRepository;
import com.practice.exceptions.PortfolioNotFoundException;
import com.practice.exceptions.UserNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Validated
public class PortfolioServiceImpl implements PortfolioService {
    private final PortfolioRepository portfolioRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    private static final String PORTFOLIO_NOT_FOUND = "El portafolio con ID %d no fue encontrado";
    private static final String USER_NOT_FOUND = "El usuario con ID %d no fue encontrado";

    @Override
    public PortfolioPageResponseDto findAllPortfolio(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<PortfolioModel> portfolioPage = portfolioRepository.findAll(pageable);

        List<PortfolioResponseDto> portfolioDtos = portfolioPage.getContent()
                .stream()
                .map(portfolio -> modelMapper.map(portfolio, PortfolioResponseDto.class))
                .collect(Collectors.toList());

        return new PortfolioPageResponseDto(
                portfolioDtos,
                portfolioPage.getTotalPages(),
                portfolioPage.getTotalElements()
        );
    }

    @Override
    public PortfolioResponseDto findPortfolioById(Long id) {
        PortfolioModel portfolioModel = portfolioRepository.findById(id)
                .orElseThrow(() -> new PortfolioNotFoundException(String.format(PORTFOLIO_NOT_FOUND, id)));
        return modelMapper.map(portfolioModel, PortfolioResponseDto.class);
    }

    @Override
    public PortfolioResponseDto savePortfolio(@Valid PortfolioRequestDto portfolioRequest) {

       UserModel user = userRepository.findById(portfolioRequest.getUserId())
                .orElseThrow(() -> new UserNotFoundException(String.format(USER_NOT_FOUND, portfolioRequest.getUserId())));


        PortfolioModel portfolio = modelMapper.map(portfolioRequest, PortfolioModel.class);
        portfolio.setUser(user);

        PortfolioModel savedPortfolio = portfolioRepository.save(portfolio);

        return modelMapper.map(savedPortfolio, PortfolioResponseDto.class);
    }

    @Override
    public PortfolioResponseDto updatePortfolio(Long id, @Valid PortfolioRequestDto portfolioRequest) {
        PortfolioModel portfolioModel = portfolioRepository.findById(id)
                .orElseThrow(() -> new PortfolioNotFoundException(String.format(PORTFOLIO_NOT_FOUND, id)));

        modelMapper.map(portfolioRequest, portfolioModel);

        if (portfolioRequest.getUserId() != null) {
            UserModel user = userRepository.findById(portfolioRequest.getUserId())
                    .orElseThrow(() -> new UserNotFoundException(String.format(USER_NOT_FOUND, portfolioRequest.getUserId())));
            portfolioModel.setUser(user);
        }

        PortfolioModel savedPortfolio = portfolioRepository.save(portfolioModel);

        return modelMapper.map(savedPortfolio, PortfolioResponseDto.class);
    }

    @Override
    public void deletePortfolio(Long id) {
        PortfolioModel portfolioModel = portfolioRepository.findById(id)
                .orElseThrow(() -> new PortfolioNotFoundException(String.format(PORTFOLIO_NOT_FOUND, id)));
        portfolioRepository.delete(portfolioModel);
    }

}