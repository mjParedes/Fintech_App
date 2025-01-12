package com.practice.Instrument.service;

import com.practice.Instrument.repository.InstrumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InstrumentServiceImpl implements InstrumentService{
    private final InstrumentRepository instrumentRepository;
}
