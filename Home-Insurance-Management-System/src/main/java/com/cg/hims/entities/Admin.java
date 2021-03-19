package com.cg.hims.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
	@Column(name="admin_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer adminId;
	private String admin_Name;
	@OneToMany(mappedBy = "admin")
	private Set<PolicyHolder> policyholders;
	@OneToMany(mappedBy="admin")
	private Set<Agent> agents;
	@OneToMany(mappedBy="admin")
	private Set<Transactions> transactions;
	@OneToMany(mappedBy="admin")
	private Set<Policy> policydetails;
}