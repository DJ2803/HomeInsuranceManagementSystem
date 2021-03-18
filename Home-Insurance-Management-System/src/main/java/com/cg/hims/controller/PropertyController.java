package com.cg.hims.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cg.hims.entities.Agent;
import com.cg.hims.entities.Property;
import com.cg.hims.exceptions.AgentException;
import com.cg.hims.service.IPropertyService;

@RestController
@RequestMapping("/api")
public class PropertyController {

	@Autowired
	private IPropertyService propertyService;
	
	@PostMapping("/property")
	public ResponseEntity<Property> addProperty(@RequestBody Property property) {
		try {
			Property ppt= propertyService.addProperty(property);
			return new ResponseEntity<>(ppt, HttpStatus.OK);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	@GetMapping("/property")
	public ResponseEntity<Property> viewProperty(){
		try {
			Property ppt = propertyService.viewProperty();
			return new ResponseEntity<>(ppt, HttpStatus.OK);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
}
