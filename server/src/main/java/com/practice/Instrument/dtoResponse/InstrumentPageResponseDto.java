package com.practice.Instrument.dtoResponse;

import com.practice.Instrument.dtoRequest.InstrumentRequestDto;

import java.util.List;

public record InstrumentPageResponseDto(
        List<InstrumentRequestDto> instrumentDtos,
        int totalPage,
        long totalElements
) {
}
