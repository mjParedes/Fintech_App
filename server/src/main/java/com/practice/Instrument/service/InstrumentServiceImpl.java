package com.practice.Instrument.service;

import com.practice.Instrument.dtoRequest.InstrumentRequestDto;
import com.practice.Instrument.dtoResponse.InstrumentPageResponseDto;
import com.practice.Instrument.mappers.InstrumentMapper;
import com.practice.Instrument.model.InstrumentModel;
import com.practice.Instrument.repository.InstrumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InstrumentServiceImpl implements InstrumentService {
    private final InstrumentRepository instrumentRepository;
    private final InstrumentMapper instrumentMapper;

    @Override
    public InstrumentPageResponseDto findAllInstrument(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<InstrumentModel> instrumentPage = instrumentRepository.findAll(pageable);

        List<InstrumentRequestDto> instrumentDtos = instrumentPage.getContent()
                .stream()
                .map(dto -> instrumentMapper.toDto(dto))
                .collect(Collectors.toList());

        return new InstrumentPageResponseDto(instrumentDtos, instrumentPage.getTotalPages(), instrumentPage.getTotalElements());
    }
}
