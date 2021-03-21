package com.cg.hims.controller;

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

import com.cg.hims.entities.User;
import com.cg.hims.service.LoginService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api
@RestController
@RequestMapping("/hims/user")
public class LoginController {
	
	/*
	 * Asking the autowired to create the instance of the bean
	 */
	@Autowired
	LoginService service;
	@ApiOperation(value = "Signup User",
	response = String.class,
	consumes = "user Object",
	tags = "sign-up user",
	httpMethod = "POST")	
	@PostMapping("/signup")
	public ResponseEntity<String> signup(@RequestBody User user) {
		try {
			String ppt= service.signup(user);
			return new ResponseEntity<>(ppt, HttpStatus.OK);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	} 

//	//HTTP request for checking Login Credentials
//	@GetMapping("/check/{user_id}/{password}")
//	public ResponseEntity<String> checkUser(@PathVariable Integer user_id,@PathVariable String password){
//		try {
//			String unew = service.checkUser(user_id,password);
//			return new ResponseEntity<>(unew, HttpStatus.OK);
//		}catch(Exception e) {
//			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
//		}
//	}

	@ApiOperation(value = "Authenticate User",
			response = String.class,
			consumes = "user Object",
			tags = "authenticate user",
			httpMethod = "GET")
	@GetMapping("/login/{username}/{password}")
	public ResponseEntity<String> AuthenticateUser(@PathVariable String username,@PathVariable String password){
		try {
			String unew = service.AuthenticateUser(username,password);
			return new ResponseEntity<>(unew, HttpStatus.OK);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	@ApiOperation(value = "Change Password",
			response = String.class,
			consumes = "user Object",
			tags = "change password",
			httpMethod = "PUT")
	@PutMapping("/changePassword/{username}/{new_password}")
	public ResponseEntity<String> changePassword(@PathVariable String username,@PathVariable String new_password){
		try {
			String unew = service.changePassword(username,new_password);
			return new ResponseEntity<>(unew, HttpStatus.OK);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	@ApiOperation(value = "Get User",
			response = User.class,
			consumes = "userId Object",
			tags = "Get User",
			httpMethod = "GET")
	@GetMapping("/getuser/{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id){
		try {
			User qu = service.getUserById(id);
			return new ResponseEntity<>(qu, HttpStatus.OK);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}

	}
	
	
}