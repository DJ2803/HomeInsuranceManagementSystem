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

import com.cg.hims.entities.Agent;
import com.cg.hims.entities.PolicyHolder;
import com.cg.hims.entities.Quote;
import com.cg.hims.exceptions.AgentException;
import com.cg.hims.exceptions.AgentNotFoundException;
import com.cg.hims.exceptions.PolicyHolderNotFoundException;
import com.cg.hims.service.AgentService;
import com.cg.hims.service.QuoteService;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author rohith
 *
 */

@Api
@RestController

@RequestMapping("/hims")
public class AgentController {
	@Autowired
	private AgentService agentService;
	
//	@ApiOperation(value = "Add Agent",
//			response = Agent.class,
//			consumes = "Agent Object",
//			tags = "post-Agent record",
//			httpMethod = "POST")
//	@PostMapping("/agent/addagent")
//	public ResponseEntity<Agent> addAgent(@RequestBody Agent agent) {
//		try {
//			Agent agt= agentService.addAgent(agent);
//			return new ResponseEntity<>(agt, HttpStatus.OK);
//		}catch(AgentException e) {
//			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
//		}
//	}
	
	@ApiOperation(value = "Update Agent",
			response = Agent.class,
			consumes = "Agent Object",
			tags = "update-Agent record",
			httpMethod = "PUT")
	@PutMapping("/agent/update")
	public ResponseEntity<Agent> updateAgent(@RequestBody Agent agent) {
		try {
			Agent agt= agentService.updateAgent(agent);
			return new ResponseEntity<>(agt, HttpStatus.OK);
		}catch(AgentNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}

//	@DeleteMapping("/remove/{agtId}")
//	public ResponseEntity<String> removeAgent(@PathVariable Integer agtId) {
//		try {
//			agentService.removeAgent(agtId);
//			return new ResponseEntity<>("Employee deleted", HttpStatus.OK);
//		}catch(AgentNotFoundException e) {
//			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
//		}
//	}

	@ApiOperation(value = "Get agent",
			response = Agent.class,
			consumes = "agent_id",
			tags = "get-agentById",			
			httpMethod = "GET")
	@GetMapping("/agent/findagentbyid/{agtId}")
	public ResponseEntity<Agent> findAgentById(@PathVariable Integer agtId){
		try {
			Agent agent = agentService.findAgentById(agtId);
			return new ResponseEntity<>(agent, HttpStatus.OK);
		}catch(AgentNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}

	}

//	@GetMapping("/viewAllAgents")
//	public ResponseEntity<List<Agent>> viewAllAgents(){
//		try {
//			List<Agent> agentList = agentService.viewAllAgents();
//			return new ResponseEntity<>(agentList, HttpStatus.OK);
//		}catch(AgentException e) {
//			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
//		} 
//	}
	@ApiOperation(value = "Add Quote",
			response = Quote.class,
			consumes = "Quote Object",
			tags = "post-Quote record",
			httpMethod = "POST")
	@PostMapping("/agent/addquote")
	public ResponseEntity<Quote> addQuote(@RequestBody Quote quote) {
		try {
			Quote qu= agentService.addQuote(quote);
			return new ResponseEntity<>(qu, HttpStatus.OK);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	@ApiOperation(value = "Update Quote",
			response = Quote.class,
			consumes = "Quote Object",
			tags = "update-Quote record",
			httpMethod = "PUT")
	@PutMapping("/agent/updatequote")
	public ResponseEntity<Quote> updateQuote(@RequestBody Quote quote) {
		try {
			Quote qu= agentService.updateQuote(quote);
			return new ResponseEntity<>(qu, HttpStatus.OK);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	@ApiOperation(value = "Get quotes",
			response = Quote.class,
			tags = "get-allQuotes",			
			httpMethod = "GET")
	@GetMapping("/agent/showallquotes")
	public ResponseEntity<List<Quote>> showAllQuotes() {
		try {
			List<Quote> quoteList = agentService.showAllQuotes();
			return new ResponseEntity<>(quoteList, HttpStatus.OK);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}

	}
	@ApiOperation(value = "Get quote",
			response = Quote.class,
			consumes = "quote_id",
			tags = "get-quoteById",			
			httpMethod = "GET")
	@GetMapping("/agent/findquotebyid/{quote_id}")
	public ResponseEntity<Quote> findQuoteById(@PathVariable Integer quote_id){
		try {
			Quote qu = agentService.findQuoteById(quote_id);
			return new ResponseEntity<>(qu, HttpStatus.OK);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}

	}
	@ApiOperation(value = "Delete quote",
			response = String.class,
			consumes = "quote_id",
			tags = "delete-quote record",
			httpMethod = "DELETE")
	@DeleteMapping("/agent/deletequote/{quote_id}")
	public ResponseEntity<String> removeQuote(@PathVariable Integer quote_id) {
		try {
			agentService.removeQuote(quote_id);
			return new ResponseEntity<>("Quote deleted", HttpStatus.OK);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	@ApiOperation(value = "Get policy Holders",
			response = PolicyHolder.class,
			tags = "get-allPolicyHolders",			
			httpMethod = "GET")
	@GetMapping("/agent/getallpolicyholders")
	public ResponseEntity<List<PolicyHolder>> getAllPolicyHolders(){
		try {
			List<PolicyHolder> PolicyHolderList = agentService.getAllPolicyHolders();
			return new ResponseEntity<>(PolicyHolderList, HttpStatus.OK);
		}catch(PolicyHolderNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
//	@PostMapping("/addpolicyholder")
//	public ResponseEntity<PolicyHolder> addPolicyHolder(@RequestBody PolicyHolder pHolder) {
//		try {
//			PolicyHolder policyHolder=agentService.addPolicyHolder(pHolder);
//			return new ResponseEntity<>(policyHolder, HttpStatus.OK);
//		}catch(PolicyHolderNotFoundException e) {
//			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
//		}
//	}
	
//	@PutMapping("/updatepolicyholder")
//	public ResponseEntity<PolicyHolder> updatePolicyHolder(@RequestBody PolicyHolder pHolder) {
//		try {
//			PolicyHolder policyHolder=agentService.updatePolicyHolder(pHolder);
//			return new ResponseEntity<>(policyHolder, HttpStatus.OK);
//		}catch(PolicyHolderNotFoundException e) {
//			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
//		}
//	}
	@ApiOperation(value = "Get policyHolder",
			response = PolicyHolder.class,
			consumes = "policyHolderId",
			tags = "get-policyHolderById",			
			httpMethod = "GET")
	@GetMapping("/agent/getpolicyholderbyid/{policyHolderId}")
	public ResponseEntity<PolicyHolder> getPolicyHolderById(@PathVariable Integer policyHolderId)
	{
		try {
			PolicyHolder policyHolder=agentService.getPolicyHolderById(policyHolderId);
			return new ResponseEntity<>(policyHolder, HttpStatus.OK);
		}catch(PolicyHolderNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	@ApiOperation(value = "Delete policyHolder",
			response = String.class,
			consumes = "policyHolderId",
			tags = "delete-policyHolder record",
			httpMethod = "DELETE")
	@DeleteMapping("/agent/deletepolicyholder/{policyHolderId}")
	public ResponseEntity<String> deletePolicyHolder(@PathVariable Integer policyHolderId)
	{
		try {
			agentService.deletePolicyHolder(policyHolderId);
			return new ResponseEntity<>("PolicyHolder Deleted", HttpStatus.OK);
		}catch(PolicyHolderNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}

}
