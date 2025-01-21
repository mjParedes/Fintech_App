package com.practice.Transactions.model;

import com.practice.Portfolio.model.PortfolioModel;
import com.practice.Transactions.Enum.EnumTransactionType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "transactions")
public class TransactionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "transaction_type")
    @Enumerated(EnumType.STRING)
    EnumTransactionType enumTransactionType;

    @Column(name = "unit_price")
    private Double unitPrice;

    private Integer quantity;
    private Double commission;
    private LocalDate operationDate = LocalDate.now();

    @ManyToOne(targetEntity = PortfolioModel.class)
    @JoinColumn(name = "portfolio_id")
    private PortfolioModel portfolio;
}
