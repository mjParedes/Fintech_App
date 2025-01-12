package com.practice.Instrument.controller;


import com.practice.Instrument.service.InstrumentServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Validated
@RequestMapping
@Tag(name = "Instrumento", description = "Instrumento API")
public class InstrumentController {
    private final InstrumentServiceImpl instrumentServiceImpl;
}
