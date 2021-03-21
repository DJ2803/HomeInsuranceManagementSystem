package com.cg.hims.entities;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name="policyholder")
public class PolicyHolder {
     @Id
     
     @GeneratedValue(strategy = GenerationType.AUTO)
	private int policyHolderId;
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
	@ManyToOne(cascade= CascadeType.ALL)
	@JsonIgnore
	@JoinColumn(name="agent_id")
	private Agent agent;
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="user_id")
	private User user;
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Admin admin;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="quote_id")
	private Quote quote;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="property_id")
	private Property property;
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="policy_id")
	private Policy policy;
	public PolicyHolder(int policyHolderId, String policy_Holder_Name, User user) {
		super();
		this.policyHolderId = policyHolderId;
		this.policy_Holder_Name = policy_Holder_Name;
		this.user = user;
	}
	
}
