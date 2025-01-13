package com.practice.FinancingProfile.repository;

import com.practice.FinancingProfile.model.FinancingProfileModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinancingProfileRepository extends JpaRepository<FinancingProfileModel, Long> {
}
