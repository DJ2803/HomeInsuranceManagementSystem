package com.cg.hims.entities;

import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Transaction")
public class Transactions {

	@Id
	@Column(name="Transaction_Id")
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer Transaction_Id;
	private LocalTime transaction_time;
	private  String region;
	private String payment_type;
	@ManyToOne(cascade = CascadeType.ALL)
	private Admin admin;
	@ManyToOne(cascade = CascadeType.ALL)
	private Quote quote;
	@ManyToOne(cascade = CascadeType.ALL)
	private Policy policy;
	
}
