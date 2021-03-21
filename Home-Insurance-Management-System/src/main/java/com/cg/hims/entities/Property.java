package com.cg.hims.entities;

import java.io.Serializable;

import javax.persistence.Column;
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

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Table(name="Property")
public class Property implements Serializable {
	@Id
	@Column(name="property_Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int propertyId;
	private long market_value;
	private int year_built;
	private int square_footage;
	private boolean has_Swimming_Pool;

	
	
	
	
	
	
	
}