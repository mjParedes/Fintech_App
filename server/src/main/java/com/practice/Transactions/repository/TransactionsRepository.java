package com.practice.Transactions.repository;

import com.practice.Transactions.model.TransactionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionsRepository extends JpaRepository<TransactionModel, Long> {
}
