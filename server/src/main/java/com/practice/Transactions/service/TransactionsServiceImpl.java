package com.practice.Transactions.service;

import com.practice.Portfolio.model.PortfolioModel;
import com.practice.Portfolio.repository.PortfolioRepository;
import com.practice.Transactions.Enum.EnumTransactionType;
import com.practice.Transactions.dtoRequest.TransactionRequestDto;
import com.practice.Transactions.dtoRequest.TransactionsCreateRequestDto;
import com.practice.Transactions.dtoResponse.TransactionCreateResponseDto;
import com.practice.Transactions.dtoResponse.TransactionPageResponseDto;
import com.practice.Transactions.dtoResponse.TransactionResponseDto;
import com.practice.Transactions.mappers.TransactionMapper;
import com.practice.Transactions.model.TransactionModel;
import com.practice.Transactions.repository.TransactionsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionsServiceImpl implements TransactionsService {
    private final TransactionsRepository transactionsRepository;
    private final TransactionMapper transactionMapper;
    private final PortfolioRepository portfolioRepository;

    @Override
    public TransactionPageResponseDto findAllTransactions(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<TransactionModel> transactionPage = transactionsRepository.findAll(pageable);

        List<TransactionRequestDto> transactionDtos = transactionPage.getContent()
                .stream()
                .map(transactionMapper::toDto)
                .collect(Collectors.toList());
        return new TransactionPageResponseDto(transactionDtos, transactionPage.getTotalPages(), transactionPage.getTotalElements());
    }

    @Override
    public TransactionResponseDto getTransactionById(Long id) {
        TransactionModel transaction = transactionsRepository.findById(id).orElseThrow();
        return transactionMapper.toDtoTransaction(transaction);
    }

    @Override
    public TransactionCreateResponseDto createTransaction(TransactionsCreateRequestDto transactionsCreateRequestDto) {

        PortfolioModel portfolioModel = portfolioRepository.findById(transactionsCreateRequestDto.idPortfolio()).orElseThrow();
        EnumTransactionType transactionType;

        try {
            transactionType = EnumTransactionType.valueOf(transactionsCreateRequestDto.transactionType());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e);
        }


        TransactionModel transactionModel = TransactionModel
                .builder()
                .enumTransactionType(transactionType)
                .unitPrice(transactionsCreateRequestDto.unitPrice())
                .quantity(transactionsCreateRequestDto.quantity())
                .commission(transactionsCreateRequestDto.commission())
                .date(LocalDateTime.now())
                .portfolio(portfolioModel)
                .build();
        transactionsRepository.save(transactionModel);
        return new TransactionCreateResponseDto(transactionModel.getId(),
                transactionsCreateRequestDto.transactionType(), transactionModel.getUnitPrice(),
                transactionModel.getQuantity(), transactionModel.getCommission(), transactionModel.getPortfolio().getId());
    }

    @Override
    public void deleteTransaction(Long id) {

        if (!transactionsRepository.existsById(id)) {
            throw new IllegalArgumentException("La transacion con id " + id + " no existe");
        }

        transactionsRepository.deleteById(id);
    }


}
