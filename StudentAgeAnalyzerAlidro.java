package mypackage;
import java.util.Scanner;

public class StudentAgeAnalyzerAlidro {

    static String getAgeCategory(int age) {
        if (age >= 0 && age <= 12) {
            return "Child";
        } else if (age <= 19) {
            return "Teenager";
        } else if (age <= 59) {
            return "Adult";
        } else {
            return "Senior Citizen";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter age: ");
        int age = scanner.nextInt();

        String category = getAgeCategory(age);

        System.out.println("\nStudent Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Age Category: " + category);

        scanner.close();
    }
}