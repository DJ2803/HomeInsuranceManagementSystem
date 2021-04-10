package com.cg.hims.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;


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
	@Length(max = 10)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer policyId;
	
	@Length(max=25)
    @NotBlank(message="Policy name cannot be blank")
	private String policyName;
	

    @Length(max=20)
    @NotBlank(message="Date cannot be empty")
	private LocalDate policyEffectiveDate;
    
    @Length(max=20)
    @NotBlank(message="Date cannot be empty")
	private LocalDate policyEndDate;
    
    @Length(max=10)
	private int policyTerm;
    
    @Length(max=20)
	private String policyStatus;

	public Policy(String policyName, LocalDate policyEffectiveDate, LocalDate policyEndDate, int policyTerm, String policyStatus) {
		super();
		this.policyName = policyName;
		this.policyEffectiveDate = policyEffectiveDate;
		this.policyEndDate = policyEndDate;
		this.policyTerm = policyTerm;
		this.policyStatus = policyStatus;
		
	}

	
	
}
