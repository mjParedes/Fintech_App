package com.practice.FinancingProfile.service;

import com.practice.FinancingProfile.repository.FinancingProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FinancingProfileServiceImpl implements FinancingProfileService{
    private final FinancingProfileRepository financingProfileRepository;
}
