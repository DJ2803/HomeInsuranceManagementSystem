package com.cg.trg.login.exceptions;

public class UserNameAlreadyExistsException extends Exception {
	private static final long serialVersionUID = 1L;
	public UserNameAlreadyExistsException(String errorMessage) {
		super(errorMessage);
	}

}