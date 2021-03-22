package com.cg.hims.service;

import java.util.List;

import com.cg.hims.entities.PolicyHolder;
import com.cg.hims.exceptions.PolicyHolderNotFoundException;
import com.cg.hims.exceptions.PolicyNotFoundException;

public interface PolicyHolderService {

//	public PolicyHolder addPolicyHolder(PolicyHolder policyHolder);
//
//	public PolicyHolder updatePolicyHolder(PolicyHolder policyHolder) throws PolicyHolderNotFoundException;
//
//	public PolicyHolder findPolicyHolderById(int id) throws PolicyHolderNotFoundException;
//
//	public PolicyHolder removePolicyHolder(int id) throws PolicyHolderNotFoundException;
//
//	public List<PolicyHolder> showAllPolicyHolders();
	
	//public void makePayment();
	public List<PolicyHolder> showAllPolicyDetails() throws PolicyNotFoundException;

}
