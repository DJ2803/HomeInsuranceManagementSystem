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
import com.cg.hims.entities.Agent;
import com.cg.hims.entities.PolicyHolder;
import com.cg.hims.entities.Quote;
import com.cg.hims.exceptions.AgentException;
import com.cg.hims.exceptions.AgentNotFoundException;
import com.cg.hims.exceptions.QuoteNotFoundException;
import com.cg.hims.service.AgentService;

@SpringBootTest(classes = HomeInsuranceManagementSystemApplication.class)
@Transactional
@Rollback(true)
public class AgentTest 
{

	@Autowired
	private AgentService agentService;
	
	public Agent addAgent() {
		Agent agent = new Agent();
//		agent.setAgentId(5);
		agent.setAgentName("Harsha");
		agent.setDesignation("Sales Agent");;
		agent.setSalary(200000.0);
		return agent;
	}
	public PolicyHolder addPh() {
		LocalDate d = LocalDate.of(2020, Month.APRIL,12);
		PolicyHolder ph = new PolicyHolder();
//		ph.setPolicyHolderId(555);
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
	
	public Quote addQuote()
	{
		Quote q = new Quote();
//		q.setQuoteId(444);
		q.setPremiumType("Platinum");
		q.setPremiumAmount(2000000.0);
		q.setDwellingCoverage(2000.0);
		q.setDetachedStructureCoverage(1000.0);
		q.setAdditionalLivingExpense(3000.0);
		q.setMedicalExpense(5000.0);
		q.setDeducibleAmount(500.0);
		return q;
	}
	
	
	

	/*
	 * check add agent
	 */
	@Test
	public void testAddAgent() throws  AgentNotFoundException, AgentException{
		Agent agent = addAgent();
		agentService.addAgent(agent);
		assertEquals("Harsha", agentService.findAgentById(agent.getAgentId()).getAgentName());
		assertEquals("Sales Agent",agentService.findAgentById(agent.getAgentId()).getDesignation());
	}
	
	/*
	 * check update agent
	 */
	@Test
	public void testUpdateAgent() throws AgentNotFoundException {
		Agent agent = addAgent();
		agent.setDesignation("Agent");
		agentService.updateAgent(agent);
		assertEquals("Agent",agentService.findAgentById(agent.getAgentId()).getDesignation());
	}
	
	/*
	 * check delete agent
	 */
//	@Test
//	public void testDeleteAgent() throws AgentNotFoundException, AgentException {
//		Agent agent = addAgent();
//		agentService.addAgent(agent);
////		agentService.removeAgent(agent.getAgentId());
//		assertThrows(AgentNotFoundException.class, ()->{
//			
//			agentService.findAgentById(agent.getAgentId());
//			});
//	}
	
//	@Test
//	public void testDeletePolicyHolder() throws PolicyHolderNotFoundException {
//		PolicyHolder ph = addPh();
//		agentService.addPolicyHolder(ph);
//		agentService.deletePolicyHolder(ph.getPolicyHolderId());
//		assertThrows(PolicyHolderNotFoundException.class, ()->{
//			
//			agentService.getPolicyHolderById(ph.getPolicyHolderId());
//			});
//	}
	
	
	@Test
	public void testAddQuote() throws Exception{
		Quote q = addQuote();
		agentService.addQuote(q);
		assertEquals("Platinum", q.getPremiumType());
		assertEquals(2000000.0,q.getPremiumAmount());
	}
	
	@Test
	public void testUpdateQuote() throws QuoteNotFoundException {
		Quote q = addQuote();
		q.setPremiumAmount(10000);;
		agentService.updateQuote(q);
		assertEquals(10000,agentService.viewQuote(q.getQuoteId()).getPremiumAmount());
	}
	
	@Test
	public void testDeleteQuote() throws QuoteNotFoundException {
		Quote q = addQuote();
		agentService.addQuote(q);
		agentService.removeQuote(q.getQuoteId());
		assertThrows(QuoteNotFoundException.class, ()->{
			
			agentService.viewQuote(q.getQuoteId());
			});
	}
	
	
	
	
}
