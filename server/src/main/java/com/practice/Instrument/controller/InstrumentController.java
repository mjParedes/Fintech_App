package com.practice.Instrument.controller;


import com.practice.Instrument.dtoRequest.InstrumentRequestDto;
import com.practice.Instrument.dtoResponse.InstrumentPageResponseDto;
import com.practice.Instrument.service.InstrumentServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Validated
@RequestMapping
@Tag(name = "Instrumento", description = "Instrumento API")
public class InstrumentController {
    private final InstrumentServiceImpl instrumentServiceImpl;

    @GetMapping("/instrument")
    public ResponseEntity<InstrumentPageResponseDto> findAllInstruments(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        InstrumentPageResponseDto response = instrumentServiceImpl.findAllInstrument(page, size);
        return ResponseEntity.ok(response);
    }

}
