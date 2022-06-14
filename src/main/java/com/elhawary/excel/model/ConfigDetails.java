package com.elhawary.excel.model;

import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConfigDetails {

	@Temporal(TemporalType.DATE)
	private Date created_at ;
	private String created_by ;
	@Temporal(TemporalType.DATE)
	private Date modified_at ;
	private String  modified_by ;
	
	public ConfigDetails() {
		
	}
	public ConfigDetails(Date created_at, String created_by) {
		super();
		this.created_at = created_at;
		this.created_by = created_by;
	}
	
	
}
