package mypackage;
import java.util.Scanner;

public class ExpenseTrackerAlidro {

	public static void displayTitle() {
		System.out.println("---EXPENSE TRACKER---");
	}
	
	public static float totalExpenses(float food, float transpo, float others, float addon) {
		return food + transpo + others + addon;
	}
	
	public static void showBudget(float budget) {
		System.out.println("\nBudget: " + budget);
	}
	
	public static void personalizedMessage(float total, float food, float transpo, float others, float addon, float budget) {
		float remain = budget - total;
		
		System.out.println("\nFood: " + food);
		System.out.println("Transportation: " + transpo);
		System.out.println("Others: " + others);
		System.out.println("More: " + addon);
		System.out.println("--------------\r\n"
				+ "Total Expenses: " + total);
		System.out.println("\nYou have " + remain + " left\r\n"
				+ "SAVE UP!");
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int choice, c;
		float budget, total = 0, food = 0, transpo = 0, others = 0, addon = 0;

		displayTitle();
		do {
			System.out.println("Input Budget: ");
			budget = scanner.nextFloat();
			
			System.out.println("\nMenu\r\n"
					+ "1. Show Budget\r\n"
					+ "2. Add Expenses\r\n"
					+ "3. Exit\r\n"
					+ "Choice: ");
			choice = scanner.nextInt();
			
			switch (choice) {
			case 1:
				showBudget(budget);
				break;
			case 2:
				System.out.println("Food: ");
				food = scanner.nextFloat();
				System.out.println("Transportation: ");
				transpo = scanner.nextFloat();
				System.out.println("Other: ");
				others = scanner.nextFloat();
				do {
					System.out.println("\nAdd more category?\r\n"
							+ "1. Yes\r\n"
							+ "2. No\r\n"
							+ "Choice: ");
					c = scanner.nextInt();
				
					switch (c) {
					case 1:
						System.out.println("More: ");
						addon += scanner.nextFloat();
						total = totalExpenses(food, transpo, others, addon);
						break;
					case 2:
						total = totalExpenses(food, transpo, others, addon);
						break;
					default:
						System.out.println("Invalid Input. Try Again.");
					}
				} while (c != 2);
				break;
			default:
				System.out.println("Invalid Input. Try Again");
			}
		} while (choice != 3 && budget < 0);
		
		personalizedMessage(total, food, transpo, others, addon, budget);
		
	scanner.close();
	}
}
