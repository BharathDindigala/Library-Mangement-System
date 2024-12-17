package view;

import java.util.Scanner;
import controller.Book_noController;

public class BookNosMenu {
	Book_noController bookNoController = new Book_noController();
	Scanner sc = new Scanner(System.in);

	public void bookNosMenu() {
		do {
			System.out.println("      Library Application");
			System.out.println("-".repeat(60));
			System.out.println("      BOOK_NOS MENU");
			System.out.println("-".repeat(60));
			System.out.println("1. Generate book numbers");
			System.out.println("2. Search book numbers");
			System.out.println("3. Update Status");
			System.out.println("4. Back");
			System.out.println("Enter your choice");
			int choice = sc.nextInt();

			if (choice == 1) {
				System.out.println("Enter Book Id:");
				int bookId = sc.nextInt();

				System.out.println("Enter Quantity:");
				int quantity = sc.nextInt();
				bookNoController.generateBookNumbers(bookId, quantity);
			} else if (choice == 2) {
				System.out.println("Enter Book Id:");
				int bookId = sc.nextInt();
				bookNoController.searchBookNumbers(bookId);
			} else if (choice == 3) {
				System.out.println("Enter Current Book Status:");
				String currentStatus = sc.next();

				System.out.println("Enter New Book Status:");
				String newStatus = sc.next();

				bookNoController.updateBookStatus(currentStatus, newStatus);
			} else if (choice == 4) {
				break; // Exit the loop and return to the main menu
			}

		} while (true); // Loop until the user chooses to exit
	}
}
