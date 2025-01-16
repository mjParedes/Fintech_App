package com.practice.Wallet.mappers;


import com.practice.Wallet.dtoRequest.WalletRequestDto;
import com.practice.Wallet.model.WalletModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class WalletMapper {
    private final ModelMapper modelMapper;


    public WalletMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public WalletRequestDto toDto(WalletModel walletModel) {
        return modelMapper.map(walletModel, WalletRequestDto.class);
    }


}
