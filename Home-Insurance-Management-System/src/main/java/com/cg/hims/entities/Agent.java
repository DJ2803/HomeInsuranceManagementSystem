package com.cg.hims.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Table(name = "Agent")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Agent {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 @Column(name="agent_Id")
	private Integer agentId;
	private String agent_Name;
	private String designation;
	private Double salary; 
	@OneToMany(mappedBy="agent")
	private List<PolicyHolder> policyHoldersList;
	@OneToMany(mappedBy = "agent")
    private List<Quote> quoteList;
	@ManyToOne(cascade = CascadeType.ALL)
	private Admin admin;
	

	
	
	
	

}