package com.cg.hims.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hims.entities.PolicyHolder;
import com.cg.hims.exceptions.PolicyNotFoundException;
import com.cg.hims.repository.PolicyHolderRepository;
@Service
@Transactional
public class PolicyHolderServiceImpl implements PolicyHolderService{
	
	@Autowired
	private PolicyHolderRepository policyHolderRepository;
	@Override
	public List<PolicyHolder> showAllPolicyDetails() throws PolicyNotFoundException{
		return null;
		
	}

}
