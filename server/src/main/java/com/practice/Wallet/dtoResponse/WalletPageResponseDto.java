package com.practice.Wallet.dtoResponse;

import com.practice.Wallet.dtoRequest.WalletRequestDto;

import java.util.List;

public record WalletPageResponseDto(
        List<WalletRequestDto> walletRequests,
//        Long id,
//        Long userId,
        int totalPage,
        long totalElements
) {
}
