package com.cg.hims.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="policydetails")
public class Policy {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer policyId;
	private String policyName;
	private Date policyEffectiveDate;
	private Date policyEndDate;
	private int policyTerm;
	private String policyStatus;
	//private int quoteId;
	
	public Policy(String policyName, Date policyEffectiveDate, Date policyEndDate, int policyTerm, String policyStatus, int quoteId) {
		super();
		this.policyName = policyName;
		this.policyEffectiveDate = policyEffectiveDate;
		this.policyEndDate = policyEndDate;
		this.policyTerm = policyTerm;
		this.policyStatus = policyStatus;
		//this.quoteId = quoteId;
	}

	
	
}
