package com.cg.hims.application;

import static org.junit.Assert.assertEquals;


import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.hims.entities.Policy;
import com.cg.hims.entities.Transaction;
import com.cg.hims.exceptions.PolicyNotFoundException;
import com.cg.hims.repository.PolicyRepository;
import com.cg.hims.service.PolicyService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class PolicyControllerTest {

	@MockBean
	private PolicyRepository policyRepository;

	@Autowired
	private PolicyService policyService; 
	
		
	@Test
	void showAllPoliciesTest() throws PolicyNotFoundException {
		Mockito.when(policyRepository.findAll()).thenReturn(Stream.of(new Policy(121,"Max Secure",LocalDate.of(2022,01,01),LocalDate.of(2021,01,01),12,"Active"),
				new Policy(122,"Max Secure 1.0",LocalDate.of(2022,01,01),LocalDate.of(2021,01,01),12,"IN Active")).collect(Collectors.toList()));
		assertEquals(2, policyService.showAllPolicies().size());

	}
	@Test
	void invalidShowAllPolicieTest() {
		Policy policy = new Policy();
		Mockito.when(policyRepository.findAll()).thenThrow(new RuntimeException());
	}
	@Test
	void addPolicyTest() throws PolicyNotFoundException {
		Policy policy = new Policy(144,"Max Secure 4.4",LocalDate.of(2022,01,01),LocalDate.of(2021,01,01),12," IN Active");
		Mockito.when(policyRepository.save(policy)).thenReturn(policy);
		assertEquals(policy,policyService.addPolicy(policy));
	}
	
	@Test
	void invalidAddPolicyTest() {
		Policy policy = new Policy(144,null,LocalDate.of(2022,01,01),LocalDate.of(2021,01,01),12," IN Active");
		Mockito.when(policyRepository.save(policy)).thenThrow(new RuntimeException());
	}

	//	void findPolicyByIdTest() {
	//		Policy policy = new Policy(144,"Max Secure 4.4",LocalDate.of(2022,01,01),LocalDate.of(2021,01,01),12," IN Active");
	//		Integer policyId = policy.getPolicyId();
	//		Mockito.when(policyRepository.findById(policyId)).thenReturn(policy)
	//	}
	
	@Test
	void removePolicyTest() throws PolicyNotFoundException {
		Policy policy = new Policy(144,"Max Secure 4.4",LocalDate.of(2022,01,01),LocalDate.of(2021,01,01),12," IN Active");
		Integer policyId = policy.getPolicyId();
		policyService.removePolicy(policyId);
		verify(policyRepository, times(1)).deleteById(policyId);
	}

	@Test
	public void updatePolicyTest() throws PolicyNotFoundException
	{
		Policy policy = new Policy(144,"Max Secure 4.4",LocalDate.of(2022,01,01),LocalDate.of(2021,01,01),12," IN Active");
		Mockito.when(policyRepository.save(policy)).thenReturn(policy);
		Policy result=policyService.updatePolicy(policy);
		assertEquals(policy,result);
	}




}
