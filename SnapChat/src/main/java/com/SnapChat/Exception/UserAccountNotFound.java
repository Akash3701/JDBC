package com.SnapChat.Exception;

public class UserAccountNotFound extends Exception {
	String message;
	
	public UserAccountNotFound(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "UserAccountNotFound [message=" + message + "]";
	}
}
