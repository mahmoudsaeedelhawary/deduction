package com.elhawary.excel.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.elhawary.excel.model.BankTransaction;

public interface BankTransactionService {

	BankTransaction save(BankTransaction bankDetails) ;
	
	BankTransaction update(BankTransaction bankDetails) ;
	
	List<BankTransaction> findAll() ;
	
	void delete(Long id) ;
	
	BankTransaction findById(Long id) ;
	
	public void saveBankTransaction(MultipartFile excel) ;
}
