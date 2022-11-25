package com.cg.hims.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.time.Month;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.cg.hims.application.HomeInsuranceManagementSystemApplication;
import com.cg.hims.entities.PolicyHolder;
import com.cg.hims.entities.Property;
import com.cg.hims.exceptions.PolicyHolderNotFoundException;
import com.cg.hims.service.PolicyHolderService;

@SpringBootTest(classes = HomeInsuranceManagementSystemApplication.class)
@Transactional
@Rollback(true)
public class PolicyHolderTest {
	@Autowired
	private PolicyHolderService phs;
	
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
	
	public Property addProperty()
	{
		Property p =new Property();
		p.setHasSwimmingPool(true);
		p.setMarketValue(100000L);
		p.setSquareFootage(500);
		p.setYearBuilt(1994);
		return p;
		
	}
	
	@Test
	public void testAddProperty() throws Exception{
		Property p = addProperty();
		phs.addProperty(p);
		assertEquals(100000L, p.getMarketValue());
		assertEquals(500,p.getSquareFootage());
	}
	
	/*
	 * check update agent
	 */
	@Test
	public void testUpdateProperty() throws Exception  {
		Property p = addProperty();
		phs.addProperty(p);
		p.setYearBuilt(1995);
		phs.updateProperty(p);
		assertEquals(1995,phs.viewProperty(p.getPropertyId()).getYearBuilt());
	}
	
	/*
	 * check delete agent
	 */
	@Test
	public void testDeletePolicyHolder() throws PolicyHolderNotFoundException,Exception {
		PolicyHolder pr = addPh();
		phs.addPolicyHolder(pr);
		int i=pr.getPolicyHolderId();
		phs.removePolicyHolder(i);
		assertThrows(PolicyHolderNotFoundException.class, ()->{
			
			phs.viewPolicyHolder(pr.getPolicyHolderId());
			});
//		assertThrows(RecordNotFoundException.class, ()->{
//			deliveryService.findByPk(delivery.getDeliveryId());
//			});	
//		assertEquals("Harsha",phs.viewPolicyHolder(pr.getPolicyHolderId()).getPolicyHolderName());
		}
	
	@Test
	public void testUpdatePolicyHolder() throws PolicyHolderNotFoundException,Exception  {
		PolicyHolder ph = addPh();
		ph.setPolicyHolderName("Kunal");
		phs.updatePolicyHolder(ph);
		assertEquals("Kunal",phs.viewPolicyHolder(ph.getPolicyHolderId()).getPolicyHolderName());
	}

}
