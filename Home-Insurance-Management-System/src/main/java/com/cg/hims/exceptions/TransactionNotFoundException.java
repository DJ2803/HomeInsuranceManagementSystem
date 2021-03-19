package com.cg.hims.exceptions;

public class TransactionNotFoundException extends Exception{
	public TransactionNotFoundException() {

	}


	public TransactionNotFoundException(String message) {
			super(message);
	}
	
	@Override
	public String toString() {
		return "TransactionNotFoundException:" + super.getMessage();
	}
	

}
