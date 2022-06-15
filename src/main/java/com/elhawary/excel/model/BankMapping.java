package com.elhawary.excel.model;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankMapping {

	private String donatorName, bankCode, projectCode, amount, fromAccnt, toAccnt, deductionDate, currency, bankNam,
			homeReference, deductionReferenceCredit, deductionReferenceDebit;

	public BankMapping() {

	}

	public BankMapping(String donatorName, String bankCode, String projectCode, String amount, String fromAccnt,
			String toAccnt, String deductionDate, String currency, String bankNam, String homeReference,
			String deductionReferenceCredit, String deductionReferenceDebit) {
		super();
		this.donatorName = donatorName;
		this.bankCode = bankCode;
		this.projectCode = projectCode;
		this.amount = amount;
		this.fromAccnt = fromAccnt;
		this.toAccnt = toAccnt;
		this.deductionDate = deductionDate;
		this.currency = currency;
		this.bankNam = bankNam;
		this.homeReference = homeReference;
		this.deductionReferenceCredit = deductionReferenceCredit;
		this.deductionReferenceDebit = deductionReferenceDebit;
	}

	public String getDonatorName() {
		return donatorName;
	}

	public String getBankCode() {
		return bankCode;
	}

	public String getProjectCode() {
		return projectCode;
	}

	public String getAmount() {
		return amount;
	}

	public String getFromAccnt() {
		return fromAccnt;
	}

	public String getToAccnt() {
		return toAccnt;
	}

	public String getDeductionDate() {
		return deductionDate;
	}

	public String getCurrency() {
		return currency;
	}

	public String getBankNam() {
		return bankNam;
	}

	public String getHomeReference() {
		return homeReference;
	}

	public String getDeductionReferenceCredit() {
		return deductionReferenceCredit;
	}

	public String getDeductionReferenceDebit() {
		return deductionReferenceDebit;
	}

	
}
