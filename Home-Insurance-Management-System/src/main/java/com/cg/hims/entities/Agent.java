package com.cg.hims.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Table(name = "agent")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Agent {
	
	@Id
	private int agentId;
	private String agentName;
	private String designation;
	private String salary; 
	private String address;
	private String email;
	private String mobileNo;
	
	@OneToMany(mappedBy="agent")
	private List<PolicyHolder> policyHoldersList;
	
	

}
