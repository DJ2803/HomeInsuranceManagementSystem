package com.cg.trg.login.exceptions;

public class PhoneNumberExistsException extends Exception {
	private static final long serialVersionUID = 1L;
	public PhoneNumberExistsException(String errorMessage) {
		super(errorMessage);
	}
}
