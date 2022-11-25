package com.cg.hims.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.cg.hims.application.HomeInsuranceManagementSystemApplication;
import com.cg.hims.entities.User;
import com.cg.hims.exceptions.InvalidLoginCredentialsException;
import com.cg.hims.exceptions.UserNameAlreadyExistsException;
import com.cg.hims.exceptions.UserNotFoundException;
import com.cg.hims.service.LoginService;


@SpringBootTest(classes = HomeInsuranceManagementSystemApplication.class)
@Transactional
@Rollback(true)
public  class UserTest 
{
	@Autowired

	private LoginService loginservice;
	
	public  User signup() throws UserNameAlreadyExistsException{
		User u = new User(9,"Kumar","pavan123","pavan","kumar","pkumar@gmail.com",543217654,"India","policyholder", null, null, null);
//		User u=new User();
//		u.setUserId(9);
//		u.setUserName("pavan");
//		u.setPassword("pavan123");
//		u.setFirstName("pavan");
//		u.setLastName("kumar");
//		u.setEmailId("pkumar@gmail.com");
//		u.setContactNo(543217654);
//		u.setAddress("India");
//		u.setRole("policyholder");
		//String s = loginservice.signup(u);
		return u;
	}

	/*
	 * check add user
	 */
	@Test
	public void testSignUp() throws UserNameAlreadyExistsException 
	{ User u = signup();
	String s=loginservice.signup(u);
	assertEquals("Added!",s);
	//assertEquals("pavan123",u.getPassword());
	}

	
	/*
	 * check user by ID
	 */
	@Test
	public void testgetuserbyId() throws UserNotFoundException, UserNameAlreadyExistsException 
	{   int id=9;
	User u1=signup();
	String s=loginservice.signup(u1);
	User u = loginservice.getUserById(id);
	assertEquals(9,u.getUserId());
	}

	
	/*
	 * check user login
	 */
	@Test
	public void login() throws  InvalidLoginCredentialsException, UserNameAlreadyExistsException, UserNotFoundException
	{  User u = signup();
	String un=u.getUserName();
	String p=u.getPassword();
	String s = loginservice.AuthenticateUser(un,p); 
	assertEquals("Kumar",u.getUserName());
	assertEquals("pavan123",u.getPassword());
	}

	
	/*
	 * check change Password
	 */
	@Test 
	public void testChangePassword() throws UserNotFoundException, UserNameAlreadyExistsException 
	{   User u = signup();
	String s=loginservice.signup(u);
	String un=u.getUserName();
	String newpwd = "newpwd";
	loginservice.changePassword(un,newpwd);
	assertEquals("newpwd",loginservice.getUserById(u.getUserId()).getPassword());
	}



}