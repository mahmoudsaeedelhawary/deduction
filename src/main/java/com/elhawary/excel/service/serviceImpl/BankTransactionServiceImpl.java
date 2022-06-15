package com.elhawary.excel.service.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.elhawary.excel.excelHelper.ExcelHelper;
import com.elhawary.excel.model.BankConfiguration;
import com.elhawary.excel.model.BankFile;
import com.elhawary.excel.model.BankMapping;
import com.elhawary.excel.model.BankTransaction;
import com.elhawary.excel.model.BankTransactionStatus;
import com.elhawary.excel.model.ConfigDetails;
import com.elhawary.excel.repository.BankTransactionRepository;
import com.elhawary.excel.service.BankConfigurationService;
import com.elhawary.excel.service.BankFileService;
import com.elhawary.excel.service.BankTransactionService;

@Service
@Transactional
public class BankTransactionServiceImpl implements BankTransactionService {

	@Autowired
	private BankTransactionRepository bankTransactionRepository;

	@Autowired
	private BankFileService bankFileService;

	@Autowired
	private BankConfigurationService bankConfigurationService;

	@Override
	public BankTransaction save(BankTransaction bankDetails) {
		return bankTransactionRepository.save(bankDetails);
	}

	@Override
	public BankTransaction update(BankTransaction bankDetails) {
		return bankTransactionRepository.save(bankDetails);
	}

	@Override
	public List<BankTransaction> findAll() {
		return bankTransactionRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		bankTransactionRepository.deleteById(id);
	}

	@Override
	public BankTransaction findById(Long id) {
		return bankTransactionRepository.findById(id).get();
	}

	public void saveBankTransaction(MultipartFile excel) {
		BankFile bankFile = getBankFile(excel.getOriginalFilename());
		BankMapping bankFileMapping = getBankMapping(bankFile.getFileName());
		List<BankTransaction> bankTransactions = new ExcelHelper().mappingExcelToBankTransaction(excel,
				bankFileMapping);
		for (BankTransaction bankTransaction : bankTransactions) {
			BankTransactionStatus bankTransactionStatus = new BankTransactionStatus();
			if (checkIsEmpty(bankTransaction)) {
				bankTransactionStatus.setNameEnglish("validtion error");
				bankFile.getBankFileStatus().setNameEnglish("Loaded with Errors");

			} else {
				bankTransactionStatus.setNameEnglish("new");
				bankFile.getBankFileStatus().setNameEnglish("Loaded Successfully");
			}
			bankTransaction.setBankTransactionStatus(bankTransactionStatus);
			bankTransaction.setBankFile(bankFile);
			bankTransaction.setConfigDetails(createConfigDetails());
			bankTransactionRepository.save(bankTransaction);
		}
	}

	public BankFile getBankFile(String name) {
		BankFile bankFile = new BankFile();
		Optional<BankFile> optionalBankFile = bankFileService.findByFileName(name);
		if (optionalBankFile.isPresent()) {
			bankFile = bankFileService.findByFileName(name).get();
		}

		return bankFile;
	}

	public BankMapping getBankMapping(String name) {
		BankMapping bankFileMapping = new BankMapping();
		Optional<BankConfiguration> bankConfiguration = bankConfigurationService.findByBankName(name);
		if (bankConfiguration.isPresent()) {
			bankFileMapping = bankConfiguration.get().getBankMapping();
		}
		return bankFileMapping;
	}

	public static boolean checkIsEmpty(BankTransaction bankTransiaction) {
		if (bankTransiaction.getDonatorName().isEmpty() || bankTransiaction.getBankCode().isEmpty()
				|| bankTransiaction.getProjectCode().isEmpty() || bankTransiaction.getToAccnt().isEmpty()
				|| bankTransiaction.getFromAccnt().isEmpty() || bankTransiaction.getAmount() == null)
			return true;

		return false;
	}

	public static ConfigDetails createConfigDetails() {
		return new ConfigDetails(new Date(), "mahmoud");
	}
}
