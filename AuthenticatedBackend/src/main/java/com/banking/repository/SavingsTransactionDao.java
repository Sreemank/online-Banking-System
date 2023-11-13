package com.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banking.models.SavingsTransaction;

import java.util.List;

@Repository
public interface SavingsTransactionDao extends JpaRepository<SavingsTransaction, Long> {

    List<SavingsTransaction> findAll();
}