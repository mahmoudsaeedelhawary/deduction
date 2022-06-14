package com.elhawary.excel.service;

import java.util.Optional;

import com.elhawary.excel.model.BankConfiguration;
public interface BankConfigurationService {

	Optional<BankConfiguration> findByBankName(String bankName) ;
	
	BankConfiguration save(BankConfiguration bankConfiguration) ;
	
	BankConfiguration update(BankConfiguration bankConfiguration) ;
	
	BankConfiguration findById(Long id) ;
}
