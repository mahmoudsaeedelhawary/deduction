package com.elhawary.excel.model;

public class BankMappingBuilder {
	private String donatorName, bankCode, projectCode, amount, fromAccnt, toAccnt, deductionDate, currency, bankNam,
	homeReference, deductionReferenceCredit, deductionReferenceDebit;

	public BankMappingBuilder setDonatorName(String donatorName) {
		this.donatorName = donatorName;
		return this ;
	}

	public BankMappingBuilder setBankCode(String bankCode) {
		this.bankCode = bankCode;
		return this ;
	}

	public BankMappingBuilder setProjectCode(String projectCode) {
		this.projectCode = projectCode;
		return this ;
	}

	public BankMappingBuilder setAmount(String amount) {
		this.amount = amount;
		return this ;
	}

	public BankMappingBuilder setFromAccnt(String fromAccnt) {
		this.fromAccnt = fromAccnt;
		return this ;
	}

	public BankMappingBuilder setToAccnt(String toAccnt) {
		this.toAccnt = toAccnt;
		return this ;
	}

	public BankMappingBuilder setDeductionDate(String deductionDate) {
		this.deductionDate = deductionDate;
		return this ;
	}

	public BankMappingBuilder setCurrency(String currency) {
		this.currency = currency;
		return this ;
	}

	public BankMappingBuilder setBankNam(String bankNam) {
		this.bankNam = bankNam;
		return this ;
	}

	public BankMappingBuilder setHomeReference(String homeReference) {
		this.homeReference = homeReference;
		return this ;
	}

	public BankMappingBuilder setDeductionReferenceCredit(String deductionReferenceCredit) {
		this.deductionReferenceCredit = deductionReferenceCredit;
		return this ;
	}

	public BankMappingBuilder setDeductionReferenceDebit(String deductionReferenceDebit) {
		this.deductionReferenceDebit = deductionReferenceDebit;
		return this ;
	}
	
	public BankMapping getBankMapping() {
		return new BankMapping(donatorName, bankCode, projectCode, amount, fromAccnt, toAccnt, deductionDate, currency, bankNam,
				homeReference, deductionReferenceCredit, deductionReferenceDebit) ;
	}
	
}
