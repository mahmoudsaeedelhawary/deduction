package com.elhawary.excel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elhawary.excel.model.BankTransaction;


@Repository
public interface BankTransactionRepository extends JpaRepository<BankTransaction, Long>{

}
