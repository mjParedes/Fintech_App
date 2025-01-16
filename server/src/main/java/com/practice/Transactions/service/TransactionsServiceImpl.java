package com.practice.Transactions.service;

import com.practice.Transactions.dtoRequest.TransactionRequestDto;
import com.practice.Transactions.dtoResponse.TransactionPageResponseDto;
import com.practice.Transactions.mappers.TransactionMapper;
import com.practice.Transactions.model.TransactionModel;
import com.practice.Transactions.repository.TransactionsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionsServiceImpl implements TransactionsService {
    private final TransactionsRepository transactionsRepository;
    private final TransactionMapper transactionMapper;

    @Override
    public TransactionPageResponseDto findAllTransacctions(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<TransactionModel> transactionPage = transactionsRepository.findAll(pageable);

        List<TransactionRequestDto> transactionDtos = transactionPage.getContent()
                .stream()
                .map(model -> transactionMapper.toDto(model))
                .collect(Collectors.toList());
        return new TransactionPageResponseDto(transactionDtos, transactionPage.getTotalPages(), transactionPage.getTotalElements());
    }
}
