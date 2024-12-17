package controller;

import java.sql.*;
import model.Book;

public class BookController {

	// Method to add a book record
	public void addBook(Book book) {
		String query = "INSERT INTO book (book_id, category, title, author, publisher, publish_year, edition, description, cost, qty) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try (Connection conn = DBUtils.DBConnection.getConnection();
				PreparedStatement pst = conn.prepareStatement(query)) {

			// Setting the parameters for the prepared statement
			pst.setInt(1, book.getBookId());
			pst.setString(2, book.getCategory());
			pst.setString(3, book.getTitle());
			pst.setString(4, book.getAuthor());
			pst.setString(5, book.getPublisher());
			pst.setString(6, book.getPublishYear());
			pst.setInt(7, book.getEdition());
			pst.setString(8, book.getDescription());
			pst.setDouble(9, book.getCost());
			pst.setInt(10, book.getQty());

			// Executing the update and checking the result
			int n = pst.executeUpdate();
			System.out.println(n == 0 ? "Book record not added" : "Book record added");
		} catch (SQLException e) {
			System.out.println("SQL Error in BookController.addBook(): " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error in BookController.addBook(): " + e);
		}
	}

	// Method to view all book records
	public void viewBooks() {
		String query = "SELECT book_id, category, title, author, publisher, publish_year, edition, description, cost, qty FROM book";
		try (Connection conn = DBUtils.DBConnection.getConnection();
				PreparedStatement pst = conn.prepareStatement(query);
				ResultSet rs = pst.executeQuery()) {

			// Displaying the book records
			System.out.println("\t\tBook Records");
			System.out.println("-".repeat(60));
			System.out.println(
					"BOOK_ID   CATEGORY   TITLE   AUTHOR   PUBLISHER   PUBLISH_YEAR   EDITION   DESCRIPTION   COST   QTY");
			System.out.println("=".repeat(120));

			// Iterating through the result set and printing each record
			while (rs.next()) {
				System.out.printf("\n%8d %-15s %-15s %-12s %-12s %-12s %-8d %-20s %-6.2f %-6d", rs.getInt("book_id"),
						rs.getString("category"), rs.getString("title"), rs.getString("author"),
						rs.getString("publisher"), rs.getString("publish_year"), rs.getInt("edition"),
						rs.getString("description"), rs.getDouble("cost"), rs.getInt("qty"));
			}
		} catch (SQLException e) {
			System.out.println("SQL Error in BookController.viewBooks(): " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error in BookController.viewBooks(): " + e);
		}
	}

	// Method to search for a book by book ID
	public void searchBook(int bookId) {
		String query = "SELECT * FROM book WHERE book_id=?";
		try (Connection conn = DBUtils.DBConnection.getConnection();
				PreparedStatement pst = conn.prepareStatement(query)) {

			pst.setInt(1, bookId);
			ResultSet rs = pst.executeQuery();

			// Displaying the book record
			System.out.println("\t\tBook Record");
			System.out.println("-".repeat(60));
			System.out.println(
					"BOOK_ID   CATEGORY   TITLE   AUTHOR   PUBLISHER   PUBLISH_YEAR   EDITION   DESCRIPTION   COST   QTY");
			System.out.println("=".repeat(120));

			if (rs.next()) {
				System.out.printf("\n%8d %-15s %-15s %-12s %-12s %-12s %-8d %-20s %-6.2f %-6d", rs.getInt("book_id"),
						rs.getString("category"), rs.getString("title"), rs.getString("author"),
						rs.getString("publisher"), rs.getString("publish_year"), rs.getInt("edition"),
						rs.getString("description"), rs.getDouble("cost"), rs.getInt("qty"));
			} else {
				System.out.println("No book found with ID: " + bookId);
			}
		} catch (SQLException e) {
			System.out.println("SQL Error in BookController.searchBook(): " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error in BookController.searchBook(): " + e);
		}
	}

	// Method to update a book record
	public void updateBook(Book book) {
		String query = "UPDATE book SET category=?, title=?, author=?, publisher=?, publish_year=?, edition=?, description=?, cost=?, qty=? WHERE book_id=?";
		try (Connection conn = DBUtils.DBConnection.getConnection();
				PreparedStatement pst = conn.prepareStatement(query)) {

			pst.setString(1, book.getCategory());
			pst.setString(2, book.getTitle());
			pst.setString(3, book.getAuthor());
			pst.setString(4, book.getPublisher());
			pst.setString(5, book.getPublishYear());
			pst.setInt(6, book.getEdition());
			pst.setString(7, book.getDescription());
			pst.setDouble(8, book.getCost());
			pst.setInt(9, book.getQty());
			pst.setInt(10, book.getBookId());

			int rowsAffected = pst.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println("Book with ID " + book.getBookId() + " has been updated.");
			} else {
				System.out.println("No book found with ID: " + book.getBookId());
			}
		} catch (SQLException e) {
			System.out.println("SQL Error in BookController.updateBook(): " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error in BookController.updateBook(): " + e);
		}
	}

	// Method to delete a book record
	public void deleteBook(int bookId) {
		String query = "DELETE FROM book WHERE book_id=?";
		try (Connection conn = DBUtils.DBConnection.getConnection();
				PreparedStatement pst = conn.prepareStatement(query)) {

			pst.setInt(1, bookId);
			int rowsAffected = pst.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("Book with ID " + bookId + " has been deleted.");
			} else {
				System.out.println("No book found with ID: " + bookId);
			}
		} catch (SQLException e) {
			System.out.println("SQL Error in BookController.deleteBook(): " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error in BookController.deleteBook(): " + e);
		}
	}
}
