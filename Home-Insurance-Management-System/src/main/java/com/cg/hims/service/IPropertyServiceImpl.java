package com.cg.hims.service;

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

	public Property viewProperty() throws Exception
	{
		try {
			return (Property)holderProperty;
		}catch(DataAccessException e) {
			//converting SQLException to EmployeeException
			throw new Exception(e.getMessage());
		}
	}
}
