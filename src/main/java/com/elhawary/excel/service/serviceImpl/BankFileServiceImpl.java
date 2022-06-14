package com.elhawary.excel.service.serviceImpl;

import java.util.Date;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elhawary.excel.model.BankFile;
import com.elhawary.excel.model.ConfigDetails;
import com.elhawary.excel.repository.BankFileRepository;
import com.elhawary.excel.service.BankFileService;


@Service
public class BankFileServiceImpl implements BankFileService{

	@Autowired
	private BankFileRepository bankFileRepository ;

	
	
	@Override
	public BankFile save(BankFile bankFile) {
		return bankFileRepository.save(bankFile);
	}
	
	
	
	public static ConfigDetails createConfigDetails() {
		return new ConfigDetails(new Date(), "mahmoud") ;
	}

	@Override
	public Optional<BankFile> findByFileName(String fileName) {
		return bankFileRepository.findByFileName(fileName);
	}
}
