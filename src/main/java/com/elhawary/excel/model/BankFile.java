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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankFile implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4578635611752798199L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bankFileId;

	private String fileName;
	private String fileUri;

	private ConfigDetails configDetails;

	@OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "bank_file_status_id")
	private BankFileStatus bankFileStatus;
	
//	@JsonIgnore
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "bank_id")
//	private Bank bank;
//  @JsonIgnore
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "deduction_cycle_id")
//  private DeductionCycle deductionCycle ;

	public Long getBankFileId() {
		return bankFileId;
	}

	public void setBankFileId(Long bankFileId) {
		this.bankFileId = bankFileId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileUri() {
		return fileUri;
	}

	public void setFileUri(String fileUri) {
		this.fileUri = fileUri;
	}

	public ConfigDetails getConfigDetails() {
		return configDetails;
	}

	public void setConfigDetails(ConfigDetails configDetails) {
		this.configDetails = configDetails;
	}

	public BankFileStatus getBankFileStatus() {
		return bankFileStatus;
	}

	public void setBankFileStatus(BankFileStatus bankFileStatus) {
		this.bankFileStatus = bankFileStatus;
	}

}
