package com.practice.Instrument.model;

import com.practice.Instrument.Enum.EnumInvestmentType;
import com.practice.Portfolio.model.PortfolioModel;
import com.practice.Recommendation.model.RecommendationModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "instruments")
public class InstrumentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ticker;
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(name = "investment_type")
    EnumInvestmentType enumInvestmentType;
    private String sector;
    private Double quotes;
    private String description;
    private String divisa;
    private Boolean state;

    @OneToMany(mappedBy = "instrument")
    private Set<RecommendationModel> recommendationModel = new HashSet<>();
    @OneToMany(mappedBy = "instrument")
    private Set<PortfolioModel> portfolioModel = new HashSet<>();

}
