package com.practice.Wallet.repository;

import com.practice.Wallet.model.WalletModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends JpaRepository<WalletModel,Long> {
}
