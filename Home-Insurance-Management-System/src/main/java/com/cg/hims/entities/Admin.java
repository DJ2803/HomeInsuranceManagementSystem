package com.cg.hims.entities;

import java.util.Set;

import javax.persistence.Entity;
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
	private int adminId;
	private String adminName;
	private String contact;
//	@OneToMany(mappedBy = "admin")
//	private Set<PolicyHolder> policyholders;
	@OneToMany(mappedBy="admin")
	private Set<Agent> agents;
//	@OneToMany(mappedBy="admin")
//	private Set<Agent> transactions;
//	@OneToMany(mappedBy="admin")
//	private Set<Agent> policydetails;
}
