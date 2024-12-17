package view;

import java.sql.Date;
import java.util.Scanner;
import controller.Book_issueController;
import model.Book_issue;

public class Book_IssueMenu {
	Book_issueController issueController = new Book_issueController();

	public void issueMenu() {
		Scanner sc = new Scanner(System.in);

		do {
			// Display the menu options
			System.out.println("           Library Application");
			System.out.println("-".repeat(60));
			System.out.println("ISSUE MENU");
			System.out.println("1. Add Issue");
			System.out.println("2. View Issues");
			System.out.println("3. Search Issue");
			System.out.println("4. Update Issue");
			System.out.println("5. Delete Issue");
			System.out.println("6. Back");
			System.out.print("Enter choice: ");
			int choice = sc.nextInt();

			if (choice == 1) {
				// Add a new issue record
				Book_issue issue = new Book_issue();
				System.out.print("Enter issue ID: ");
				issue.setIssueId(sc.nextLong());

				System.out.print("Enter book number: ");
				issue.setBookNo(sc.nextLong());

				System.out.print("Enter roll number: ");
				issue.setRollNo(sc.nextLong());

				System.out.print("Enter staff ID: ");
				issue.setStaffId(sc.nextLong());

				// Validate and set issue date
				System.out.print("Enter issue date (YYYY-MM-DD): ");
				String issueDateStr = sc.next();
				try {
					issue.setIssueDate(Date.valueOf(issueDateStr));
				} catch (IllegalArgumentException e) {
					System.out.println("Invalid date format! Please enter a valid date in YYYY-MM-DD format.");
					continue; // Skip to the next iteration of the loop
				}

				// Validate and set return date (optional)
				System.out.print("Enter return date (YYYY-MM-DD) or leave empty: ");
				String returnDateStr = sc.next();
				if (!returnDateStr.isEmpty()) {
					try {
						issue.setReturnDate(Date.valueOf(returnDateStr));
					} catch (IllegalArgumentException e) {
						System.out
								.println("Invalid return date format! Please enter a valid date in YYYY-MM-DD format.");
						continue; // Skip to the next iteration of the loop
					}
				}

				System.out.print("Enter remarks: ");
				issue.setRemarks(sc.next());

				System.out.print("Enter fine: ");
				issue.setFine(sc.nextDouble());

				// Call the controller to save the new record
				issueController.addIssue(issue);

			} else if (choice == 2) {
				// View all issue records
				issueController.viewIssues();
			} else if (choice == 3) {
				// Search for an issue record
				System.out.print("Enter issue ID to search: ");
				long issueId = sc.nextLong();
				issueController.searchIssue(issueId);

			} else if (choice == 4) {
				// Update an issue record
				Book_issue issue = new Book_issue();
				System.out.print("Enter issue ID to update: ");
				issue.setIssueId(sc.nextLong());

				System.out.print("Enter new book number: ");
				issue.setBookNo(sc.nextLong());

				System.out.print("Enter new roll number: ");
				issue.setRollNo(sc.nextLong());

				System.out.print("Enter new staff ID: ");
				issue.setStaffId(sc.nextLong());

				// Validate and set new issue date
				System.out.print("Enter new issue date (YYYY-MM-DD): ");
				String issueDateStr = sc.next();
				try {
					issue.setIssueDate(Date.valueOf(issueDateStr));
				} catch (IllegalArgumentException e) {
					System.out.println("Invalid date format! Please enter a valid date in YYYY-MM-DD format.");
					continue; // Skip to the next iteration of the loop
				}

				// Validate and set new return date (optional)
				System.out.print("Enter new return date (YYYY-MM-DD) or leave empty: ");
				String returnDateStr = sc.next();
				if (!returnDateStr.isEmpty()) {
					try {
						issue.setReturnDate(Date.valueOf(returnDateStr));
					} catch (IllegalArgumentException e) {
						System.out
								.println("Invalid return date format! Please enter a valid date in YYYY-MM-DD format.");
						continue; // Skip to the next iteration of the loop
					}
				}

				System.out.print("Enter new remarks: ");
				issue.setRemarks(sc.next());

				System.out.print("Enter new fine: ");
				issue.setFine(sc.nextDouble());

				// Call the controller to update the record
				issueController.updateIssue(issue);

			} else if (choice == 5) {
				// Delete an issue record
				System.out.print("Enter issue ID to delete: ");
				long issueId = sc.nextLong();
				issueController.deleteIssue(issueId);

			} else if (choice == 6) {
				// Exit to the previous menu
				break;
			} else {
				System.out.println("Invalid choice. Please try again.");
			}
		} while (true);

		sc.close(); // Close the scanner resource
	}

}
