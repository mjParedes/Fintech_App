package com.practice.Wallet.service;

import com.practice.User.model.UserModel;
import com.practice.User.repository.UserRepository;
import com.practice.Wallet.dtoRequest.WalletCreateRequestDto;
import com.practice.Wallet.dtoRequest.WalletRequestDto;
import com.practice.Wallet.dtoResponse.WalletPageResponseDto;
import com.practice.Wallet.dtoResponse.WalletResponseCreateDto;
import com.practice.Wallet.dtoResponse.WalletResponseDto;
import com.practice.Wallet.mappers.WalletMapper;
import com.practice.Wallet.model.WalletModel;
import com.practice.Wallet.repository.WalletRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {
    private final WalletRepository walletRepository;
    private final WalletMapper walletMapper;
    private final UserRepository userRepository;

    @Override
    public WalletPageResponseDto findAllWallet(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<WalletModel> walletPage = walletRepository.findAll(pageable);

        List<WalletRequestDto> walletDtos = walletPage.getContent()
                .stream()
                .map(walletMapper::toDto)
                .collect(Collectors.toList());


        return new WalletPageResponseDto(walletDtos, walletPage.getTotalPages(), walletPage.getTotalElements());
    }

    @Override
    public WalletResponseDto getWalletById(Long id) {
        WalletModel wallet =
                walletRepository.findById(id).orElseThrow(
                        () -> new IllegalArgumentException("Wallet con ID no " +
                                "encontrado"));
        return walletMapper.toDtoWallet(wallet);
    }

    @Override
    public WalletResponseCreateDto createWallet(@Valid WalletCreateRequestDto walletCreateRequestDto) {

        Double currentBalance = walletCreateRequestDto.currentBalance();
        Long idUser = walletCreateRequestDto.idUser();
        UserModel userModel = userRepository.findById(idUser).orElseThrow();
        WalletModel walletModel = WalletModel.builder()
                .currentBalance(currentBalance)
                .user(userModel)
                .dateLastUpdate(LocalDateTime.now())
                .build();
        WalletModel walletCreated = walletRepository.save(walletModel);
        return new WalletResponseCreateDto(walletCreated.getId(),currentBalance,idUser);
    }
}
