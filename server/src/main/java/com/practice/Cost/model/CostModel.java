package com.practice.Cost.model;

import com.practice.User.model.UserModel;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(name = "costs")
public class CostModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = UserModel.class)
    @JoinColumn(name = "user_id")
    private UserModel user;

    private String type;
    private String description;
    private String category;
    private Double amount;
    private LocalDateTime date = LocalDateTime.now();
    private LocalDateTime updateDate = LocalDateTime.now();
}
