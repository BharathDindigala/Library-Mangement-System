package controller;

import java.sql.*;
import model.Staff;

public class StaffController {

	// Method to add a staff record
	public void addStaff(Staff staff) {
		String query = "INSERT INTO staff (staff_id, full_name, designation, mobile, email, branch, join_date) VALUES (?, ?, ?, ?, ?, ?, ?)";
		try (Connection conn = DBUtils.DBConnection.getConnection();
				PreparedStatement pst = conn.prepareStatement(query)) {

			// Setting the parameters for the prepared statement
			pst.setInt(1, staff.getStaffId());
			pst.setString(2, staff.getFullName());
			pst.setString(3, staff.getDesignation());
			pst.setLong(4, staff.getMobile());
			pst.setString(5, staff.getEmail());
			pst.setString(6, staff.getBranch());
			pst.setDate(7, staff.getJoinDate());

			// Executing the update and checking the result
			int n = pst.executeUpdate();
			System.out.println(n == 0 ? "Staff record not added" : "Staff record added");
		} catch (SQLException e) {
			System.out.println("SQL Error in StaffController.addStaff(): " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error in StaffController.addStaff(): " + e);
		}
	}

	// Method to view all staff records
	public void viewStaff() {
		String query = "SELECT staff_id, full_name, designation, mobile, email, branch, join_date FROM staff";
		try (Connection conn = DBUtils.DBConnection.getConnection();
				PreparedStatement pst = conn.prepareStatement(query);
				ResultSet rs = pst.executeQuery()) {

			// Displaying the staff records
			System.out.println("\t\tStaff Records");
			System.out.println("-".repeat(60));
			System.out.println(
					"STAFF_ID   FULLNAME   DESIGNATION   MOBILE   EMAIL                          BRANCH   JOIN_DATE");
			System.out.println("=".repeat(120));

			// Iterating through the result set and printing each record
			while (rs.next()) {
				System.out.printf("\n%8d %-15s %-15s %12d %-30s %-8s %-12s", rs.getInt("staff_id"),
						rs.getString("full_name"), rs.getString("designation"), rs.getLong("mobile"),
						rs.getString("email"), rs.getString("branch"), rs.getDate("join_date"));
			}
		} catch (SQLException e) {
			System.out.println("SQL Error in StaffController.viewStaff(): " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error in StaffController.viewStaff(): " + e);
		}
	}

	// Method to search for a staff member by staff ID
	public void searchStaff(int staffId) {
		String query = "SELECT * FROM staff WHERE staff_id=?";
		try (Connection conn = DBUtils.DBConnection.getConnection();
				PreparedStatement pst = conn.prepareStatement(query)) {

			pst.setInt(1, staffId);
			ResultSet rs = pst.executeQuery();

			// Displaying the staff record
			System.out.println("\t\tStaff Record");
			System.out.println("-".repeat(60));
			System.out.println(
					"STAFF_ID   FULLNAME   DESIGNATION   MOBILE   EMAIL                          BRANCH   JOIN_DATE");
			System.out.println("=".repeat(120));

			if (rs.next()) {
				System.out.printf("\n%8d %-15s %-15s %12d %-30s %-8s %-12s", rs.getInt("staff_id"),
						rs.getString("full_name"), rs.getString("designation"), rs.getLong("mobile"),
						rs.getString("email"), rs.getString("branch"), rs.getDate("join_date"));
			} else {
				System.out.println("No staff member found with ID: " + staffId);
			}
		} catch (SQLException e) {
			System.out.println("SQL Error in StaffController.searchStaff(): " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error in StaffController.searchStaff(): " + e);
		}
	}

	// Method to update a staff record
	public void updateStaff(Staff staff) {
		String query = "UPDATE staff SET full_name=?, designation=?, mobile=?, email=?, branch=?, join_date=? WHERE staff_id=?";
		try (Connection conn = DBUtils.DBConnection.getConnection();
				PreparedStatement pst = conn.prepareStatement(query)) {

			pst.setString(1, staff.getFullName());
			pst.setString(2, staff.getDesignation());
			pst.setLong(3, staff.getMobile());
			pst.setString(4, staff.getEmail());
			pst.setString(5, staff.getBranch());
			pst.setDate(6, staff.getJoinDate());
			pst.setInt(7, staff.getStaffId());

			int rowsAffected = pst.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println("Staff member with ID " + staff.getStaffId() + " has been updated.");
			} else {
				System.out.println("No staff member found with ID: " + staff.getStaffId());
			}
		} catch (SQLException e) {
			System.out.println("SQL Error in StaffController.updateStaff(): " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error in StaffController.updateStaff(): " + e);
		}
	}

	// Method to delete a staff record
	public void deleteStaff(int staffId) {
		String query = "DELETE FROM staff WHERE staff_id=?";
		try (Connection conn = DBUtils.DBConnection.getConnection();
				PreparedStatement pst = conn.prepareStatement(query)) {

			pst.setInt(1, staffId);
			int rowsAffected = pst.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("Staff member with ID " + staffId + " has been deleted.");
			} else {
				System.out.println("No staff member found with ID: " + staffId);
			}
		} catch (SQLException e) {
			System.out.println("SQL Error in StaffController.deleteStaff(): " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error in StaffController.deleteStaff(): " + e);
		}
	}
}
