package com.practice.Instrument.repository;

import com.practice.Instrument.model.InstrumentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstrumentRepository extends JpaRepository<InstrumentModel,Long> {
}
