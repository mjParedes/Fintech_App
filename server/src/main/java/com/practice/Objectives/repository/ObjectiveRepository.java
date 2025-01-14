package com.practice.Objectives.repository;

import com.practice.Objectives.model.ObjectiveModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjectiveRepository extends JpaRepository<ObjectiveModel, Long> {
}
