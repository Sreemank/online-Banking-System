package com.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banking.models.SavingsAccount;

@Repository
public interface SavingsAccountDao extends JpaRepository<SavingsAccount, Long> {

    SavingsAccount findByAccountNumber(int accountNumber);
}