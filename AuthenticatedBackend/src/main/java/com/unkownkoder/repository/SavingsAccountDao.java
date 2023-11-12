package com.unkownkoder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unkownkoder.models.SavingsAccount;

@Repository
public interface SavingsAccountDao extends JpaRepository<SavingsAccount, Long> {

    SavingsAccount findByAccountNumber(int accountNumber);
}