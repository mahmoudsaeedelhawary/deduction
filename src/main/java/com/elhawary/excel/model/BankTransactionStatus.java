package com.elhawary.excel.model;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankTransactionStatus implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4529467873678371297L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bankTransactionStatusId;

	private String nameArabic ;
	private String nameEnglish ;


	public Long getBankTransactionStatusId() {
		return bankTransactionStatusId;
	}


	public void setBankTransactionStatusId(Long bankTransactionStatusId) {
		this.bankTransactionStatusId = bankTransactionStatusId;
	}

	public String getNameArabic() {
		return nameArabic;
	}

	public void setNameArabic(String nameArabic) {
		this.nameArabic = nameArabic;
	}

	public String getNameEnglish() {
		return nameEnglish;
	}

	public void setNameEnglish(String nameEnglish) {
		this.nameEnglish = nameEnglish;
	}
	
	
	
}
