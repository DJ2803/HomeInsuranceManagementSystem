package com.cg.hims.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.cg.hims.entities.Policy;
import com.cg.hims.exceptions.PolicyNotFoundException;
import com.cg.hims.repository.PolicyRepository;

@Service
@Transactional
public class PolicyServiceImpl implements PolicyService {
	@Autowired
	private PolicyRepository policyRepository;

	/*
	 * Add new policy
	 */
	@Override
	public Policy addPolicy(Policy policy) throws PolicyNotFoundException {
		try {
			return policyRepository.save(policy); 
		}catch(DataAccessException e) {		
			throw new PolicyNotFoundException(e.getMessage());
		}catch(Exception e) {			
			throw new PolicyNotFoundException(e.getMessage());
		}
	}

	/*
	 * Update the existing policy by taking comparing the policId
	 */
	@Override
	public Policy updatePolicy(Policy policy) throws PolicyNotFoundException {
		try {
			return policyRepository.save(policy);
		}catch(DataAccessException e) {
			throw new PolicyNotFoundException(e.getMessage());
		}catch(Exception e) {
			throw new PolicyNotFoundException(e.getMessage());
		}

	}

	/*
	 * finds a specific policy depending upon the entered policyId by the user
	 */
	@Override
	public Policy findPolicyById(Integer policyId) throws PolicyNotFoundException {
		try {
			Optional<Policy> optional =  policyRepository.findById(policyId);
			if(optional.isPresent()) {
				return optional.get();
			}else {
				throw new Exception("Invalid Policy Id");
			}
		}catch(DataAccessException e) {			
			throw new PolicyNotFoundException(e.getMessage());
		}catch(Exception e) {			
			throw new PolicyNotFoundException(e.getMessage());
		}


	}

	/*
	 * Removes a policy depending upon the policyId entered by the user
	 */
	@Override
	public void removePolicy(Integer policyId) throws PolicyNotFoundException {
		try {
			policyRepository.deleteById(policyId);
		}catch(DataAccessException e) {			
			throw new PolicyNotFoundException(e.getMessage());
		}catch(Exception e) {			
			throw new PolicyNotFoundException(e.getMessage());
		}

	}

	/*
	 * Displays all policy
	 */
	@Override
	public List<Policy> showAllPolicies() throws PolicyNotFoundException {
		try {
			List<Policy> policyList = policyRepository.findAll();
			//System.out.println("Getting Data from Db "+policyList);
			return policyList;
			
		}catch(DataAccessException e) {			
			throw new PolicyNotFoundException(e.getMessage());
		}catch(Exception e) {
			throw new PolicyNotFoundException(e.getMessage());
		}


	}



}
