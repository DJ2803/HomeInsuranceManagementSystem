package com.cg.hims.entities;


import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="transaction")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer transactionId;
	private LocalTime transactionTime;
	private String region;
	private String paymentType;
	
	
	public Transaction(LocalTime transactionTime, String region, String paymentType) {
		super();
		this.transactionTime = transactionTime;
		this.region = region;
		this.paymentType = paymentType;
		
	}
	
	
}
