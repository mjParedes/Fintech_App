package com.practice.FinancingProfile.dtoResponse;

import com.practice.FinancingProfile.dtoRequest.FinancingProfileRequestDto;

import java.util.List;

public record FinancingProfilePageResponse(
        List<FinancingProfileResponseDto> financingProfiles,
        int totalPages,
        long totalElements) {
}
