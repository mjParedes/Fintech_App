package com.practice.Wallet.mappers;

import com.practice.User.model.UserModel;
import com.practice.Wallet.dtoRequest.WalletRequestDto;
import com.practice.Wallet.dtoResponse.WalletResponseDto;
import com.practice.Wallet.dtoResponse.WalletUserInfoDto;
import com.practice.Wallet.model.WalletModel;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
@RequiredArgsConstructor
public class WalletMapper {
    private final ModelMapper modelMapper;


    public WalletModel toEntity(WalletRequestDto dto){
        return modelMapper.map(dto,WalletModel.class);
    }

    public WalletRequestDto toDto(WalletModel walletModel) {
        if (walletModel == null) {
            return null;
        }

        WalletRequestDto dto = new WalletRequestDto();
        dto.setId(walletModel.getId());
        dto.setCurrentBalance(walletModel.getCurrentBalance());

        WalletUserInfoDto userInfo = toWalletUserResponseDto(walletModel.getUser());
        List<WalletUserInfoDto> userInfoList = Collections.singletonList(userInfo);
//        dto.setUser(userInfoList);

        return dto;
    }
    public WalletResponseDto toDtoWallet(WalletModel walletModel) {
        if (walletModel == null) {
            return null;
        }

        WalletResponseDto dto = modelMapper.map(walletModel, WalletResponseDto.class);
        dto.setUser(toWalletUserResponseDto(walletModel.getUser()));
        return dto;
    }

    private WalletUserInfoDto toWalletUserResponseDto(UserModel userModel) {
        if (userModel == null) {
            return null;
        }
        return WalletUserInfoDto.builder()
                .id(userModel.getId())
                .photoUrl(userModel.getPhotoUrl())
                .email(userModel.getEmail())
                .name(userModel.getName())
                .lastName(userModel.getLastName())
                .phoneNumber(userModel.getPhoneNumber())
                .birthDate(userModel.getBirthDate())
                .build();
    }
}