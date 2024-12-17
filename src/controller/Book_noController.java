package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Book_noController {

	public void generateBookNumbers(int bookId, int quantity) {
		try (Connection conn = DBUtils.DBConnection.getConnection()) {
			// Find the maximum book_no for the given bookId
			PreparedStatement maxStmt = conn
					.prepareStatement("SELECT COALESCE(MAX(book_no), 0) FROM book_nos WHERE book_id = ?");
			maxStmt.setInt(1, bookId);
			ResultSet rs = maxStmt.executeQuery();

			int maxBookNo = 0;
			if (rs.next()) {
				maxBookNo = rs.getInt(1);
			}

			// Prepare insertion statement
			PreparedStatement pst = conn
					.prepareStatement("INSERT INTO book_nos(book_no, book_id, status, remarks) VALUES (?, ?, ?, ?)");

			for (int i = 1; i <= quantity; i++) {
				pst.setInt(1, maxBookNo + i); // Set book_no
				pst.setInt(2, bookId);
				pst.setString(3, "Available");
				pst.setString(4, "NewBook");
				pst.executeUpdate();
			}

			System.out.println("\nRecords Added");
			pst.close();
			maxStmt.close();
		} catch (Exception e) {
			System.out.println("Error: Book_noController.generateBookNumbers() " + e);
		}
	}

	public void searchBookNumbers(int bookId) {
		try (Connection conn = DBUtils.DBConnection.getConnection()) {
			PreparedStatement pst = conn
					.prepareStatement("SELECT book_no, status, remarks FROM book_nos WHERE book_id = ?");
			pst.setInt(1, bookId);
			ResultSet rs = pst.executeQuery();

			System.out.println("\t\tBook Records");
			System.out.println("-".repeat(60));
			System.out.println("BOOK_NO   STATUS   REMARKS");
			System.out.println("=".repeat(60));

			while (rs.next()) {
				System.out.printf("\n%-8d   %-20s   %-12s", rs.getInt("book_no"), rs.getString("status"),
						rs.getString("remarks"));
			}
			pst.close();
		} catch (Exception e) {
			System.out.println("Error: Book_noController.searchBookNumbers() " + e);
		}
	}

	public void updateBookStatus(String currentStatus, String newStatus) {
		try (Connection conn = DBUtils.DBConnection.getConnection()) {
			PreparedStatement pst = conn.prepareStatement("UPDATE book_nos SET status = ? WHERE status = ?");
			pst.setString(1, newStatus);
			pst.setString(2, currentStatus);

			int n = pst.executeUpdate();

			if (n == 0) {
				System.out.println("Books not found with status: " + currentStatus);
			} else {
				System.out.println("Status updated successfully");
			}
			pst.close();
		} catch (Exception e) {
			System.out.println("Error: Book_noController.updateBookStatus() " + e);
		}
	}
}
