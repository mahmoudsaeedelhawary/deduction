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

	private String donatorName, bankCode, projectCode ,amount ,fromAccnt,toAccnt;

	public BankMapping() {
		
	}
 	
	public BankMapping(String donatorName, String bankCode, String projectCode, String amount, String fromAccnt,
			String toAccnt) {
		super();
		this.donatorName = donatorName;
		this.bankCode = bankCode;
		this.projectCode = projectCode;
		this.amount = amount;
		this.fromAccnt = fromAccnt;
		this.toAccnt = toAccnt;
	}

	public String getDonatorName() {
		return donatorName;
	}

	public void setDonatorName(String donatorName) {
		this.donatorName = donatorName;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getFromAccnt() {
		return fromAccnt;
	}

	public void setFromAccnt(String fromAccnt) {
		this.fromAccnt = fromAccnt;
	}

	public String getToAccnt() {
		return toAccnt;
	}

	public void setToAccnt(String toAccnt) {
		this.toAccnt = toAccnt;
	}
	
}
