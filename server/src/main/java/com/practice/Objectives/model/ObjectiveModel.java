package com.practice.Objectives.model;

import com.practice.FinancingProfile.model.FinancingProfileModel;
import com.practice.Objectives.Enum.EnumFrequency;
import com.practice.Objectives.Enum.EnumObjectiveType;
import com.practice.Objectives.Enum.EnumPriority;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(name = "objectives")
public class ObjectiveModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    @Enumerated(EnumType.STRING)
    @Column(name = "objectuve_type")
    private EnumObjectiveType enumObjectiveType;
    @Column(name = "amount_objective")
    private Double amountObjective;
    @Column(name = "annual_progress")
    private Double annualProgress;
    @Enumerated(EnumType.STRING)
    @Column(name = "priority")
    private EnumPriority enumPriority;
    @Enumerated(EnumType.STRING)
    @Column(name = "frequency")
    private EnumFrequency enumFrequency;
    @Column(name = "start_date")
    private LocalDateTime startDate = LocalDateTime.now();
    @Column(name = "target_date")
    private LocalDateTime targetDate = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "financing_profile_id")
    private FinancingProfileModel financingProfile;

}
