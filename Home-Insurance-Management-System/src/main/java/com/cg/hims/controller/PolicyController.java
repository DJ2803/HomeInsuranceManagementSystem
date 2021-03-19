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

import com.cg.hims.service.PolicyService;


@RestController
@RequestMapping("/policy")
public class PolicyController {
	@Autowired
	private PolicyService ps;
	@PostMapping("/add")
	public ResponseEntity<Policy> addPolicy(@RequestBody Policy policy) {
		try {
			Policy py= ps.addPolicy(policy);
			return new ResponseEntity<>(py, HttpStatus.OK);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	@PutMapping("/update")
	public ResponseEntity<Policy> updatePolicy(@RequestBody Policy policy) {
		try {
			Policy py= ps.updatePolicy(policy);
			return new ResponseEntity<>(py, HttpStatus.OK);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	@GetMapping("/showAll")
	public ResponseEntity<List<Policy>> showAllPolicies() {
		try {
			List<Policy> policyList = ps.showAllPolicies();
			return new ResponseEntity<>(policyList, HttpStatus.OK);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}

	}
	@GetMapping("/getById/{policy_id}")
	public ResponseEntity<Policy> getPolicyById(@PathVariable Integer policy_id){
		try {
			Policy py = ps.findPolicyById(policy_id);
			return new ResponseEntity<>(py, HttpStatus.OK);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}

	}
	@DeleteMapping("/delete/{policy_id}")
	public ResponseEntity<String> deletePolicy(@PathVariable Integer policy_id) {
		try {
			ps.removePolicy(policy_id);
			return new ResponseEntity<>("Policy deleted", HttpStatus.OK);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}

}
