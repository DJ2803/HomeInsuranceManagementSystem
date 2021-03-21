package com.cg.hims.entities;

import java.io.Serializable;
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

import org.hibernate.annotations.ManyToAny;

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
@Table(name="Quote")
public class Quote implements Serializable {
	@Id
	@Column(name="quote_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int quoteId;
	private String premium_Type;
	private double premium_amount;
	private double dwelling_Coverage;
	private double detached_Structure_Coverage;
	private double personal_Property_Coverage;
	private double additional_Living_Expense;
	private double medical_Expense;
	private double deducible_Amount;
//	@OneToMany(mappedBy="Quote")
//	private List<Transactions> TransactionsList;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Agent agent;
	
	
	

}
