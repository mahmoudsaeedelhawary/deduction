package com.elhawary.excel.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeductionCycle implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8972669296873072007L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long deductionCycleId ;
	
	private Integer month ;
	
	private Integer year ;
	
	private ConfigDetails configDetails ;
	
	
	@OneToOne(fetch = FetchType.LAZY, optional = false,cascade = CascadeType.ALL)
	@JoinColumn(name = "decuction_cycle_status_id", nullable = false)
    private DecuctionCycleStatus decuctionCycleStatus ;
}
