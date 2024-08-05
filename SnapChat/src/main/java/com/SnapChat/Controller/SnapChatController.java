package com.SnapChat.Controller;

import java.util.List;
import java.util.Scanner;
import com.SnapChat.Entity.SnapChatEntity;
import com.SnapChat.Exception.FailedAccountCreation;
import com.SnapChat.Exception.UserAccountNotFound;
import com.SnapChat.Service.SnapChatService;
import com.SnapChat.Service.SnapChatServiceInterface;

public class SnapChatController implements SnapChatControllerInterface {

	@Override
	public void createAccount() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the username: ");
		String username = sc.nextLine();

		System.out.println("Enter the email id: ");
		String email = sc.next();

		System.out.println("Enter the phone number: ");
		int phoneno = sc.nextInt();

		System.out.println("Enter the password: ");
		String password = sc.next();

		SnapChatEntity se = new SnapChatEntity(username, email, phoneno, password);

		SnapChatServiceInterface ssi = new SnapChatService();
		int i = ssi.createAccount(se);

		try {
			if (i > 0) {
				System.out.println("Account created successfully");
			} else {
				throw new FailedAccountCreation("Account creation failed!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void viewAccount() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the email id: ");
		String email = sc.next();

		SnapChatEntity se = new SnapChatEntity();
		se.setEmail(email);

		SnapChatServiceInterface ssi = new SnapChatService();
		SnapChatEntity user = ssi.viewAccount(se);

		try {
			if (user != null) {
				System.out.println(user.getUsername());
				System.out.println(user.getEmail());
				System.out.println(user.getPhoneno());
			} else {
				throw new UserAccountNotFound("Account not found!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void viewAllAccount() {
		SnapChatServiceInterface ssi = new SnapChatService();
		List<SnapChatEntity> users = ssi.viewAllAccount();

		for (SnapChatEntity u : users) {
			System.out.println("-------User Details-------");
			System.out.println("Username: " + u.getUsername());
			System.out.println("Email: " + u.getEmail());
			System.out.println("Phone Number: " + u.getPhoneno());
		}
	}

	@Override
	public void editAccount() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the email id to edit the content: ");
		String email = sc.next();

		SnapChatEntity se = new SnapChatEntity();
		se.setEmail(email);

		SnapChatServiceInterface ssi = new SnapChatService();
		SnapChatEntity user = ssi.viewAccount(se);

		if (user != null) {
			System.out.println("Enter the phone number: ");
			int phoneno = sc.nextInt();
			System.out.println("Enter the password: ");
			String password = sc.next();

			user.setPhoneno(phoneno);
			user.setPassword(password);

			int i = ssi.editAccount(user);

			try {
				if (i > 0) {
					System.out.println("Account updated successfully");
				} else {
					throw new UserAccountNotFound("Failed to update");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try {
				throw new UserAccountNotFound("User not found");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void deleteAccount() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the email to delete the account: ");
		String email = sc.next();

		SnapChatEntity se = new SnapChatEntity();
		se.setEmail(email);

		SnapChatServiceInterface ssi = new SnapChatService();
		int i = ssi.deleteAccount(se);

		try {
			if (i > 0) {
				System.out.println("Account Deleted successfully");
			} else {
				throw new UserAccountNotFound("Failed to delete");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void LoginAccount() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the email id: ");
		String email = sc.next();

		System.out.println("Enter the password: ");
		String password = sc.next();

		SnapChatEntity se = new SnapChatEntity();
		se.setEmail(email);
		se.setPassword(password);

		SnapChatServiceInterface ssi = new SnapChatService();
		boolean isValidUser = ssi.loginAccount(se);

		if (isValidUser) {
			System.out.println("Login Successful!!");
		} else {
			System.out.println("Failed to login...");
		}
	}

	@Override
	public void searchAccount() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the email or username to search: ");
		String searchQuery = sc.nextLine();

		SnapChatServiceInterface ssi = new SnapChatService();
		List<SnapChatEntity> users = ssi.searchAccount(searchQuery);

		if (users.isEmpty()) {
			System.out.println("No accounts found matching the search criteria.");
		} else {
			for (SnapChatEntity user : users) {
				System.out.println("-------User Details-------");
				System.out.println("Username: " + user.getUsername());
				System.out.println("Email: " + user.getEmail());
				System.out.println("Phone Number: " + user.getPhoneno());
			}
		}

	}
}
