package com.practice.FinancingProfile.service;

import com.practice.FinancingProfile.dtoRequest.FinancingProfileRequestDto;
import com.practice.FinancingProfile.dtoResponse.FinancingProfilePageResponse;
import com.practice.FinancingProfile.mappers.FinancingProfileMapper;
import com.practice.FinancingProfile.model.FinancingProfileModel;
import com.practice.FinancingProfile.repository.FinancingProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FinancingProfileServiceImpl implements FinancingProfileService {
    private final FinancingProfileRepository financingProfileRepository;
    private final FinancingProfileMapper financingProfileMapper;

    @Override
    public FinancingProfilePageResponse findAllFinancingProfiles(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<FinancingProfileModel> financingPage = financingProfileRepository.findAll(pageable);

        List<FinancingProfileRequestDto> financingProfileDtos = financingPage.getContent().stream()
                .map(dto -> financingProfileMapper.toDto(dto))
                .collect(Collectors.toList());

        return new FinancingProfilePageResponse(financingProfileDtos, financingPage.getTotalPages(), financingPage.getTotalElements());
    }
}
