package com.practice.Objectives.controller;

import com.practice.Objectives.service.ObjectivesServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@Validated
@RequiredArgsConstructor
@Tag(name = "Objetivos", description = "Objectives API")
public class ObjectivesController {
    private ObjectivesServiceImpl objectivesServiceImpl;
}
