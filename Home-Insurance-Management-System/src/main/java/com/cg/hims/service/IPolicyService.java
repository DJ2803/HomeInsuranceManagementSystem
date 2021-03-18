package com.cg.hims.service;

import java.util.List;

import com.cg.hims.entities.Policy;
import com.cg.hims.exceptions.PolicyNotFoundException;

public interface IPolicyService {

	public void addPolicy(Policy policy);

	public void updatePolicy(Policy policy) throws PolicyNotFoundException;

	public Policy findPolicyById(Integer policyId) throws PolicyNotFoundException;

	public void removePolicy(Integer policyId) throws PolicyNotFoundException;

	public List<Policy> showAllPolicies();

}
