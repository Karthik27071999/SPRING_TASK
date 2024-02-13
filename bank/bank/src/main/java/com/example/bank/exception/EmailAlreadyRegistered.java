package com.example.bank.exception;

public class EmailAlreadyRegistered extends RuntimeException{

	
	private static final long serialVersionUID = 1L;

	public EmailAlreadyRegistered(String message) {
		super(message);
		
	}
	

}
