package com.practice.Portfolio.model;

import com.practice.Instrument.model.InstrumentModel;
import com.practice.Transactions.model.TransactionModel;
import com.practice.User.model.UserModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "portfolio")
public class PortfolioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantity;
    @Column(name = "price_buy")
    private Double priceBuy;
    @Column(name = "date_buy")
    private LocalDateTime dateBuy = LocalDateTime.now();

    @OneToMany(mappedBy = "portfolio")
    private Set<TransactionModel> transactionModels = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "user_id")
    UserModel user;
    @ManyToOne
    @JoinColumn(name = "instrument_id")
    InstrumentModel instrument;


}
