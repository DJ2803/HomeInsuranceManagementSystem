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
import com.cg.hims.entities.Property;
import com.cg.hims.entities.Quote;
import com.cg.hims.entities.Transactions;
import com.cg.hims.exceptions.AdminNotFoundException;
import com.cg.hims.exceptions.AgentException;
import com.cg.hims.exceptions.AgentNotFoundException;
import com.cg.hims.exceptions.PolicyHolderNotFoundException;
import com.cg.hims.exceptions.PolicyNotFoundException;
import com.cg.hims.exceptions.TransactionNotFoundException;
import com.cg.hims.service.AdminService;
import com.cg.hims.service.AgentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api
@RestController
@RequestMapping("/hims")
public class AdminController 
{
	@Autowired
	private AdminService iAdminService;
	
	@ApiOperation(value = "Get PolicyHolders",
			response = PolicyHolder.class,
			
			tags = "get-all PolicyHolders",			
			httpMethod = "GET")
	@GetMapping("/admin/getallpolicyholders")
	public ResponseEntity<List<PolicyHolder>> getAllPolicyHolders(){
		try {
			List<PolicyHolder> PolicyHolderList = iAdminService.getAllPolicyHolders();
			return new ResponseEntity<>(PolicyHolderList, HttpStatus.OK);
		}catch(PolicyHolderNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
//	@ApiOperation(value = "Add PolicyHolder",
//			response = PolicyHolder.class,
//			consumes = "PolicyHolder Object",
//			tags = "post-policyHolder record",
//			httpMethod = "POST")
//	@PostMapping("/admin/addpolicyholder")
//	public ResponseEntity<PolicyHolder> addPolicyHolder(@RequestBody PolicyHolder pHolder) {
//		try {
//			PolicyHolder policyHolder=iAdminService.addPolicyHolder(pHolder);
//			return new ResponseEntity<>(policyHolder, HttpStatus.OK);
//		}catch(PolicyHolderNotFoundException e) {
//			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
//		}
//	}
	@ApiOperation(value = "Update PolicyHolder",
			response = PolicyHolder.class,
			consumes = "PolicyHolder Object",
			tags = "update-policyHolder record-by admin",
			httpMethod = "PUT")
	@PutMapping("/admin/updatepolicyholder")
	public ResponseEntity<PolicyHolder> updatePolicyHolder(@RequestBody PolicyHolder pHolder) {
		try {
			PolicyHolder policyHolder=iAdminService.updatePolicyHolder(pHolder);
			return new ResponseEntity<>(policyHolder, HttpStatus.OK);
		}catch(PolicyHolderNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		} 
	}
	@ApiOperation(value = "Get PolicyHolder",
			response = PolicyHolder.class,
			consumes = "policyHolderId",
			tags = "get-policyHolder by Id",			
			httpMethod = "GET")
	@GetMapping("/admin/getpolicyholderbyid/{policyHolderId}")
	public ResponseEntity<PolicyHolder> getPolicyHolderById(@PathVariable Integer policyHolderId)
	{
		try {
			PolicyHolder policyHolder=iAdminService.getPolicyHolderById(policyHolderId);
			return new ResponseEntity<>(policyHolder, HttpStatus.OK);
		}catch(PolicyHolderNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	@ApiOperation(value = "Delete PolicyHolder",
			response = String.class,
			consumes = "policyHolderId",
			tags = "delete-policyHolder record",
			httpMethod = "DELETE")
	@DeleteMapping("/admin/deletepolicyholder/{policyHolderId}")
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
	@ApiOperation(value = "Get Policies",
			response = Policy.class,
		
			tags = "get-all policies",			
			httpMethod = "GET")
	@GetMapping("/admin/getallpolicies")
	public ResponseEntity<List<Policy>> getAllPolicies()
	{
		try {
			List<Policy> Plist=iAdminService.getAllPolicies();
			return new ResponseEntity<>(Plist,HttpStatus.OK);
		}catch(PolicyNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	@ApiOperation(value = "Get Policy",
			response = Policy.class,
			consumes = "policyId",
			tags = "get-policy by Id",			
			httpMethod = "GET")
	@GetMapping("/admin/getpolicybyid/{policyId}")
	public ResponseEntity<Policy> getPolicyById(@PathVariable Integer policyId)
	{
		try {
			Policy policy=iAdminService.getPolicyById(policyId);
			return new ResponseEntity<>(policy,HttpStatus.OK);
		}catch(PolicyNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	@ApiOperation(value = "Add Policy",
			response = Policy.class,
			consumes = "Policy Object",
			tags = "post-policy record",
			httpMethod = "POST")
	@PostMapping("/admin/addpolicy")
	public ResponseEntity<Policy> addPolicy(@RequestBody Policy policy) {
		try {
			Policy plcy=iAdminService.addPolicy(policy);
			return new ResponseEntity<>(plcy, HttpStatus.OK);
		}catch(PolicyNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	@ApiOperation(value = "Update Policy",
			response = Policy.class,
			consumes = "Policy Object",
			tags = "update-Policy record",
			httpMethod = "PUT")
	@PutMapping("/admin/updatepolicy")
	public ResponseEntity<Policy> updatePolicy(@RequestBody Policy policy) {
		try {
			Policy plcy=iAdminService.updatePolicy(policy);
			return new ResponseEntity<>(plcy, HttpStatus.OK);
		}catch(PolicyNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	@ApiOperation(value = "Delete Policy",
			response = String.class,
			consumes = "policyId",
			tags = "delete-policy record",
			httpMethod = "DELETE")
	@DeleteMapping("/admin/deletepolicy/{policyId}")
	public ResponseEntity<String> deletePolicy(@PathVariable Integer policyId)
	{
		try {
			iAdminService.deletePolicy(policyId);
			return new ResponseEntity<>("Policy Deleted",HttpStatus.OK);
		}catch(PolicyNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	@ApiOperation(value = "Get Admins",
			response = Admin.class,
			
			tags = "get-all admins",			
			httpMethod = "GET")
	@GetMapping("/admin/getall")
	public ResponseEntity<List<Admin>> getAllAdmins()
	{
		try {
			List<Admin> Alist=iAdminService.getAllAdmins();
			return new ResponseEntity<>(Alist,HttpStatus.OK);
		}catch(AdminNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	@ApiOperation(value = "Get Admin",
			response = Admin.class,
			consumes = "adminId",
			tags = "get-admin by Id",			
			httpMethod = "GET")
	@GetMapping("/admin/getbyid/{adminId}")
	public ResponseEntity<Admin> getAdminById(@PathVariable Integer adminId)
	{
		try {
			Admin Adn=iAdminService.getAdminById(adminId);
			return new ResponseEntity<>(Adn,HttpStatus.OK);
		}catch(AdminNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
//	@ApiOperation(value = "Add Admin",
//			response = Admin.class,
//			consumes = "Admin Object",
//			tags = "post-admin record",
//			httpMethod = "POST")
//	@PostMapping("/admin/add")
//	public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin) {
//		try {
//			Admin Adn=iAdminService.addAdmin(admin);
//			return new ResponseEntity<>(Adn, HttpStatus.OK);
//		}catch(AdminNotFoundException e) {
//			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
//		}
//	}
	@ApiOperation(value = "Update Admin",
			response = Admin.class,
			consumes = "Admin Object",
			tags = "update-admin record",
			httpMethod = "PUT")
	@PutMapping("/admin/update")
	public ResponseEntity<Admin> updateAdmin(@RequestBody Admin admin) {
		try {
			Admin Adn=iAdminService.updateAdmin(admin);
			return new ResponseEntity<>(Adn, HttpStatus.OK);
		}catch(AdminNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	@ApiOperation(value = "Delete Admin",
			response = String.class,
			consumes = "adminId",
			tags = "delete-admin record",
			httpMethod = "DELETE")
	@DeleteMapping("/admin/delete/{adminId}")
	public ResponseEntity<String> deleteAdmin(@PathVariable Integer AdminId)
	{
		try {
			iAdminService.deleteAdmin(AdminId);;
			return new ResponseEntity<>("Admin Deleted",HttpStatus.OK);
		}catch(AdminNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
//	@ApiOperation(value = "Add Agent",
//			response = Agent.class,
//			consumes = "Agent Object",
//			tags = "post-agent record",
//			httpMethod = "POST")
//	@PostMapping("/admin/addagent")
//	public ResponseEntity<Agent> addAgent(@RequestBody Agent agent) {
//		try {
//			Agent agt= iAdminService.addAgent(agent);
//			return new ResponseEntity<>(agt, HttpStatus.OK);
//		}catch(AgentException e) {
//			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
//		}
//	}
	@ApiOperation(value = "Update Agent",
			response = Agent.class,
			consumes = "Agent Object",
			tags = "update-agent record-by admin",
			httpMethod = "PUT")
	@PutMapping("/admin/updateagent")
	public ResponseEntity<Agent> updateAgent(@RequestBody Agent agent) {
		try {
			Agent agt= iAdminService.updateAgent(agent);
			return new ResponseEntity<>(agt, HttpStatus.OK);
		}catch(AgentNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	@ApiOperation(value = "Delete Agent",
			response = String.class,
			consumes = "agent_id",
			tags = "delete-agent record",
			httpMethod = "DELETE")
	@DeleteMapping("/admin/removeagent/{agent_id}")
	public ResponseEntity<String> removeAgent(@PathVariable Integer agent_id) {
		try {
			iAdminService.removeAgent(agent_id);
			return new ResponseEntity<>("Agent deleted", HttpStatus.OK);
		}catch(AgentNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	@ApiOperation(value = "Get Agent",
			response = Agent.class,
			consumes = "agent_id",
			tags = "get-agent by Id",			
			httpMethod = "GET")
	@GetMapping("/admin/findagentbyid/{agent_id}")
	public ResponseEntity<Agent> findAgentById(@PathVariable Integer agent_id){
		try {
			Agent agent = iAdminService.findAgentById(agent_id);
			return new ResponseEntity<>(agent, HttpStatus.OK);
		}catch(AgentNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}

	}
	@ApiOperation(value = "Get Agents",
			response = Agent.class,
			
			tags = "get-all agents",			
			httpMethod = "GET")
	@GetMapping("/admin/viewallagents")
	public ResponseEntity<List<Agent>> viewAllAgents(){
		try {
			List<Agent> agentList = iAdminService.viewAllAgents();
			return new ResponseEntity<>(agentList, HttpStatus.OK);
		}catch(AgentException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
}
