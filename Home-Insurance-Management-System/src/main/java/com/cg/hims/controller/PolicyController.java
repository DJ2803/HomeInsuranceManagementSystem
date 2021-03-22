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

import com.cg.hims.entities.Policy;
import com.cg.hims.exceptions.PolicyNotFoundException;
import com.cg.hims.service.PolicyServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api
@RestController
@RequestMapping("/policy")
public class PolicyController {
	@Autowired
	private PolicyServiceImpl policyServiceImpl;

	@ApiOperation(value = "Get all Policy",
			response = Policy.class,
			tags = "Get-all-Policy",			
			httpMethod = "GET")
	@GetMapping("/showall")
	public ResponseEntity<List<Policy>> showAllPolicies() throws PolicyNotFoundException{
		List<Policy> policyList = policyServiceImpl.showAllPolicies();
		return new ResponseEntity<>(policyList, HttpStatus.OK);
		
	}

	@ApiOperation(value = "Get Policy by Id",
			response = Policy.class,
			tags = "Get-Policy-By-Id",
			consumes = "policyId",
			httpMethod = "GET")
	@GetMapping("/showbyid/{policyId}")
	public ResponseEntity<Policy> findPolicyById(@PathVariable Integer policyId) {
		try {
			Policy policy = policyServiceImpl.findPolicyById(policyId);
			return new ResponseEntity<>(policy, HttpStatus.OK);
		}catch(PolicyNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	@ApiOperation(value = "Add Policy",
			response = Policy.class,
			tags = "Add-Policy",
			consumes = "policy Object",
			httpMethod = "POST")
	@PostMapping("/addpolicy")
	public ResponseEntity<Policy> addPolicy(@RequestBody Policy policy) throws PolicyNotFoundException {
		Policy policy1 = policyServiceImpl.addPolicy(policy);
		return new ResponseEntity<>(policy1, HttpStatus.OK);
		
	}

	@ApiOperation(value = "Update Policy",
			response = Policy.class,
			tags = "Update-Policy",
			consumes = "policy Object",
			httpMethod = "PUT")
	@PutMapping("/updatepolicy/{policyId}")
	public ResponseEntity<Policy> updatePolicy(@RequestBody Policy policy, @PathVariable Integer policyId) {
		try {
			Policy policy1 = policyServiceImpl.updatePolicy(policy);
			return new ResponseEntity<>(policy1, HttpStatus.OK);
		} catch (PolicyNotFoundException e) {
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	@ApiOperation(value = "Delete Policy",
			response = String.class,
			tags = "Delete-Policy",
			consumes = "policyId",
			httpMethod = "DELETE")
	@DeleteMapping("/deletepolicy/{policyId}")
	public ResponseEntity<String> removePolicy(@PathVariable Integer policyId) {
		try {
			policyServiceImpl.removePolicy(policyId);
			return new ResponseEntity<>("Policy deleted", HttpStatus.OK);
		} catch (PolicyNotFoundException e) {
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}

}
