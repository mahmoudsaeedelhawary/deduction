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
public class DeductionStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long deductionStatusId ;
	
	private String nameArabic ;
	private String nameEnglish ;
	
}
