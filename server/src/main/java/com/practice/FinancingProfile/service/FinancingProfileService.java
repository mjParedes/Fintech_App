package com.practice.FinancingProfile.service;

import com.practice.FinancingProfile.dtoRequest.FinancingProfileOnboardingDto;
import com.practice.FinancingProfile.dtoResponse.FinancingProfilePageResponse;
import com.practice.FinancingProfile.model.FinancingProfileModel;
import jakarta.validation.Valid;

public interface FinancingProfileService {
    FinancingProfilePageResponse findAllFinancingProfiles(int page, int size);

    FinancingProfileModel saveOnboarding(@Valid FinancingProfileOnboardingDto onboardingDto);
}
