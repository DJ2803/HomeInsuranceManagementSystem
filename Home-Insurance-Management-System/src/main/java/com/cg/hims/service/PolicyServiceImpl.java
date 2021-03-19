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


	@Override
	public Policy addPolicy(Policy policy) throws PolicyNotFoundException {
		try {
			return policyRepository.save(policy); 
		}catch(DataAccessException e) {
			//converting SQLException to EmployeeException
			throw new PolicyNotFoundException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to EmployeeException
			throw new PolicyNotFoundException(e.getMessage());
		}
	}

	@Override
	public Policy updatePolicy(Policy policy) throws PolicyNotFoundException {
		try {
			return policyRepository.save(policy);
		}catch(DataAccessException e) {
			//converting SQLException to EmployeeException
			throw new PolicyNotFoundException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to EmployeeException
			throw new PolicyNotFoundException(e.getMessage());
		}

	}

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
			//converting SQLException to EmployeeException
			throw new PolicyNotFoundException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to EmployeeException
			throw new PolicyNotFoundException(e.getMessage());
		}
		

	}

	@Override
	public void removePolicy(Integer policyId) throws PolicyNotFoundException {
		try {
			policyRepository.deleteById(policyId);
		}catch(DataAccessException e) {
			//converting SQLException to EmployeeException
			throw new PolicyNotFoundException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to EmployeeException
			throw new PolicyNotFoundException(e.getMessage());
		}
		
	}

	@Override
	public List<Policy> showAllPolicies() throws PolicyNotFoundException {
		try {
			return policyRepository.findAll();
		}catch(DataAccessException e) {
			//converting SQLException to EmployeeException
			throw new PolicyNotFoundException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to EmployeeException
			throw new PolicyNotFoundException(e.getMessage());
		}
		
		
	}



}
