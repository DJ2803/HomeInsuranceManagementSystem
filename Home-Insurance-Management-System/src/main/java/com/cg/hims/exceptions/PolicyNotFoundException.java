package com.cg.hims.exceptions;

public class PolicyNotFoundException extends Exception {

	public PolicyNotFoundException()
	{
		
	}
	public PolicyNotFoundException(String message)
	{
		super(message);
	}
	@Override
	public String toString() {
		return "PolicyNotFoundException " + super.toString();
	}
	
}
