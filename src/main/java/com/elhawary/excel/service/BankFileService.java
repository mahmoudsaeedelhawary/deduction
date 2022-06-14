package com.elhawary.excel.service;

import java.util.Optional;

import com.elhawary.excel.model.BankFile;

public interface BankFileService {
	Optional<BankFile> findByFileName(String fileName);

	BankFile save(BankFile bankFile);
}
