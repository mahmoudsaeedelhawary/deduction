package com.elhawary.excel.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankTransaction implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4088141223931728339L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bankTransactionId;

	private String donatorName, bankCode, projectCode, toAccnt, fromAccnt;
	private long amount;
	private String project_reference_number;
	private String deduction_reference_number;
	private int line_number;

	private ConfigDetails configDetails;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "bank_file_id")
	private BankFile bankFile;

//	@JsonIgnore
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "deduction_cycle_id")
//	private DeductionCycle deductionCycle;

	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "bank_id")
	private Bank bank;

	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "bank_transaction_status_id")
	private BankTransactionStatus bankTransactionStatus;

	
	public Long getBankTransactionId() {
		return bankTransactionId;
	}

	public void setBankTransactionId(Long bankTransactionId) {
		this.bankTransactionId = bankTransactionId;
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

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public String getProject_reference_number() {
		return project_reference_number;
	}

	public void setProject_reference_number(String project_reference_number) {
		this.project_reference_number = project_reference_number;
	}

	public String getDeduction_reference_number() {
		return deduction_reference_number;
	}

	public void setDeduction_reference_number(String deduction_reference_number) {
		this.deduction_reference_number = deduction_reference_number;
	}

	public int getLine_number() {
		return line_number;
	}

	public void setLine_number(int line_number) {
		this.line_number = line_number;
	}

	public String getToAccnt() {
		return toAccnt;
	}

	public void setToAccnt(String toAccnt) {
		this.toAccnt = toAccnt;
	}

	public String getFromAccnt() {
		return fromAccnt;
	}

	public void setFromAccnt(String fromAccnt) {
		this.fromAccnt = fromAccnt;
	}

	public ConfigDetails getConfigDetails() {
		return configDetails;
	}

	public void setConfigDetails(ConfigDetails configDetails) {
		this.configDetails = configDetails;
	}

	public BankFile getBankFile() {
		return bankFile;
	}

	public void setBankFile(BankFile bankFile) {
		this.bankFile = bankFile;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public BankTransactionStatus getBankTransactionStatus() {
		return bankTransactionStatus;
	}

	public void setBankTransactionStatus(BankTransactionStatus bankTransactionStatus) {
		this.bankTransactionStatus = bankTransactionStatus;
	}


}
