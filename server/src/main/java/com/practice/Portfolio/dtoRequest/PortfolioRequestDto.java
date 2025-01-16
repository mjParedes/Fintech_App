package com.practice.Portfolio.dtoRequest;

import com.practice.Instrument.model.InstrumentModel;
import com.practice.Transactions.dtoRequest.TransactionRequestDto;
import com.practice.Transactions.model.TransactionModel;
import com.practice.User.model.UserModel;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@Schema(description = "")
public class PortfolioRequestDto {
    private Long id;
    private Integer quantity;
    private Double priceBuy;
    private List<TransactionRequestDto> transactionModels;
    private String userId;
    private String instrumentId;

}
