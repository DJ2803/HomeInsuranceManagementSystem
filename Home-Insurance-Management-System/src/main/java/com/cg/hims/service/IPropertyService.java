package com.cg.hims.service;

import com.cg.hims.entities.Property;

public interface IPropertyService {

	public Property addProperty(Property property) throws Exception;

	public Property viewProperty() throws Exception;

}
