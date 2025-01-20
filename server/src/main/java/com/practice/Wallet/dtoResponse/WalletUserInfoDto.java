package com.practice.Wallet.dtoResponse;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WalletUserInfoDto {
    private Long id;
    private String photoUrl;
    private String email;
    private String name;
    private String lastName;
    private int phoneNumber;
    private LocalDateTime birthDate;
}