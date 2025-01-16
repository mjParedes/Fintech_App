package com.practice.FinancingProfile.service;

import com.practice.FinancingProfile.dtoResponse.FinancingProfilePageResponse;

public interface FinancingProfileService {
    FinancingProfilePageResponse findAllFinancingProfiles(int page, int size);
}
