package com.elhawary.excel.service.serviceImpl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elhawary.excel.model.BankConfiguration;
import com.elhawary.excel.repository.BankConfigurationRepository;
import com.elhawary.excel.service.BankConfigurationService;

@Service
@Transactional
public class BankConfigurationServiceImpl implements BankConfigurationService {

	@Autowired
	private BankConfigurationRepository bankConfigurationRepository ;
	
	@Override
	public BankConfiguration save(BankConfiguration bankConfiguration) {
		
		return bankConfigurationRepository.save(bankConfiguration);
	}

	@Override
	public BankConfiguration update(BankConfiguration bankConfiguration) {
		return bankConfigurationRepository.save(bankConfiguration);
	}

	@Override
	public BankConfiguration findById(Long id) {
		return bankConfigurationRepository.findById(id).get();
	}

	@Override
	public Optional<BankConfiguration> findByBankName(String bankName) {
		return bankConfigurationRepository.findByBankName(bankName);
	}

}
