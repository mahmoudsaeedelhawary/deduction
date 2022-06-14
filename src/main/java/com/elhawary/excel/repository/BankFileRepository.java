package com.elhawary.excel.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elhawary.excel.model.BankFile;

@Repository
public interface BankFileRepository extends JpaRepository<BankFile, Long> {

	Optional<BankFile> findByFileName(String fileName);
}
