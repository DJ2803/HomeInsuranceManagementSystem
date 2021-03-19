package com.cg.hims.service;

import java.util.List;

import com.cg.hims.entities.Policy;
import com.cg.hims.exceptions.PolicyNotFoundException;

public interface PolicyService {

	Policy addPolicy(Policy policy) throws PolicyNotFoundException;

	Policy updatePolicy(Policy policy) throws PolicyNotFoundException;

	public Policy findPolicyById(Integer policyId) throws PolicyNotFoundException;

	public void removePolicy(Integer policyId) throws PolicyNotFoundException;

	public List<Policy> showAllPolicies() throws PolicyNotFoundException;

}
