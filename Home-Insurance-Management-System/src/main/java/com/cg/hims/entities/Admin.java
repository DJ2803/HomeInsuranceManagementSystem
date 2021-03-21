package com.cg.hims.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="admin")
public class Admin 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int adminId;
	private String admin_Name;
	@OneToMany(mappedBy = "admin")
	@JsonIgnore
	private Set<PolicyHolder> policyholders;
	@OneToMany(mappedBy="admin")
	@JsonIgnore
	private Set<Agent> agents;
//	@OneToMany(mappedBy="admin")
//	private Set<Transactions> transactions;
	@OneToMany(mappedBy="admin")
	@JsonIgnore
	private Set<Policy> policydetails;



	
}
