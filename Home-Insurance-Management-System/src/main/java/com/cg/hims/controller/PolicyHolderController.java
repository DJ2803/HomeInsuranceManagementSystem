package com.cg.hims.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cg.hims.entities.Policy;
import com.cg.hims.entities.PolicyHolder;
import com.cg.hims.entities.Property;
import com.cg.hims.entities.Quote;
import com.cg.hims.service.PolicyHolderService;
import com.cg.hims.service.PolicyService;
import com.cg.hims.service.PropertyService;
import com.cg.hims.service.QuoteService;

@RestController
@RequestMapping("/policyholder")
public class PolicyHolderController {

	@Autowired
	private PolicyHolderService ph;
	@Autowired
	private PolicyService ps;
	@Autowired
	private QuoteService qs;
	@Autowired
	private PropertyService pr;

	@PostMapping("/add")
	public ResponseEntity<String> addPolicyHolder(@RequestBody PolicyHolder policyHolder) {
		try {
			String ppt= ph.addPolicyHolder(policyHolder);
			return new ResponseEntity<>(ppt, HttpStatus.OK);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	} 
	@PutMapping("/update")
	public ResponseEntity<String> updatePolicyHolder(@RequestBody PolicyHolder policy) {
		try {
			String py= ph.updatePolicyHolder(policy);
			return new ResponseEntity<>(py, HttpStatus.OK);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	@GetMapping("/getbyid/{policyholder_id}")
	public ResponseEntity<PolicyHolder> getPolicyHolderById(@PathVariable Integer policyholder_id){
		try {
			PolicyHolder py = ph.findPolicyHolderById(policyholder_id);
			return new ResponseEntity<>(py, HttpStatus.OK);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}

	}
	
	@GetMapping("/showpolicies")
	public ResponseEntity<List<Policy>> showAllPolicies() {
		try {
			List<Policy> policyList = ps.showAllPolicies();
			return new ResponseEntity<>(policyList, HttpStatus.OK);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}

	}
	
	@PostMapping("/addproperty")
	public ResponseEntity<Property> addProperty(@RequestBody Property property) {
		try {
			Property ppt= pr.addProperty(property);
			return new ResponseEntity<>(ppt, HttpStatus.OK);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	@GetMapping("/getpropertybyid/{id}")
	public ResponseEntity<Property> viewPropertyById(@PathVariable int id){
		try {
			Property ppt = pr.viewProperty(id);
			return new ResponseEntity<>(ppt, HttpStatus.OK);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	@GetMapping("/getquotebyid/{quote_id}")
	public ResponseEntity<Quote> findQuoteById(@PathVariable Integer quote_id){
		try {
			Quote qu = qs.findQuoteById(quote_id);
			return new ResponseEntity<>(qu, HttpStatus.OK);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}

	}

}
