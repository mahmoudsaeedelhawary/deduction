package com.elhawary.excel.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.elhawary.excel.model.Bank;
import com.elhawary.excel.model.BankConfiguration;
import com.elhawary.excel.model.BankFile;
import com.elhawary.excel.model.BankFileStatus;
import com.elhawary.excel.model.BankMapping;
import com.elhawary.excel.model.BankMappingBuilder;
import com.elhawary.excel.model.BankTransaction;
import com.elhawary.excel.repository.BankConfigurationRepository;
import com.elhawary.excel.repository.BankFileRepository;
import com.elhawary.excel.response.Response;
import com.elhawary.excel.service.BankConfigurationService;
import com.elhawary.excel.service.BankFileService;
import com.elhawary.excel.service.BankTransactionService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@CrossOrigin("http://localhost:4200")
public class BankTransactionController {

	@Autowired
	private BankFileService bankFileService;

	@Autowired
	private BankTransactionService bankTransactionService;

	@Autowired
	private BankConfigurationService bankConfigurationService;

	@PostMapping("shareExcelFile")
	public ResponseEntity<Response> shareExcelFile(@RequestParam("excel") MultipartFile excel) {

		createBankFile(excel.getOriginalFilename());

		createBankConfiguration(excel.getOriginalFilename());

		bankTransactionService.saveBankTransaction(excel);
		return new ResponseEntity<Response>(new Response("success"), HttpStatus.CREATED);

	}

	public void createBankFile(String name) {
		Optional<BankFile> optionalBankFile = bankFileService.findByFileName(name);
		if (optionalBankFile.isEmpty()) {
			BankFile bankFile = new BankFile();
			BankFileStatus bankFileStatus = new BankFileStatus();
			bankFileStatus.setNameArabic("new");
			bankFileStatus.setNameEnglish("new");
			bankFile.setBankFileStatus(bankFileStatus);
			bankFile.setFileName(name);
			bankFileService.save(bankFile);
		}

	}

	public void createBankConfiguration(String name) {
//		Optional<BankConfiguration> optionalBankConfiguration = bankConfigurationService.findByBankName(name);
//		if (optionalBankConfiguration.isEmpty()) {
			Bank bank = new Bank();
			bank.setBankName(name);
			BankConfiguration bankConfiguration1 = new BankConfiguration();
			BankMapping bankFileMapping1 = new BankMappingBuilder().
					setAmount("amnt").setFromAccnt("From_Accnt").setToAccnt("To_Accnt").setBankCode("BANK_CODE")
					.setProjectCode("PCODE").setDonatorName("From_Name").getBankMapping();
			bankConfiguration1.setBankMapping(bankFileMapping1);
			bankConfiguration1.setBankName(name);
			bankConfiguration1.setBank(bank);
			bankConfigurationService.save(bankConfiguration1);
			
			BankConfiguration bankConfiguration2 = new BankConfiguration();
			BankMapping bankFileMapping2= new BankMappingBuilder().
					setAmount("AMNT").setFromAccnt("From_Accnt").setToAccnt("To_Accnt").setBankCode("BANK_CODE")
					.setProjectCode("PCODE").setDonatorName("From_Name").setDeductionDate("Post_Date").getBankMapping();
			bankConfiguration2.setBankMapping(bankFileMapping2);
			bankConfiguration2.setBankName(name);
			bankConfiguration2.setBank(bank);
			bankConfigurationService.save(bankConfiguration2);
			
			BankConfiguration bankConfiguration3 = new BankConfiguration();
			BankMapping bankFileMapping3 = new BankMappingBuilder().
					setAmount("AMNT").setFromAccnt("From_Accnt").setToAccnt("To_Accnt").setBankCode("BANK_CODE")
					.setProjectCode("PCODE").setDonatorName("From_Name").setDeductionDate("Post_Date").getBankMapping();
			bankConfiguration3.setBankMapping(bankFileMapping3);
			bankConfiguration3.setBankName(name);
			bankConfiguration3.setBank(bank);
			bankConfigurationService.save(bankConfiguration3);	
//		}
	}

	@GetMapping("getAllUsers")
	public ResponseEntity<List<BankTransaction>> getAllUsers() {
		List<BankTransaction> list = bankTransactionService.findAll();
		return new ResponseEntity<List<BankTransaction>>(list, HttpStatus.OK);
	}

}
