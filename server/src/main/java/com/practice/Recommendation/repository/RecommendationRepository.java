package com.practice.Recommendation.repository;

import com.practice.Recommendation.model.RecommendationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecommendationRepository extends JpaRepository<RecommendationModel, Long> {
}
