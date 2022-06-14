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
public class DeductionTransactionStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long deductionTransactionStatusId ;
	
	private String name_arabic ;
	private String name_english ;
	
	@OneToOne(mappedBy =  "deductionTransactionStatus", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	private DeductionTransaction deductionTransaction ;
}
