package com.elhawary.excel.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bank {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long BankId;

	private String bankName ;

	public Long getBankId() {
		return BankId;
	}

	public void setBankId(Long bankId) {
		BankId = bankId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	
//	@OneToOne(fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL)
//	private BankTransaction bank_transaction;
//	
//	@OneToOne(mappedBy = "bank", fetch = FetchType.LAZY,
//    cascade = CascadeType.ALL)
//	private BankConfiguration bankConfiguration;
}
