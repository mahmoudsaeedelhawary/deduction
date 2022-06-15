package com.elhawary.excel.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankConfiguration {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bankConfigurationId;

	private BankMapping BankMapping;

	private ConfigDetails configDetails;

	private Integer account_max_lenght;
	private Integer account_min_lenght;
	private String bankName, account_number_mask;
	private Boolean deduction_reference_number_available;

	@OneToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "bank_id", nullable = false)
	private Bank bank;

	public Long getBankConfigurationId() {
		return bankConfigurationId;
	}

	public void setBankConfigurationId(Long bankConfigurationId) {
		this.bankConfigurationId = bankConfigurationId;
	}

	public BankMapping getBankMapping() {
		return BankMapping;
	}

	public void setBankMapping(BankMapping bankMapping) {
		BankMapping = bankMapping;
	}

	public ConfigDetails getConfigDetails() {
		return configDetails;
	}

	public void setConfigDetails(ConfigDetails configDetails) {
		this.configDetails = configDetails;
	}

	public Integer getAccount_max_lenght() {
		return account_max_lenght;
	}

	public void setAccount_max_lenght(Integer account_max_lenght) {
		this.account_max_lenght = account_max_lenght;
	}

	public Integer getAccount_min_lenght() {
		return account_min_lenght;
	}

	public void setAccount_min_lenght(Integer account_min_lenght) {
		this.account_min_lenght = account_min_lenght;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getAccount_number_mask() {
		return account_number_mask;
	}

	public void setAccount_number_mask(String account_number_mask) {
		this.account_number_mask = account_number_mask;
	}

	public Boolean getDeduction_reference_number_available() {
		return deduction_reference_number_available;
	}

	public void setDeduction_reference_number_available(Boolean deduction_reference_number_available) {
		this.deduction_reference_number_available = deduction_reference_number_available;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

}
