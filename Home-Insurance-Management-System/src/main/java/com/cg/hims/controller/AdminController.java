package com.cg.hims.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cg.hims.entities.Admin;
import com.cg.hims.entities.Agent;
import com.cg.hims.entities.Policy;
import com.cg.hims.entities.PolicyHolder;
import com.cg.hims.entities.Transactions;
import com.cg.hims.exceptions.AdminNotFoundException;
import com.cg.hims.exceptions.AgentException;
import com.cg.hims.exceptions.AgentNotFoundException;
import com.cg.hims.exceptions.PolicyHolderNotFoundException;
import com.cg.hims.exceptions.PolicyNotFoundException;
import com.cg.hims.exceptions.TransactionNotFoundException;
import com.cg.hims.service.AdminService;
import com.cg.hims.service.AgentService;

@RestController
@RequestMapping("/admin")
public class AdminController 
{
	@Autowired
	private AdminService iAdminService;
	@Autowired
	private AgentService agentService;
	
	@GetMapping("/getallpolicyholders")
	public ResponseEntity<List<PolicyHolder>> getAllPolicyHolders(){
		try {
			List<PolicyHolder> PolicyHolderList = iAdminService.getAllPolicyHolders();
			return new ResponseEntity<>(PolicyHolderList, HttpStatus.OK);
		}catch(PolicyHolderNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	@PostMapping("/addpolicyholder")
	public ResponseEntity<PolicyHolder> addPolicyHolder(@RequestBody PolicyHolder pHolder) {
		try {
			PolicyHolder policyHolder=iAdminService.addPolicyHolder(pHolder);
			return new ResponseEntity<>(policyHolder, HttpStatus.OK);
		}catch(PolicyHolderNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	@PutMapping("/updatepolicyholder")
	public ResponseEntity<PolicyHolder> updatePolicyHolder(@RequestBody PolicyHolder pHolder) {
		try {
			PolicyHolder policyHolder=iAdminService.updatePolicyHolder(pHolder);
			return new ResponseEntity<>(policyHolder, HttpStatus.OK);
		}catch(PolicyHolderNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	@GetMapping("/getpolicyholderbyid/{policyHolderId}")
	public ResponseEntity<PolicyHolder> getPolicyHolderById(@PathVariable Integer policyHolderId)
	{
		try {
			PolicyHolder policyHolder=iAdminService.getPolicyHolderById(policyHolderId);
			return new ResponseEntity<>(policyHolder, HttpStatus.OK);
		}catch(PolicyHolderNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	@DeleteMapping("/deletepolicyholder/{policyHolderId}")
	public ResponseEntity<String> deletePolicyHolder(@PathVariable Integer policyHolderId)
	{
		try {
			iAdminService.deletePolicyHolder(policyHolderId);
			return new ResponseEntity<>("PolicyHolder Deleted", HttpStatus.OK);
		}catch(PolicyHolderNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
//	
//	@GetMapping("/admin/transactions")
//	public ResponseEntity<List<Transactions>> getAllTransactions()
//	{
//		try {
//			List<Transactions> Tlist = iAdminService.getAllTransactions();
//			return new ResponseEntity<>(Tlist,HttpStatus.OK);
//		}catch(TransactionNotFoundException e) {
//			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
//		}
//	}
//	
//	@GetMapping("/admin/transactions/{policyHolderId}")
//	public ResponseEntity<List<Transactions>> getAllTransactionsByPolicyHolderId(@PathVariable Integer policyHolderId)
//	{
//		try {
//			List<Transactions> Tlist = iAdminService.getAllTransactionsByPolicyHolderId(policyHolderId);
//			return new ResponseEntity<>(Tlist,HttpStatus.OK);
//		}catch(TransactionNotFoundException e) {
//			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
//		}
//	}
//	
//	@GetMapping("/admin/transactions/{policyId}")
//	public ResponseEntity<List<Transactions>> getAllTransactionsByPolicyId(@PathVariable Integer policyId)
//	{
//		try {
//			List<Transactions> Tlist = iAdminService.getAllTransactionsByPolicyId(policyId);
//			return new ResponseEntity<>(Tlist,HttpStatus.OK);
//		}catch(TransactionNotFoundException e) {
//			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
//		}
//	}
//	
	@GetMapping("/getallpolicies")
	public ResponseEntity<List<Policy>> getAllPolicies()
	{
		try {
			List<Policy> Plist=iAdminService.getAllPolicies();
			return new ResponseEntity<>(Plist,HttpStatus.OK);
		}catch(PolicyNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	@GetMapping("/getpolicybyid/{policyId}")
	public ResponseEntity<Policy> getPolicyById(@PathVariable Integer policyId)
	{
		try {
			Policy policy=iAdminService.getPolicyById(policyId);
			return new ResponseEntity<>(policy,HttpStatus.OK);
		}catch(PolicyNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	@PostMapping("/addpolicy")
	public ResponseEntity<Policy> addPolicy(@RequestBody Policy policy) {
		try {
			Policy plcy=iAdminService.addPolicy(policy);
			return new ResponseEntity<>(plcy, HttpStatus.OK);
		}catch(PolicyNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	@PutMapping("/updatepolicy")
	public ResponseEntity<Policy> updatePolicy(@RequestBody Policy policy) {
		try {
			Policy plcy=iAdminService.updatePolicy(policy);
			return new ResponseEntity<>(plcy, HttpStatus.OK);
		}catch(PolicyNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	@DeleteMapping("/deletepolicy/{policyId}")
	public ResponseEntity<String> deletePolicy(@PathVariable Integer policyId)
	{
		try {
			iAdminService.deletePolicy(policyId);
			return new ResponseEntity<>("Policy Deleted",HttpStatus.OK);
		}catch(PolicyNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<Admin>> getAllAdmins()
	{
		try {
			List<Admin> Alist=iAdminService.getAllAdmins();
			return new ResponseEntity<>(Alist,HttpStatus.OK);
		}catch(AdminNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	@GetMapping("/getbyid/{adminId}")
	public ResponseEntity<Admin> getAdminById(@PathVariable Integer adminId)
	{
		try {
			Admin Adn=iAdminService.getAdminById(adminId);
			return new ResponseEntity<>(Adn,HttpStatus.OK);
		}catch(AdminNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	@PostMapping("/add")
	public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin) {
		try {
			Admin Adn=iAdminService.addAdmin(admin);
			return new ResponseEntity<>(Adn, HttpStatus.OK);
		}catch(AdminNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<Admin> updateAdmin(@RequestBody Admin admin) {
		try {
			Admin Adn=iAdminService.updateAdmin(admin);
			return new ResponseEntity<>(Adn, HttpStatus.OK);
		}catch(AdminNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	@DeleteMapping("/delete/{adminId}")
	public ResponseEntity<String> deleteAdmin(@PathVariable Integer AdminId)
	{
		try {
			iAdminService.deleteAdmin(AdminId);;
			return new ResponseEntity<>("Admin Deleted",HttpStatus.OK);
		}catch(AdminNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	@PostMapping("/addagent")
	public ResponseEntity<Agent> addAgent(@RequestBody Agent agent) {
		try {
			Agent agt= agentService.addAgent(agent);
			return new ResponseEntity<>(agt, HttpStatus.OK);
		}catch(AgentException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}

	@PutMapping("/updateagent")
	public ResponseEntity<Agent> updateAgent(@RequestBody Agent agent) {
		try {
			Agent agt= agentService.updateAgent(agent);
			return new ResponseEntity<>(agt, HttpStatus.OK);
		}catch(AgentNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}

	@DeleteMapping("/removeagent/{agtId}")
	public ResponseEntity<String> removeAgent(@PathVariable Integer agtId) {
		try {
			agentService.removeAgent(agtId);
			return new ResponseEntity<>("Employee deleted", HttpStatus.OK);
		}catch(AgentNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}

	@GetMapping("/findagentbyid/{agtId}")
	public ResponseEntity<Agent> findAgentById(@PathVariable Integer agtId){
		try {
			Agent agent = agentService.findAgentById(agtId);
			return new ResponseEntity<>(agent, HttpStatus.OK);
		}catch(AgentNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}

	}

	@GetMapping("/viewallagents")
	public ResponseEntity<List<Agent>> viewAllAgents(){
		try {
			List<Agent> agentList = agentService.viewAllAgents();
			return new ResponseEntity<>(agentList, HttpStatus.OK);
		}catch(AgentException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
}
