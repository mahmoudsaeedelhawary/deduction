package com.elhawary.excel.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elhawary.excel.model.BankConfiguration;

@Repository
public interface BankConfigurationRepository extends JpaRepository<BankConfiguration, Long> {
	
	//Optional<BankConfiguration> findByBankBankName(String bankName) ;
	
	Optional<BankConfiguration> findByBankName(String bankName) ;
}
