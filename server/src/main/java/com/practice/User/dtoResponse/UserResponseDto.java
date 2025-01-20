package com.practice.User.dtoResponse;

import com.practice.Cost.dtoRequest.CostRequestDto;
import com.practice.FinancingProfile.dtoRequest.FinancingProfileRequestDto;
import com.practice.Notification.dtoRequest.NotificationRequestDto;
import com.practice.Portfolio.dtoRequest.PortfolioRequestDto;
import com.practice.Recommendation.dtoRequest.RecommendationRequestDto;
import com.practice.Wallet.dtoRequest.WalletRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {
    private Long id;
    private String photoUrl;
    private String email;
    private String name;
    private String lastName;
    private int phoneNumber;
    private LocalDateTime birthDate;
    private LocalDateTime registerDate;
    private LocalDateTime lastLogin;

    // Para el perfil de financiamiento, probablemente quieras un DTO específico
    private FinancingProfileRequestDto financingProfile;

    // Para las colecciones, usamos DTOs simplificados o solo IDs según necesidad
    private List<CostRequestDto> costs;
    private List<WalletRequestDto> wallets;
    private List<NotificationRequestDto> notifications;
    private List<RecommendationRequestDto> recommendations;
    private List<PortfolioRequestDto> portfolios;
    private Set<String> roles;
}
