package com.practice.Wallet.dtoResponse;

public record WalletResponseCreateDto(
        Long id ,
        Double currentBalance,
        Long idUser
) {
}
