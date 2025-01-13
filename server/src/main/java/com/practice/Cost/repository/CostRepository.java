package com.practice.Cost.repository;


import com.practice.Cost.model.CostModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CostRepository extends JpaRepository<CostModel,Long> {
}
