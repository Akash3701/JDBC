package com.SnapChat.view;

import java.util.Scanner;
import com.SnapChat.Controller.SnapChatController;
import com.SnapChat.Controller.SnapChatControllerInterface;

public class SnapChatView {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SnapChatControllerInterface sci = new SnapChatController();
        boolean continueProgram = true;

        while (continueProgram) {
            System.out.println("----------Main Menu----------");
            System.out.println("Press 1 to Create Account");
            System.out.println("Press 2 to View Account");
            System.out.println("Press 3 to View All Accounts");
            System.out.println("Press 4 to Edit Account");
            System.out.println("Press 5 to Delete Account");
            System.out.println("Press 6 to Login Account");
            System.out.println("Enter your choice: ");
            
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    sci.createAccount();
                    break;
                case 2:
                    sci.viewAccount();
                    break;
                case 3:
                    sci.viewAllAccount();
                    break;
                case 4:
                    sci.editAccount();
                    break;
                case 5:
                    sci.deleteAccount();
                    break;
                case 6:
                    sci.LoginAccount();
                    break;
                default:
                    System.out.println("Invalid Input!!");
            }

            System.out.println("Do you want to continue? (yes/no): ");
            String continueInput = sc.nextLine().trim().toLowerCase();
            continueProgram = continueInput.equals("yes");
        }

        sc.close();
    }
}
