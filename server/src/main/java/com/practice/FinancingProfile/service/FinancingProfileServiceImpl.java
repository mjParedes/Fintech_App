package com.practice.FinancingProfile.service;

import com.practice.FinancingProfile.dtoRequest.FinancingProfileOnboardingDto;
import com.practice.FinancingProfile.dtoRequest.FinancingProfileRequestDto;
import com.practice.FinancingProfile.dtoResponse.FinancingProfilePageResponse;
import com.practice.FinancingProfile.mappers.FinancingProfileMapper;
import com.practice.FinancingProfile.model.FinancingProfileModel;
import com.practice.FinancingProfile.repository.FinancingProfileRepository;
import com.practice.User.model.UserModel;
import com.practice.User.repository.UserRepository;
import com.practice.exceptions.UserNotFoundException;
import jakarta.validation.Valid;
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

    private final UserRepository userRepository;

    @Override
    public FinancingProfilePageResponse findAllFinancingProfiles(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<FinancingProfileModel> financingPage = financingProfileRepository.findAll(pageable);

        List<FinancingProfileRequestDto> financingProfileDtos = financingPage.getContent().stream()
                .map(dto -> financingProfileMapper.toDto(dto))
                .collect(Collectors.toList());

        return new FinancingProfilePageResponse(financingProfileDtos, financingPage.getTotalPages(), financingPage.getTotalElements());
    }

    @Override
    public FinancingProfileModel saveOnboarding(@Valid FinancingProfileOnboardingDto onboardingDto) {
        UserModel userModel = userRepository.findById(onboardingDto.getUserId()).orElseThrow(() ->
                new UserNotFoundException("El usuario con ID " + onboardingDto.getUserId() + " no fue encontrado."));

        FinancingProfileModel financingProfileModel = new FinancingProfileModel();
        financingProfileModel.setEnumRiskProfile(onboardingDto.getEnumRiskProfile());
        financingProfileModel.setUser(userModel);

        return financingProfileRepository.save(financingProfileModel);
    }
}
