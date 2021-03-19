package com.cg.hims.service;

import java.util.List;

import com.cg.hims.entities.Policy;
import com.cg.hims.entities.PolicyHolder;
import com.cg.hims.entities.Property;
import com.cg.hims.entities.Quote;
import com.cg.hims.exceptions.PolicyHolderNotFoundException;
import com.cg.hims.exceptions.PolicyNotFoundException;
import com.cg.hims.exceptions.QuoteNotFoundException;

public interface PolicyHolderService {

	public String addPolicyHolder(PolicyHolder policyHolder) throws PolicyHolderNotFoundException;

	public String updatePolicyHolder(PolicyHolder policyHolder) throws PolicyHolderNotFoundException;

	public PolicyHolder findPolicyHolderById(int id) throws PolicyHolderNotFoundException;
	
	public List<Policy> showAllPolicies() throws PolicyNotFoundException;
	
	public Property viewPropertyById(int id) throws Exception;
	
	public Quote findQuoteById(int id) throws QuoteNotFoundException;
	
	public Property addProperty(Property property) throws Exception;

//	public void removePolicyHolder(int id) throws PolicyHolderNotFoundException;
//
//	public List<PolicyHolder> showAllPolicyHolders() throws PolicyHolderNotFoundException;

}
