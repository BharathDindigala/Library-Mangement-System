package view;

import java.util.InputMismatchException;
import java.util.Scanner;

import controller.BookController;
import model.Book;

public class BookMenu {
	BookController bookController = new BookController();
	Scanner sc = new Scanner(System.in);

	public void bookMenu() {
		while (true) {
			System.out.println("           Library Application");
			System.out.println("-".repeat(60));

			System.out.println("BOOK MENU");
			System.out.println("1. Add Book");
			System.out.println("2. View Books");
			System.out.println("3. Search Book");
			System.out.println("4. Update Book");
			System.out.println("5. Delete Book");
			System.out.println("6. Back");
			System.out.print("Enter choice: ");

			int choice;
			try {
				choice = sc.nextInt();
				sc.nextLine(); // Consume newline
			} catch (InputMismatchException e) {
				System.out.println("Invalid input! Please enter a number.");
				sc.nextLine(); // Clear the invalid input
				continue; // Go back to the start of the loop
			}

			if (choice == 1) {
				Book book = collectBookDetails();
				bookController.addBook(book);
			} else if (choice == 2) {
				bookController.viewBooks();
			} else if (choice == 3) {
				System.out.print("Enter Book ID to search: ");
				int bookId = sc.nextInt();
				bookController.searchBook(bookId);
			} else if (choice == 4) {
				System.out.print("Enter Book ID to update: ");
				int updateBookId = sc.nextInt();
				Book updatedBook = collectBookDetails();
				updatedBook.setBookId(updateBookId);
				bookController.updateBook(updatedBook);
			} else if (choice == 5) {
				System.out.print("Enter Book ID to delete: ");
				int deleteBookId = sc.nextInt();
				bookController.deleteBook(deleteBookId);
			} else if (choice == 6) {
				System.out.println("Exiting the Book Menu...");
				sc.close(); // Close the scanner
				return; // Exit the method
			} else {
				System.out.println("Invalid choice! Please try again.");
			}
		}
	}

	private Book collectBookDetails() {
		Book book = new Book();

		System.out.print("Enter Book ID: ");
		book.setBookId(sc.nextInt());
		sc.nextLine(); // Consume newline

		System.out.print("Enter Category: ");
		book.setCategory(sc.nextLine());

		System.out.print("Enter Title: ");
		book.setTitle(sc.nextLine());

		System.out.print("Enter Author: ");
		book.setAuthor(sc.nextLine());

		System.out.print("Enter Publisher: ");
		book.setPublisher(sc.nextLine());

		System.out.print("Enter Publish Year: ");
		book.setPublishYear(sc.nextLine());

		System.out.print("Enter Edition: ");
		book.setEdition(sc.nextInt());
		sc.nextLine(); // Consume newline

		System.out.print("Enter Description: ");
		book.setDescription(sc.nextLine());

		System.out.print("Enter Cost: ");
		book.setCost(sc.nextDouble());

		System.out.print("Enter Quantity: ");
		book.setQty(sc.nextInt());
		sc.nextLine(); // Consume newline

		return book;
	}
}
