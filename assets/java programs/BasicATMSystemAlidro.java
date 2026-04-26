package mypackage;
import java.util.Scanner;

public class BasicATMSystemAlidro {
	static Scanner input = new Scanner(System.in);
	
	public static void displayMenu() {
		System.out.println("===== ATM MENU =====\r\n"
				+ "1. Check Balance\r\n"
				+ "2. Deposit\r\n"
				+ "3. Withdraw\r\n"
				+ "4. Exit\r\n");
	}
	
	public static void checkBalance(float balance) {
		System.out.println("Balance: " + balance + "\n");
	}
	
	public static float deposit(float balance) {
		float deposit = 0;
		
		do {
			System.out.println("Input deposit amount: ");
			deposit = input.nextFloat();
			if (deposit < 0) {
				System.out.println("Invalid Amount. Try Again");
			} else {
				System.out.println("Processing...\r\n"
						+ "Done!\n");
				break;
			}
		} while (deposit < 0);
		
		return balance += deposit;
	}
	
	public static float withdraw(float balance) {
		float withdraw = 0;
		
		do {
			System.out.println("Input withdraw amount: ");
			withdraw = input.nextFloat();
			if (withdraw < 0) {
				System.out.println("Invalid Amount. Try Again");
			} else if (withdraw > balance) {
				System.out.println("Insufficient Balance. Try Again");
			} else if (withdraw > 2000) {
				System.out.println("Maximum withdrawal is ₱2000 only.\r\n"
						+ "Try Again.");
			} else {
				System.out.println("Processing...\r\n"
						+ "Done!\n");
				break;
			}
		} while (withdraw < 0 || withdraw > balance || withdraw > 2000);
		
		return balance -= withdraw;
	}
	
	public static void main(String[] args) {
		int choice;
		float balance = 5000;
		
		do {
			displayMenu();
			System.out.println("Choice: ");
			choice = input.nextInt();
			
			switch (choice) {
			case 1:
				checkBalance(balance);
				break;
			case 2:
				balance = deposit(balance);
				break;
			case 3:
				balance = withdraw(balance);
				break;
			case 4:
				System.out.println("Exiting....\r\n"
						+ "Thank you!");
				break;
			default:
				System.out.println("Invalid Input. Try Again.\n");
			}
		} while (choice != 4);
	}
}
