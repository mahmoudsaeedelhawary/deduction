package com.elhawary.excel.model;

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
public class BankFileStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bankFileStatusId ;
	
	private String nameArabic ;
	private String nameEnglish ;

	public Long getBankFileStatusId() {
		return bankFileStatusId;
	}

	public void setBankFileStatusId(Long bankFileStatusId) {
		this.bankFileStatusId = bankFileStatusId;
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
