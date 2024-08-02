package com.SnapChat.Exception;

public class FailedAccountCreation extends Exception {

	String message;
	
	public FailedAccountCreation(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "FailedAccountCreation [message=" + message + "]";
	}
}
