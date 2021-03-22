package com.cg.hims.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
	private LocalDate policyEffectiveDate;
	private LocalDate policyEndDate;
	private int policyTerm;
	private String policyStatus;
	@OneToMany
	@JoinColumn(name="policyId")
	private List<Transaction> transactionsList;
	
	
	public Policy(String policyName, LocalDate policyEffectiveDate, LocalDate policyEndDate, int policyTerm, String policyStatus) {
		super();
		this.policyName = policyName;
		this.policyEffectiveDate = policyEffectiveDate;
		this.policyEndDate = policyEndDate;
		this.policyTerm = policyTerm;
		this.policyStatus = policyStatus;
		
	}

	
	
}
