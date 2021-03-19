package com.cg.hims.entities;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.Transient;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@ NoArgsConstructor
@Setter
@Getter
@Table(name="policyholder")
public class PolicyHolder {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int policyHolderId;
	private String policy_holder_name;
	private String credit_card;
	private LocalDate dob;
	private String occupation;
	private double annual_income;
	private Boolean is_retired;
	private String residence_type;
	private String city;
	private String state;
	private long zip;
	private String residence_use;
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="quote_id")
	@Transient
	private Quote quote;
	
	@ManyToOne(cascade= CascadeType.ALL, fetch= FetchType.LAZY)
	private Agent agent;
	
	@OneToOne(cascade = CascadeType.ALL, fetch= FetchType.LAZY)
	@JoinColumn(name="property_id")
	@Transient
	private Property property;
	
	@OneToMany(mappedBy="policyHolder")
	@Transient
	private Set<Policy> policy;

	@Override
	public String toString() {
		return "PolicyHolder [policyHolderId=" + policyHolderId + ", policy_holder_name=" + policy_holder_name
				+ ", credit_card=" + credit_card + ", dob=" + dob + ", occupation=" + occupation + ", annual_income="
				+ annual_income + ", is_retired=" + is_retired + ", residence_type=" + residence_type + ", city=" + city
				+ ", state=" + state + ", zip=" + zip + ", residence_use=" + residence_use + ", quote=" + quote
				+ ", property=" + property + ", policy=" + policy + "]";
	}
	
	
	
}
