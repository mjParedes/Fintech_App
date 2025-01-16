package com.practice.Wallet.service;

import com.practice.Wallet.dtoResponse.WalletPageResponseDto;

public interface WalletService {
    WalletPageResponseDto findAllWallet(int page, int size);
}
