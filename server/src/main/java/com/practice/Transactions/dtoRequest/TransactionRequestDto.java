package com.practice.Transactions.dtoRequest;


import com.practice.Portfolio.dtoRequest.PortfolioRequestDto;
import com.practice.Transactions.dtoResponse.TransactionPortfolioInfoDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Schema(description = "")
public class TransactionRequestDto {
    private Long id;
    private String transactionType;
    private Double unitPrice;
    private Integer quantity;
    private Double commission;
    private List<TransactionPortfolioInfoDto> portfolio;
}