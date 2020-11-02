package com.cg.customerapp.exception;

public class CustomerNotFoundException extends RuntimeException {

	public CustomerNotFoundException() {

	}

	public CustomerNotFoundException(String msg) {
		super(msg);
	}

}
