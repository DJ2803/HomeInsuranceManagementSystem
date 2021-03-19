package com.cg.hims.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Property")
public class Property {
	@Id
	@Column(name="property_Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer propertyId;
	private long market_value;
	private int year_built;
	private int square_footage;
	private boolean has_Swimming_Pool;

	
	
	
	
	
	
	
}
