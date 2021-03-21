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

import com.cg.hims.entities.Agent;
import com.cg.hims.entities.Policy;
import com.cg.hims.entities.PolicyHolder;
import com.cg.hims.entities.Property;
import com.cg.hims.entities.Quote;
import com.cg.hims.exceptions.PolicyHolderNotFoundException;
import com.cg.hims.service.PolicyHolderService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api
@RestController
@RequestMapping("/hims")
public class PolicyHolderController {

	@Autowired
	private PolicyHolderService ph;
//	@Autowired
//	private PolicyService ps;
//	@Autowired
//	private QuoteService qs;
//	@Autowired
//	private PropertyService pr;
//	@ApiOperation(value = "Add policyHolder",
//			response = String.class,
//			consumes = "policyHolder Object",
//			tags = "post-policy Holder record",
//			httpMethod = "POST")
//	@PostMapping("/policyholder/add")
//	public ResponseEntity<String> addPolicyHolder(@RequestBody PolicyHolder policyHolder) {
//		try {
//			String ppt= ph.addPolicyHolder(policyHolder);
//			return new ResponseEntity<>(ppt, HttpStatus.OK);
//		}catch(Exception e) {
//			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
//		}
//	} 
	@ApiOperation(value = "Update policyHolder",
			response = String.class,
			consumes = "policyHolder Object",
			tags = "update-policyHolder record",
			httpMethod = "PUT")
	@PutMapping("/policyholder/update/{policy_holder_id}")
	public ResponseEntity<String> updatePolicyHolder(@PathVariable int policy_holder_id,@RequestBody PolicyHolder policy) {
		try {
			String py= ph.updatePolicyHolder(policy);
			return new ResponseEntity<>(py, HttpStatus.OK);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	@ApiOperation(value = "Get policyHolder",
			response = PolicyHolder.class,
			consumes = "policyholder_id",
			tags = "get-policyHolder by Id",			
			httpMethod = "GET")
	@GetMapping("/policyholder/view/{policyholder_id}")
	public ResponseEntity<PolicyHolder> viewPolicyHolder(@PathVariable int policyholder_id){
		try {
			PolicyHolder py = ph.viewPolicyHolder(policyholder_id);
			return new ResponseEntity<>(py, HttpStatus.OK);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}

	}
	@ApiOperation(value = "Get Policy",
			response = Policy.class,
			consumes = "policy_id",
			tags = "view-policy by Id",			
			httpMethod = "GET")
	@GetMapping("/policyholder/viewpolicy/{policy_id}")
	public ResponseEntity<Policy> viewPolicy(@PathVariable int policy_id) {
		try {
			Policy policy = ph.viewPolicy(policy_id);
			return new ResponseEntity<>(policy, HttpStatus.OK);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}

	}
	@ApiOperation(value = "Add property",
			response = Property.class,
			consumes = "Property Object",
			tags = "post-Property record",
			httpMethod = "POST")
	@PostMapping("/policyholder/addproperty")
	public ResponseEntity<Property> addProperty(@RequestBody Property property) {
		try {
			Property ppt= ph.addProperty(property);
			return new ResponseEntity<>(ppt, HttpStatus.OK);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	@ApiOperation(value = "Update Property",
			response = Property.class,
			consumes = "Property Object",
			tags = "update-Property record",
			httpMethod = "PUT")
	@PutMapping("/policyholder/updateproperty")
	public ResponseEntity<Property> updateProperty(@RequestBody Property property) {
		try {
			Property ppt= ph.updateProperty(property);
			return new ResponseEntity<>(ppt, HttpStatus.OK);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	@ApiOperation(value = "Get Property",
			response = Property.class,
			consumes = "property_id",
			tags = "get-property by Id",			
			httpMethod = "GET")
	@GetMapping("/policyholder/viewproperty/{property_id}")
	public ResponseEntity<Property> viewProperty(@PathVariable int property_id){
		try {
			Property ppt = ph.viewProperty(property_id);
			return new ResponseEntity<>(ppt, HttpStatus.OK);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	@ApiOperation(value = "Get Quote",
			response = Quote.class,
			consumes = "quote_id",
			tags = "get-quote by Id",			
			httpMethod = "GET")
	@GetMapping("/policyholder/viewquote/{quote_id}")
	public ResponseEntity<Quote> viewQuote(@PathVariable int quote_id){
		try {
			Quote qu = ph.viewQuote(quote_id);
			return new ResponseEntity<>(qu, HttpStatus.OK);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}

	}
//	@ApiOperation(value = "Delete quote",
//			response = String.class,
//			consumes = "quote_id",
//			tags = "Delete quote record",
//			httpMethod = "DELETE")
//	@DeleteMapping("/policyholder/deletepolicyholder/{policyHolderId}")
//	public ResponseEntity<String> deletePolicyHolder(@PathVariable int policyHolderId)
//	{
//		try {
//			ph.removePolicyHolder(policyHolderId);
//			return new ResponseEntity<>("PolicyHolder Deleted", HttpStatus.OK);
//		}catch(PolicyHolderNotFoundException e) {
//			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
//		}
//	}
	
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
