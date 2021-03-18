package com.cg.hims.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hims.entities.Policy;
import com.cg.hims.exceptions.PolicyNotFoundException;
import com.cg.hims.repository.IPolicyRepository;

@Service
public class IPolicyServiceImpl implements IPolicyService {
	@Autowired
	private IPolicyRepository iPolicyRepository;

	@Override
	public void addPolicy(Policy policy) {
		iPolicyRepository.save(policy); 
	}

	@Override
	public void updatePolicy(Policy policy) throws PolicyNotFoundException {
			iPolicyRepository.save(policy);
		
	}

	@Override
	public Policy findPolicyById(Integer policyId) throws PolicyNotFoundException {
			return iPolicyRepository.findById(policyId).get();
	}

	@Override
	public void removePolicy(Integer policyId) throws PolicyNotFoundException {
			iPolicyRepository.deleteById(policyId);
	}

	@Override
	public List<Policy> showAllPolicies() {
		List<Policy> policy = new ArrayList<>();
		iPolicyRepository.findAll()
		.forEach(policy::add);
		return policy;
	}

	

}
