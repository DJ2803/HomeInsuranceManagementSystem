package com.cg.hims.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Table(name = "AGENT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Agent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int agentId;
	private String agentName;
	private String designation;
	private String salary; 
//	private String address;
//	private String email;
//	private String mobileNo;
	
	@OneToMany(mappedBy="agent")
	
	private List<PolicyHolder> policyHoldersList;
	private List<Quote> quoteList;
	

	
	
	
	

}
