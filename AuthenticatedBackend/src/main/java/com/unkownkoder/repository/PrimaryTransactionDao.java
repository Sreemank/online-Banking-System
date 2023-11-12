package com.unkownkoder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unkownkoder.models.PrimaryTransaction;

import java.util.List;

@Repository
public interface PrimaryTransactionDao extends JpaRepository<PrimaryTransaction, Long> {

    List<PrimaryTransaction> findAll();
}