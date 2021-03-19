package com.cg.hims.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.hims.entities.Agent;
import com.cg.hims.entities.Property;
import com.cg.hims.exceptions.AgentException;
import com.cg.hims.exceptions.AgentNotFoundException;
import com.cg.hims.repository.IPropertyRepository;
@Service
@Transactional
public class IPropertyServiceImpl implements IPropertyService{
	@Autowired
	private IPropertyRepository holderProperty;
	public Property addProperty(Property property) throws Exception
	{	
		try {			
			return holderProperty.save(property);
		}catch(DataAccessException e) {
			//converting SQLException to EmployeeException
			throw new Exception(e.getMessage());
		}
	}
	
	@Override
	public Property updateProperty(Property property) throws Exception
	{
		try {
			Optional<Property> optional= holderProperty.findById(property.getPropertyId());
			if(optional.isPresent()){
			return holderProperty.save(property);}
			else{
				throw new Exception("Property does not exist");
			}
		}catch(Exception e) {
			//converting SQLException to EmployeeException
			throw new Exception(e.getMessage());
		}
		
		
		
	}

	public Property findPropertyById(int propertyId)throws Exception
	{
		try {
			Optional<Property> optional= holderProperty.findById(propertyId);
			return optional.get();
			  
		}
		catch(DataAccessException e) {
			//converting SQLException to EmployeeException
			throw new Exception(e.getMessage());
		}
	}
	public Property viewProperty(int propertyId) throws Exception
	{
		try {
			Optional<Property> optional= holderProperty.findById(propertyId);
			return optional.get();
			  
		}
		catch(DataAccessException e) {
			//converting SQLException to EmployeeException
			throw new Exception(e.getMessage());
		}
	}
}
