package com.cg.trg.login.Loginpagedao;
import com.cg.trg.login.Loginpage.User;

import com.cg.trg.login.exceptions.InvalidLoginCredentialsException;
import com.cg.trg.login.exceptions.PhoneNumberExistsException;
import com.cg.trg.login.exceptions.UserNameAlreadyExistsException;

public interface LoginPageDao {
	
	public User addAccount(User us);
	
	public boolean checkUser( String userName, String password) throws InvalidLoginCredentialsException;

	public boolean userNameExists(String userName) throws  UserNameAlreadyExistsException ;
	
	boolean phNoExists(String phoneNo) throws PhoneNumberExistsException;
}
