package com.cg.hims.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hims.entities.Policy;
import com.cg.hims.exceptions.PolicyNotFoundException;
import com.cg.hims.service.IPolicyService;

@RestController
public class PolicyController {
	@Autowired
	private IPolicyService iPolicyService;
	@RequestMapping("/policies")
	public List<Policy> showAllPolicies(){
		return iPolicyService.showAllPolicies();
	}
	
	@GetMapping("/policies/{id}")
	public Policy findPolicyById(@PathVariable Integer policyId) {
		try {
			Policy policy = iPolicyService.findPolicyById(policyId);
			return policy;
		} catch (PolicyNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
		}
	}
	@RequestMapping(method = RequestMethod.POST, value = "/polices/{id}")
	public void addPolicy(@RequestBody Policy policy) {
		iPolicyService.addPolicy(policy);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/polices/{id}")
	public void updatePolicy(@RequestBody Policy policy, @PathVariable Integer policyId) {
		try {
			iPolicyService.updatePolicy(policy);
		} catch (PolicyNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/polices/{id}")
	public void removePolicy(@PathVariable Integer policyId) {
		try {
			iPolicyService.removePolicy(policyId);
		} catch (PolicyNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
