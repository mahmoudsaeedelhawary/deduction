	package com.elhawary.excel.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Deduction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long deductionId ;
	
	@Temporal(TemporalType.DATE)
	private Date start_date ;
	@Temporal(TemporalType.DATE)
	private Date end_date ;
	private Integer count ;
	private Double amount ;
	private Double currency ;
	
	private ConfigDetails configDetails ;
	
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "donator_id")
	private Donator donator ;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false,cascade = CascadeType.ALL)
	@JoinColumn(name = "project_id", nullable = false)
	private Project project ;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "comittee_id")
	private Comittee comittee ;
	
	
	
	@OneToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "deduction_status_id", nullable = false)
    private DeductionStatus deductionStatus ;
	
	
}
