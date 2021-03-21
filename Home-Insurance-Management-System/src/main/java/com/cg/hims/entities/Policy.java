package com.cg.hims.entities;

import java.io.Serializable;
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
@Table(name="Policy")
public class Policy implements Serializable {
    @Id
   
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int policyId;
	private String policy_name;
	private LocalDate policy_End_Date;
	private LocalDate policy_Effective_Date;
	private int policy_Terrm;
	private String policy_Status;
//	@OneToMany(mappedBy="Policy")
//	private List<Transactions> TransactionsList;
//	private PolicyHolder policyHolder;
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Admin admin;

}
