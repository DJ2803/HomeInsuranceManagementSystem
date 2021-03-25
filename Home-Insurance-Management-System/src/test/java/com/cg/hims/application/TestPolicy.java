package com.cg.hims.application;

import static org.junit.jupiter.api.Assertions.assertEquals;


import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cg.hims.entities.Policy;
import com.cg.hims.exceptions.PolicyNotFoundException;
import com.cg.hims.service.PolicyService;

class TestPolicy {
	@Autowired
	private PolicyService policyService;
	Policy policy = new Policy();
	
	public Policy addPolicy(){
		
		policy.setPolicyName("PRO SECURE");
		LocalDate date1 = LocalDate.of(2020, Month.APRIL,12);
		LocalDate date2 = LocalDate.of(2020, Month.DECEMBER,12);
		policy.setPolicyEffectiveDate(date1);
		policy.setPolicyEndDate(date2);
		policy.setPolicyTerm(10);
		policy.setPolicyStatus("ACTIVE");
		System.out.println("add function");
		System.out.println(policy);
		return policy;
	}

	@Test
	public void testAddPolicy() throws PolicyNotFoundException{
		Policy policy = addPolicy();
		policyService.addPolicy(policy);
		assertEquals("PRO SECURE",policy.getPolicyName());
		assertEquals("ACTIVE",policy.getPolicyStatus());
		assertEquals(10,policy.getPolicyTerm());
	}

}
