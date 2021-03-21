package com.cg.hims.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="users")
public class User{
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="user_id")
	public int user_id;
	public String user_name;
	public String password;
	public String first_name;
	public String last_name;
	public String email_id;
	public long contact_no;
	public String address;
	public String role;
	@OneToOne(mappedBy= "user")
	@JsonIgnore
	private Admin admin;
	
	@OneToOne(mappedBy="user")
	@JsonIgnore
	private Agent agent;
	
	@OneToOne(mappedBy="user")
	@JsonIgnore
	private PolicyHolder policyHolder;
//	public String getPassword() {
//		return password;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	}
//////	



	

	

}
