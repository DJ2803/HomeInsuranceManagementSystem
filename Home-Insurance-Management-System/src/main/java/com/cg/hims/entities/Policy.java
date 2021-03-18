package com.cg.hims.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
public class Policy {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer policyId;
	private String policyEffectiveDate;
	private String policyEndDate;
	private int policyTerm;
	private String policyStatus;
	private int quoteId;
	
	public Policy(String policyEffectiveDate, String policyEndDate, int policyTerm, String policyStatus, int quoteId) {
		super();
		this.policyEffectiveDate = policyEffectiveDate;
		this.policyEndDate = policyEndDate;
		this.policyTerm = policyTerm;
		this.policyStatus = policyStatus;
		this.quoteId = quoteId;
	}

	
	
}
