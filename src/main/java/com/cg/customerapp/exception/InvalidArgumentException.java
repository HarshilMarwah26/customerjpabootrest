package com.cg.customerapp.exception;

public class InvalidArgumentException extends RuntimeException {
	
	public InvalidArgumentException() {

	}

	public InvalidArgumentException(String msg) {
		super(msg);
	}

}
