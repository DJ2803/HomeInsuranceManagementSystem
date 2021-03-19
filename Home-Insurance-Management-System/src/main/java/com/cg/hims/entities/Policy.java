package com.cg.hims.entities;

import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@Table(name="policydetails")
public class Policy {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	//@Column(name="policy_id")
	private int policy_id;
	private String policy_name;
	private LocalDate policy_end_date;
	private LocalDate policy_effective_date;
	private int policy_term;
	private String policy_status;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private PolicyHolder policyHolder;

	public Policy(String policy_name, LocalDate policy_end_date, LocalDate policy_effective_date, int policy_term,
			String policy_status) {
		super();
		this.policy_name = policy_name;
		this.policy_end_date = policy_end_date;
		this.policy_effective_date = policy_effective_date;
		this.policy_term = policy_term;
		this.policy_status = policy_status;
//		this.policyHolder = policyHolder;
	}

	
	
	

}
