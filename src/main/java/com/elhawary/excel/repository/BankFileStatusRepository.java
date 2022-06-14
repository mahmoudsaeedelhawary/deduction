package com.elhawary.excel.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elhawary.excel.model.BankFileStatus;

@Repository
@Transactional
public interface BankFileStatusRepository extends JpaRepository<BankFileStatus, Long> {

}
