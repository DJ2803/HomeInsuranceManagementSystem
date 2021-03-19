package com.cg.hims.entities;

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

@NoArgsConstructor
@Data
@Entity
@Table(name="quote")
public class Quote {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="quote_id")
	private int quote_id;
	private String premium_type;
	private double premium_amount;
	private double dwelling_coverage;
	private double detached_structure_coverage;
	private double personal_property_coverage;
	private double additional_living_expense;
	private double medical_expense;
	private double deducible_amount;
	@ManyToOne(cascade = CascadeType.ALL)
	private Agent agent;
	
	public Quote(String premium_type, double premium_amount, double dwelling_coverage,
			double detached_structure_coverage, double personal_property_coverage, double additional_living_expense,
			double medical_expense, double deducible_amount) {
		super();
		this.premium_type = premium_type;
		this.premium_amount = premium_amount;
		this.dwelling_coverage = dwelling_coverage;
		this.detached_structure_coverage = detached_structure_coverage;
		this.personal_property_coverage = personal_property_coverage;
		this.additional_living_expense = additional_living_expense;
		this.medical_expense = medical_expense;
		this.deducible_amount = deducible_amount;
	}
	
	

}
