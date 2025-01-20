package com.practice.Transactions.dtoResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionPortfolioInfoDto {
    private Long id;
    private Integer quantity;
    private Double priceBuy;
}
