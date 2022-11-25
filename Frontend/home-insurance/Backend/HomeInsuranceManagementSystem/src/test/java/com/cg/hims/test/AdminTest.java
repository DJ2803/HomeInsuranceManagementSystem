package com.cg.hims.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.time.Month;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.cg.hims.application.HomeInsuranceManagementSystemApplication;
import com.cg.hims.entities.Admin;
import com.cg.hims.entities.Agent;
import com.cg.hims.entities.Policy;
import com.cg.hims.entities.PolicyHolder;
import com.cg.hims.exceptions.AdminNotFoundException;
import com.cg.hims.exceptions.AgentException;
import com.cg.hims.exceptions.AgentNotFoundException;
import com.cg.hims.exceptions.PolicyHolderNotFoundException;
import com.cg.hims.exceptions.PolicyNotFoundException;
import com.cg.hims.service.AdminService;

@Transactional
@Rollback(true)
@SpringBootTest(classes = HomeInsuranceManagementSystemApplication.class)
public class AdminTest {
	
	@Autowired
	AdminService adminService;
	LocalDate d = LocalDate.of(2023, Month.JULY, 12);
	LocalDate d1 = LocalDate.of(2020, Month.JULY, 12);
	Admin ad = new Admin("Jegan");
	Policy policy = new Policy("Home_Insurance",d,d1,2,"Active");
	
	public Agent addAgent() {
		Agent agent = new Agent();
		agent.setAgentId(5);
		agent.setAgentName("Harsha");
		agent.setDesignation("Sales Agent");;
		agent.setSalary(200000.0);
		return agent;
	}
	
	public PolicyHolder addPh() {
		LocalDate d = LocalDate.of(2020, Month.APRIL,12);
		PolicyHolder ph = new PolicyHolder();
		ph.setPolicyHolderId(555);
		ph.setPolicyHolderName("Harsha");
		ph.setCreditCard("Visa");
		ph.setDob(d);
		ph.setOccupation("Designer");
		ph.setAnnualIncome(200000.0);
		ph.setRetired(false);
		ph.setResidenceType("Single");
		ph.setCity("Chennai");
		ph.setState("TN");
		ph.setZip(600006);
		ph.setResidenceUse("For 5 years");
		return ph;
	}
	
	
	
	@Test
	public void testAddPolicy() throws PolicyNotFoundException {
		Policy p = policy;
		adminService.addPolicy(p);
		assertEquals("Home_Insurance", adminService.getPolicyById(p.getPolicyId()).getPolicyName());
		assertEquals("Active",adminService.getPolicyById(p.getPolicyId()).getPolicyStatus());
	}
	
	@Test
	public void testUpdatePolicy() throws PolicyNotFoundException {
		Policy ph = policy;
		ph.setPolicyStatus("Closed");
		
		assertEquals("Closed",adminService.updatePolicy(ph).getPolicyStatus());
	}
	
	@Test
	public void testDeletePolicy() throws PolicyNotFoundException  {
		Policy ph = policy;
		adminService.addPolicy(ph);
		adminService.deletePolicy(ph.getPolicyId());
		assertThrows(PolicyNotFoundException.class, ()->{
			
			adminService.getPolicyById(ph.getPolicyId());
			});
	}
	
	/*
	 * check update agent
	 */
	@Test
	public void testUpdateAdmin() throws AdminNotFoundException {
		Admin admin = ad;
		admin.setAdminName("Jagan");
		
		assertEquals("Jagan",adminService.updateAdmin(admin).getAdminName());
	}
	
	/*
	 * check delete agent
	 */
	@Test
	public void testDeleteAgent() throws AgentNotFoundException, AgentException {
		Agent agent = addAgent();
		adminService.addAgent(agent);
		adminService.deleteAgent(agent.getAgentId());
		assertThrows(AgentNotFoundException.class, ()->{
			adminService.getAgentById(agent.getAgentId());
			});
	}
	
	@Test
	public void testDeletePolicyHolder() throws PolicyHolderNotFoundException {
		PolicyHolder ph = addPh();
		adminService.addPolicyHolder(ph);
		adminService.deletePolicyHolder(ph.getPolicyHolderId());
		assertThrows(PolicyHolderNotFoundException.class, ()->{
			adminService.getPolicyHolderById(ph.getPolicyHolderId());
			});
	}
	
	
	
	
}
