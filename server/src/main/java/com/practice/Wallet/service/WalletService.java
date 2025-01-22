package com.practice.Wallet.service;

import com.practice.Wallet.dtoRequest.WalletCreateRequestDto;
import com.practice.Wallet.dtoRequest.WalletUpdateRequestDto;
import com.practice.Wallet.dtoResponse.WalletPageResponseDto;
import com.practice.Wallet.dtoResponse.WalletResponseCreateDto;
import com.practice.Wallet.dtoResponse.WalletResponseDto;

public interface WalletService {
    WalletPageResponseDto findAllWallet(int page, int size);

    WalletResponseDto  getWalletById(Long id);

    WalletResponseCreateDto createWallet(WalletCreateRequestDto walletCreateRequestDto);

    WalletResponseDto updateWallet(Long id , WalletUpdateRequestDto walletUpdateRequestDto);

    void deleteWallet(Long id);
}
