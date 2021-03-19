package com.cg.hims.entities;

import java.util.List;

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
@Table(name = "PROPERTY")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Property {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int propertyId;
	private int marketValue;
	private int yearBuilt;
	private int squareFootage;
//	private double dwellingStyle;
//	private String roofMaterial ;
//	private String garageType;
//	private int fullBathCount;
//	private int halfBathCount;
	private boolean hasSwimmingPool;
	
	
	
}


