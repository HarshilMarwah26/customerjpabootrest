package com.cg.customerapp.exception;

public class InvalidNameException extends RuntimeException {

	public InvalidNameException() {
	}

	public InvalidNameException(String msg) {
		super(msg);

	}
}
