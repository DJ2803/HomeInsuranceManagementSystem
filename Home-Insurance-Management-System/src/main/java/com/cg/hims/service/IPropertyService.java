package com.cg.hims.service;

import com.cg.hims.entities.Property;

public interface IPropertyService {

	public Property addProperty(Property property) throws Exception;
	
	public Property updateProperty(Property property) throws Exception;
	
	public Property findPropertyById(int propertyId)throws Exception;

	public Property viewProperty(int propertyId) throws Exception;

}
