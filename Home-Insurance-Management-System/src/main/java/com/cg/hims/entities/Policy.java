package com.cg.hims.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="Policy")
public class Policy {
    @Id
    @Column(name="policy_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer policyId;
	private String policy_name;
	private LocalDate policy_End_Date;
	private LocalDate policy_Effective_Date;
	private int policy_Terrm;
	private String policy_Status;
	@OneToMany(mappedBy="Policy")
	private List<Transactions> TransactionsList;
	@ManyToOne(cascade = CascadeType.ALL)
	private PolicyHolder policyHolder;
	@ManyToOne(cascade = CascadeType.ALL)
	private Admin admin;

}
