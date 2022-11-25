package com.cg.hims.entities;

import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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

/**
 * 
 * @author Lakshman
 * POJO Class of PolicyHolder. User,Agent,Quote,Policy,Property columns are joined.
 *
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name="policyholder")
public class PolicyHolder {
     @Id
     @Column(name="policy_holder_id")
     //@GeneratedValue(strategy = GenerationType.AUTO)
	private int policyHolderId;
     @Column(name="policy_holder_name")
	private String policyHolderName;
     @Column(name="credit_card")
	private String creditCard;
	private LocalDate dob;
	private String occupation;
	@Column(name="annual_income")
	private double annualIncome;
	@Column(name="is_retired")
	private boolean isRetired;
	@Column(name="residence_type")
	private String residenceType;
	private String city;
	private String state;
	private long zip;
	@Column(name="residence_use")
	private String  residenceUse;
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="user_id")
	private User user;
	@ManyToOne(cascade= CascadeType.ALL)
	@JsonIgnore
	@JoinColumn(name="agent_id")
	private Agent agent;
	
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JsonIgnore
//	private Admin admin;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="quote_id")
	private Quote quote;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="property_id")
	private Property property;
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="policy_id")
	private Policy policy;

	public PolicyHolder(int policyHolderId, String policyHolderName, User user) {
		super();
		this.policyHolderId = policyHolderId;
		this.policyHolderName = policyHolderName;
		this.user = user;
	}
	
	
}
