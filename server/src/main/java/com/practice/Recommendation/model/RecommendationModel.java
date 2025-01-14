package com.practice.Recommendation.model;

import com.practice.Instrument.model.InstrumentModel;
import com.practice.Recommendation.Enum.EnumRecommendationType;
import com.practice.User.model.UserModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "recommendations")
public class RecommendationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "recommendation_type")
    @Enumerated(EnumType.STRING)
    EnumRecommendationType enumRecommendationType;
    private String motion;
    @Column(name = "create_date")
    private LocalDateTime createDate = LocalDateTime.now();
    private Boolean state;

    @ManyToOne
    @JoinColumn(name = "user_id")
    UserModel user;
    @ManyToOne
    @JoinColumn(name = "instrument_id")
    InstrumentModel instrument;

}
