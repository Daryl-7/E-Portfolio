package mypackage;
import java.util.Scanner;

public class SmartWalletSystemAlidro {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int balance = 5000, transaction = 1, choice, count = 1;
		
		do {
			System.out.println("===== SMART WALLET MENU =====");
			System.out.println("1. View Balance\r\n"
					+ "2. Cash In\r\n"
					+ "3. Send Money\r\n"
					+ "4. Exit");
			System.out.println("Transaction " + count++);
			System.out.println("Choice: ");
			choice = input.nextInt();
			
			switch (choice) {
				case 1:		//View Balance
					System.out.println("Balance: " + balance);
					transaction += 1;
					break;
				case 2:		//Cash in
					System.out.println("Cash In: ");
					balance += input.nextInt();
					System.out.println("New Balance: " + balance);
					transaction += 1;
					break;
				case 3:		//Send Money
					System.out.println("Send Money: ");
					int smoney = input.nextInt();
					if (smoney < 100) {
						System.out.println("Minimum of 100. Try again.");
					} else if (smoney > 1500) {
						System.out.println("Exceeds maximum limit");
					} else if (smoney > balance) {
						System.out.println("Insufficient Balance");
					} else {
						System.out.println("Sent successfully!");
						balance -= smoney;
						System.out.println("New Balance: " + balance);
						transaction += 1;
					}
					break;
				case 4:		//Exit and Total successful transactions
					System.out.println("Exiting.....\nTotal transactions: " + transaction);
					break;
				default:
					System.out.println("Invalid Input. Try again.");
			}
		} while (choice != 4);
		input.close();
	}
}
