package com.elhawary.excel.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
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
@Table(name = "Deduction_Transaction")
@Inheritance(strategy = InheritanceType.JOINED)
public class DeductionTransaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long deductionTransactionId;

	private  DeductionTransactionType deductionTransactionType ;

	@OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "deduction_transaction_status_id", nullable = false)
    private DeductionTransactionStatus deductionTransactionStatus ;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "deduction_id")
    private Deduction deduction ;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "deduction_cycle_id")
    private DeductionCycle deductionCycle ;
	
}
