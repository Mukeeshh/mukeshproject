package com.mukesh.exception;

public class EmployeeAlreadyExistsException extends Exception {
	
	public EmployeeAlreadyExistsException() {
		System.out.println("employee already exists in database");
	}

	public EmployeeAlreadyExistsException(String string) {
		super(string);
	}

}
