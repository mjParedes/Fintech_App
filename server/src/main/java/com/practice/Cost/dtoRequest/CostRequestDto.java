package com.practice.Cost.dtoRequest;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Schema(description = "DTO para representar un Costo")
public class CostRequestDto {
    private Long id;
    Long userId;
    private String type;
    private String description;
    private String category;
    private Double amount;
}
