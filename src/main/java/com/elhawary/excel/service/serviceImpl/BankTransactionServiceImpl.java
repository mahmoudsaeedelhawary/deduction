package com.elhawary.excel.service.serviceImpl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.elhawary.excel.excelHelper.ExcelHelper;
import com.elhawary.excel.model.BankTransaction;
import com.elhawary.excel.model.ConfigDetails;
import com.elhawary.excel.repository.BankTransactionRepository;
import com.elhawary.excel.service.BankTransactionService;

@Service
@Transactional
public class BankTransactionServiceImpl implements BankTransactionService {

	@Autowired
	private BankTransactionRepository bankDetailsRepository;
	
	@Override
	public BankTransaction save(BankTransaction bankDetails) {
		return bankDetailsRepository.save(bankDetails);
	}

	@Override
	public BankTransaction update(BankTransaction bankDetails) {
		return bankDetailsRepository.save(bankDetails);
	}

	@Override
	public List<BankTransaction> findAll() {
		return bankDetailsRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		bankDetailsRepository.deleteById(id);
	}

	@Override
	public BankTransaction findById(Long id) {
		return bankDetailsRepository.findById(id).get();
	}

	public void saveBankTransaction(MultipartFile excel) {
		List<BankTransaction> bankTransactions = new ExcelHelper().mappingExcelToBankTransaction(excel);
		bankDetailsRepository.saveAll(bankTransactions) ;
	}
	
	public static ConfigDetails createConfigDetails() {
		return new ConfigDetails(new Date(), "mahmoud") ;
	}
}
