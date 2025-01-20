package com.practice.Wallet.dtoResponse;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WalletResponseDto {
    private Long id;
    private Double currentBalance;
    private WalletUserInfoDto user;
}
