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
	
	private String name_arabic ;
	private String name_english ;

	public Long getBankFileStatusId() {
		return bankFileStatusId;
	}

	public void setBankFileStatusId(Long bankFileStatusId) {
		this.bankFileStatusId = bankFileStatusId;
	}

	public String getName_arabic() {
		return name_arabic;
	}

	public void setName_arabic(String name_arabic) {
		this.name_arabic = name_arabic;
	}

	public String getName_english() {
		return name_english;
	}

	public void setName_english(String name_english) {
		this.name_english = name_english;
	}
	
	
}
