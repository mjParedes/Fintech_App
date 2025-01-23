package com.practice.Wallet.model;

import com.practice.User.model.UserModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(name = "wallet")
@Builder
@AllArgsConstructor
public class WalletModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne()
    @JoinColumn(name = "user_id")
    UserModel user;
    @Column(name = "current_balance")
    private Double currentBalance;
    @Column(name = "date_last_update")
    private LocalDateTime dateLastUpdate = LocalDateTime.now();
}
