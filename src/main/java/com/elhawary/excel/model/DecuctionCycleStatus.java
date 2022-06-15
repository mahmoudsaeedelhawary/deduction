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
public class DecuctionCycleStatus implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4638917857000508647L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long decuction_cycle_statusId;

	private String nameArabic ;
	private String nameEnglish ;
	
	

}
