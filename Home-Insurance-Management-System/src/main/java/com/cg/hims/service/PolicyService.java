package com.cg.hims.service;

import java.util.List;

import com.cg.hims.entities.Policy;
import com.cg.hims.exceptions.PolicyNotFoundException;

public interface PolicyService {

	public Policy addPolicy(Policy policy) throws PolicyNotFoundException;

	public Policy updatePolicy(Policy policy) throws PolicyNotFoundException;

	public Policy findPolicyById(int policyId) throws PolicyNotFoundException;

	public void removePolicy(int policyId) throws PolicyNotFoundException;

	public List<Policy> showAllPolicies() throws PolicyNotFoundException;

}
