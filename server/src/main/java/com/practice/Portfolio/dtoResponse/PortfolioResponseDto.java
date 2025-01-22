package com.practice.Portfolio.dtoResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PortfolioResponseDto {
    private Long id;
    private Integer quantity;
    private Double purchasePrice;
    private LocalDate purchaseDate;
    private Long userId;
}

