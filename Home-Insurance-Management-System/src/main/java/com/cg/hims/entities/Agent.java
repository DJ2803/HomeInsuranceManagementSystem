package com.cg.hims.entities;

import java.util.List;
import java.util.Set;

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
@Entity
@Table(name = "Agent")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@ToString
public class Agent {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 @Column(name="agent_Id")
	private int agentId;
	private String agent_Name;
	private String designation;
	private Double salary; 
	@OneToMany(mappedBy="agent")
	@JsonIgnore
	private Set<PolicyHolder> policyHoldersList;
	@OneToMany(mappedBy = "agent")
	@JsonIgnore
    private List<Quote> quoteList;
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Admin admin;
	@Override
	public String toString() {
		return "Agent [agentId=" + agentId + ", agent_Name=" + agent_Name + ", designation=" + designation + ", salary="
				+ salary + "]";
	}
}