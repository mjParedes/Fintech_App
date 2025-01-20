package com.practice.Transactions.service;

import com.practice.Transactions.dtoRequest.TransactionRequestDto;
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

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionsServiceImpl implements TransactionsService {
    private final TransactionsRepository transactionsRepository;
    private final TransactionMapper transactionMapper;

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


}
