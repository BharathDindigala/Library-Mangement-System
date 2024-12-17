package view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu {
	public void mainMenu() {
		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("           Library Application");
			System.out.println("-".repeat(60));

			System.out.println("MAIN MENU");
			System.out.println("1. Student");
			System.out.println("2. Staff");
			System.out.println("3. Book");
			System.out.println("4. Book Numbers");
			System.out.println("5. Book Issue");
			System.out.println("6. Return");
			System.out.println("7. Reports");
			System.out.println("8. Exit");
			System.out.print("Enter choice: ");

			int choice;
			try {
				choice = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Invalid input! Please enter a number.");
				sc.nextLine(); // Clear the invalid input
				continue; // Go back to the start of the loop
			}

			if (choice == 1) {
				StudentMenu studentMenu = new StudentMenu();
				studentMenu.studentMenu(); // Call the student menu
			} else if (choice == 2) {
				StaffMenu staffMenu = new StaffMenu(); // Call the staff menu
				staffMenu.staffMenu();
			} else if (choice == 3) {
				BookMenu bookMenu = new BookMenu(); // Call the book menu
				bookMenu.bookMenu();
			} else if (choice == 4) {
				BookNosMenu bookNosMenu = new BookNosMenu(); // Call the book numbers menu
				bookNosMenu.bookNosMenu();
			} else if (choice == 5) {
				Book_IssueMenu bookIssueMenu = new Book_IssueMenu(); // Call the book issue menu
				bookIssueMenu.issueMenu(); // Correct method name here
			} else if (choice == 6) {
				// Handle return functionality here if needed
			} else if (choice == 7) {
				System.out.println("Generating reports... (This feature is not yet implemented.)");
			} else if (choice == 8) {
				System.out.println("Exiting the application.");
				sc.close(); // Close the scanner to prevent resource leaks
				return; // Exit the loop and terminate the program
			} else {
				System.out.println("Invalid choice. Please enter a valid option.");
			}
		} while (true);
	}
}
