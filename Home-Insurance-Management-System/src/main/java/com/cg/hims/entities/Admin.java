package com.cg.hims.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name="admin")
//@DiscriminatorValue(value = "Admin")
public class Admin
{
	@Id
	@Column(name="admin_id")
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private int adminId;
	private String admin_Name;
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="user_id")
	private User user;
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
	public Admin(int adminId, String admin_Name, User user) {
		super();
		this.adminId = adminId;
		this.admin_Name = admin_Name;
		this.user = user;
	}
	
	
	
}