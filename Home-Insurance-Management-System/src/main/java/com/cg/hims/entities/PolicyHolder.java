package com.cg.hims.entities;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="PolicyHolder")
public class PolicyHolder {
     @Id
     @Column(name="policy_holder_id")
     @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer policyHolderId;
	private String policy_Holder_Name;
	private String credit_Card;
	private LocalDate dob;
	private String occupation;
	private double annual_Income;
	private boolean is_Retired;
	private String residence_type;
	private String city;
	private String state;
	private long zip;
	private String  residence_use;
	@ManyToOne(cascade = CascadeType.ALL)
	private Agent agent;
	@ManyToOne(cascade = CascadeType.ALL)
	private Admin admin;
	@OneToOne(cascade = CascadeType.ALL)
	private Quote quote;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Property property;
	
	@OneToMany(mappedBy="policyHolder")
	private Set<Policy> policy;
	
	
}
