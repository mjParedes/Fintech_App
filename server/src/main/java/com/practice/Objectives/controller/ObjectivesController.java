package com.practice.Objectives.controller;

import com.practice.Objectives.dtoRequest.ObjectivesCreateRequestDto;
import com.practice.Objectives.dtoRequest.ObjectivesUpdateRequestDto;
import com.practice.Objectives.dtoResponse.ObjectivePageResponse;
import com.practice.Objectives.dtoResponse.ObjectivesResponseCreateDto;
import com.practice.Objectives.dtoResponse.ObjectivesResponseDto;
import com.practice.Objectives.service.ObjectivesServiceImpl;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/objective")
@Validated
@RequiredArgsConstructor
@Tag(name = "Objetivos", description = "Objectives API")
public class ObjectivesController {
    private final ObjectivesServiceImpl objectivesServiceImpl;

    @ApiResponse(responseCode = "200", description = "Objetivos obtenidos correctamente")
    @GetMapping("/")
    public ResponseEntity<ObjectivePageResponse> getAllObjectives(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        ObjectivePageResponse response = objectivesServiceImpl.findAllObjectives(page, size);
        return ResponseEntity.ok(response);
    }

    ;

    @GetMapping("/{id}")
    public ResponseEntity<ObjectivesResponseDto> findObjectiveById(@PathVariable Long id) {
        ObjectivesResponseDto response = objectivesServiceImpl.findObjectiveById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Transactional
    @PatchMapping("/{id}")
    public ResponseEntity<ObjectivesResponseDto> updateObjective(@PathVariable Long id, @Validated @RequestBody ObjectivesUpdateRequestDto objectivesUpdateRequestDto) {
        ObjectivesResponseDto updateObject = objectivesServiceImpl.updateObjective(id, objectivesUpdateRequestDto);
        return new ResponseEntity<>(updateObject, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ObjectivesResponseCreateDto> createObject(@RequestBody @Validated ObjectivesCreateRequestDto objectivesCreateRequestDto) {
        ObjectivesResponseCreateDto response = objectivesServiceImpl.createObjective(objectivesCreateRequestDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteObjective(@PathVariable Long id) {
        objectivesServiceImpl.deleteObjective(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
