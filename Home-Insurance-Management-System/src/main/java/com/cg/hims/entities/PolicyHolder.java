package com.cg.hims.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.web.bind.annotation.RequestMapping;

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
@RequestMapping("/policyholder")
public class PolicyHolder {
	@Id
	private int policyHolderId;
	private String policyHolderName;
	//private String policyName;
	private String premiumType;
	private String creditCard;
	private String dob;
	private String occupation;
	private double annualIncome;
	private String isRetired;
	//private String emailId;
	private int policyId;
	
}
