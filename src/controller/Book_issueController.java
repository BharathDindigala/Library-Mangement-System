package controller;

import java.sql.*;

import model.Book_issue;

public class Book_issueController {
	// Method to add a new issue record
	public void addIssue(Book_issue issue) {
		String query = "INSERT INTO book_issue (issue_id, book_no, rollno, staff_id, issue_date, return_date, remarks, fine) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try (Connection conn = DBUtils.DBConnection.getConnection();
				PreparedStatement pst = conn.prepareStatement(query)) {

			// Set the parameters for the query
			pst.setLong(1, issue.getIssueId());
			pst.setLong(2, issue.getBookNo());
			pst.setLong(3, issue.getRollNo());
			pst.setLong(4, issue.getStaffId());
			pst.setDate(5, new java.sql.Date(issue.getIssueDate().getTime()));
			pst.setDate(6, issue.getReturnDate() != null ? new java.sql.Date(issue.getReturnDate().getTime()) : null);
			pst.setString(7, issue.getRemarks());
			pst.setDouble(8, issue.getFine());

			// Execute the query and display results
			int result = pst.executeUpdate();
			System.out.println(result > 0 ? "Issue record added successfully." : "Failed to add issue record.");
		} catch (SQLException e) {
			System.out.println("SQL Error in BookIssueController.addIssue(): " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error in BookIssueController.addIssue(): " + e);
		}
	}

	// Method to view all issue records
	public void viewIssues() {
		String query = "SELECT issue_id, book_no, rollno, staff_id, issue_date, return_date, remarks, fine FROM book_issue";
		try (Connection conn = DBUtils.DBConnection.getConnection();
				PreparedStatement pst = conn.prepareStatement(query);
				ResultSet rs = pst.executeQuery()) {

			// Display the results in a table format
			System.out.println("\t\tIssue Records");
			System.out.println("-".repeat(60));
			System.out.println("ISSUE_ID   BOOK_NO   ROLLNO   STAFF_ID   ISSUE_DATE   RETURN_DATE   REMARKS   FINE");
			System.out.println("=".repeat(100));

			// Iterate through each record and print the details
			while (rs.next()) {
				System.out.printf("%-10d %-10d %-10d %-10d %-12s %-12s %-10s %-10.2f\n", rs.getLong("issue_id"),
						rs.getLong("book_no"), rs.getLong("rollno"), rs.getLong("staff_id"), rs.getDate("issue_date"),
						rs.getDate("return_date"), rs.getString("remarks"), rs.getDouble("fine"));
			}
		} catch (SQLException e) {
			System.out.println("SQL Error in BookIssueController.viewIssues(): " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error in BookIssueController.viewIssues(): " + e);
		}
	}

	// Method to search for an issue record by issue ID
	public void searchIssue(long issueId) {
		String query = "SELECT * FROM book_issue WHERE issue_id=?";
		try (Connection conn = DBUtils.DBConnection.getConnection();
				PreparedStatement pst = conn.prepareStatement(query)) {

			pst.setLong(1, issueId);
			ResultSet rs = pst.executeQuery();

			// Display the issue record
			System.out.println("\t\tIssue Record");
			System.out.println("-".repeat(60));
			System.out.println("ISSUE_ID   BOOK_NO   ROLLNO   STAFF_ID   ISSUE_DATE   RETURN_DATE   REMARKS   FINE");
			System.out.println("=".repeat(100));

			if (rs.next()) {
				System.out.printf("%-10d %-10d %-10d %-10d %-12s %-12s %-10s %-10.2f\n", rs.getLong("issue_id"),
						rs.getLong("book_no"), rs.getLong("rollno"), rs.getLong("staff_id"), rs.getDate("issue_date"),
						rs.getDate("return_date"), rs.getString("remarks"), rs.getDouble("fine"));
			} else {
				System.out.println("No issue record found with ID: " + issueId);
			}
		} catch (SQLException e) {
			System.out.println("SQL Error in BookIssueController.searchIssue(): " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error in BookIssueController.searchIssue(): " + e);
		}
	}

	// Method to update an issue record
	public void updateIssue(Book_issue issue) {
		String query = "UPDATE book_issue SET book_no=?, rollno=?, staff_id=?, issue_date=?, return_date=?, remarks=?, fine=? WHERE issue_id=?";
		try (Connection conn = DBUtils.DBConnection.getConnection();
				PreparedStatement pst = conn.prepareStatement(query)) {

			pst.setLong(1, issue.getBookNo());
			pst.setLong(2, issue.getRollNo());
			pst.setLong(3, issue.getStaffId());
			pst.setDate(4, new java.sql.Date(issue.getIssueDate().getTime()));
			pst.setDate(5, issue.getReturnDate() != null ? new java.sql.Date(issue.getReturnDate().getTime()) : null);
			pst.setString(6, issue.getRemarks());
			pst.setDouble(7, issue.getFine());
			pst.setLong(8, issue.getIssueId());

			int rowsAffected = pst.executeUpdate();
			System.out.println(rowsAffected > 0 ? "Issue record updated successfully."
					: "No issue record found with ID: " + issue.getIssueId());
		} catch (SQLException e) {
			System.out.println("SQL Error in BookIssueController.updateIssue(): " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error in BookIssueController.updateIssue(): " + e);
		}
	}

	// Method to delete an issue record
	public void deleteIssue(long issueId) {
		String query = "DELETE FROM book_issue WHERE issue_id=?";
		try (Connection conn = DBUtils.DBConnection.getConnection();
				PreparedStatement pst = conn.prepareStatement(query)) {

			pst.setLong(1, issueId);
			int rowsAffected = pst.executeUpdate();

			System.out.println(rowsAffected > 0 ? "Issue record deleted successfully."
					: "No issue record found with ID: " + issueId);
		} catch (SQLException e) {
			System.out.println("SQL Error in BookIssueController.deleteIssue(): " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error in BookIssueController.deleteIssue(): " + e);
		}
	}

}
