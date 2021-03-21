package com.cg.hims.controller;

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
import com.cg.hims.entities.PolicyHolder;
import com.cg.hims.entities.Property;
import com.cg.hims.entities.Quote;
import com.cg.hims.exceptions.PolicyHolderNotFoundException;
import com.cg.hims.service.PolicyHolderService;

@RestController
@RequestMapping("/policyholder")
public class PolicyHolderController {

	@Autowired
	private PolicyHolderService ph;
//	@Autowired
//	private PolicyService ps;
//	@Autowired
//	private QuoteService qs;
//	@Autowired
//	private PropertyService pr;

	@PostMapping("/add")
	public ResponseEntity<String> addPolicyHolder(@RequestBody PolicyHolder policyHolder) {
		try {
			String ppt= ph.addPolicyHolder(policyHolder);
			return new ResponseEntity<>(ppt, HttpStatus.OK);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	} 
	@PutMapping("/update/{policy_holder_id}")
	public ResponseEntity<String> updatePolicyHolder(@PathVariable int policy_holder_id,@RequestBody PolicyHolder policy) {
		try {
			String py= ph.updatePolicyHolder(policy);
			return new ResponseEntity<>(py, HttpStatus.OK);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	@GetMapping("/view/{policyholder_id}")
	public ResponseEntity<PolicyHolder> viewPolicyHolder(@PathVariable int policyholder_id){
		try {
			PolicyHolder py = ph.viewPolicyHolder(policyholder_id);
			return new ResponseEntity<>(py, HttpStatus.OK);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}

	}
	
	@GetMapping("/viewpolicy/{policy_id}")
	public ResponseEntity<Policy> viewPolicy(@PathVariable int policy_id) {
		try {
			Policy policy = ph.viewPolicy(policy_id);
			return new ResponseEntity<>(policy, HttpStatus.OK);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}

	}
	
//	@PostMapping("/addproperty")
//	public ResponseEntity<Property> addProperty(@RequestBody Property property) {
//		try {
//			Property ppt= pr.addProperty(property);
//			return new ResponseEntity<>(ppt, HttpStatus.OK);
//		}catch(Exception e) {
//			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
//		}
//	}
	
//	@PutMapping("/updateproperty")
//	public ResponseEntity<Property> updateProperty(@RequestBody Property property) {
//		try {
//			Property ppt= pr.updateProperty(property);
//			return new ResponseEntity<>(ppt, HttpStatus.OK);
//		}catch(Exception e) {
//			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
//		}
//	}
	
	@GetMapping("/viewproperty/{property_id}")
	public ResponseEntity<Property> viewProperty(@PathVariable int property_id){
		try {
			Property ppt = ph.viewProperty(property_id);
			return new ResponseEntity<>(ppt, HttpStatus.OK);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	@GetMapping("/viewquote/{quote_id}")
	public ResponseEntity<Quote> viewQuote(@PathVariable int quote_id){
		try {
			Quote qu = ph.viewQuote(quote_id);
			return new ResponseEntity<>(qu, HttpStatus.OK);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}

	}
	
	@DeleteMapping("/deletepolicyholder/{policyHolderId}")
	public ResponseEntity<String> deletePolicyHolder(@PathVariable int policyHolderId)
	{
		try {
			ph.removePolicyHolder(policyHolderId);
			return new ResponseEntity<>("PolicyHolder Deleted", HttpStatus.OK);
		}catch(PolicyHolderNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
//	@PutMapping("/updatequote/{quote_id}")
//	public ResponseEntity<Quote> updateQuote(@PathVariable int quote_id,@RequestBody Quote quote) {
//		try {
//			Quote py= qs.updateQuote(quote);
//			return new ResponseEntity<>(py, HttpStatus.OK);
//		}catch(Exception e) {
//			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
//		}
//	}

}
