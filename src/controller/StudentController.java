package controller;

import java.sql.*;
import model.Student;

public class StudentController {
	public void addStudent(Student student) {
		String query = "INSERT INTO student (rollno, full_name, address, mobile, email, branch, academic_year) VALUES (?, ?, ?, ?, ?, ?, ?)";
		try (Connection conn = DBUtils.DBConnection.getConnection();
				PreparedStatement pst = conn.prepareStatement(query)) {

			pst.setInt(1, student.getRollno());
			pst.setString(2, student.getFullName());
			pst.setString(3, student.getAddress());
			pst.setLong(4, student.getMobile());
			pst.setString(5, student.getEmail());
			pst.setString(6, student.getBranch());
			pst.setString(7, student.getAcademicYear());

			int n = pst.executeUpdate();
			System.out.println(n == 0 ? "Student record not added" : "Student record added");
		} catch (SQLException e) {
			System.out.println("SQL Error in StudentController.addStudent(): " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error in StudentController.addStudent(): " + e);
		}
	}

	public void viewStudents() {
		String query = "SELECT rollno, full_name, address, mobile, email, branch, academic_year FROM student";
		try (Connection conn = DBUtils.DBConnection.getConnection();
				PreparedStatement pst = conn.prepareStatement(query);
				ResultSet rs = pst.executeQuery()) {

			System.out.println("\t\tStudent Records");
			System.out.println("-".repeat(60));
			System.out.println(
					"ROLLNO   FULLNAME   ADDRESS           MOBILE      EMAIL                          BRANCH   ACADEMIC_YR");
			System.out.println("=".repeat(120));

			while (rs.next()) {
				System.out.printf("\n%6d %-15s %-20s %12d %-30s %-8s %-8s", rs.getInt("rollno"),
						rs.getString("full_name"), rs.getString("address"), rs.getLong("mobile"), rs.getString("email"),
						rs.getString("branch"), rs.getString("academic_year"));
			}
		} catch (SQLException e) {
			System.out.println("SQL Error in StudentController.viewStudents(): " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error in StudentController.viewStudents(): " + e);
		}
	}

	public void searchStudent(int rollno) {
		String query = "SELECT * FROM student WHERE rollno=?";
		try (Connection conn = DBUtils.DBConnection.getConnection();
				PreparedStatement pst = conn.prepareStatement(query)) {

			pst.setInt(1, rollno);
			ResultSet rs = pst.executeQuery();

			System.out.println("\t\tStudent Records");
			System.out.println("-".repeat(60));
			System.out.println(
					"ROLLNO   FULLNAME   ADDRESS           MOBILE      EMAIL                          BRANCH   ACADEMIC_YR");
			System.out.println("=".repeat(120));

			if (rs.next()) {
				System.out.printf("\n%6d %-15s %-20s %12d %-30s %-8s %-8s", rs.getInt("rollno"),
						rs.getString("full_name"), rs.getString("address"), rs.getLong("mobile"), rs.getString("email"),
						rs.getString("branch"), rs.getString("academic_year"));
			} else {
				System.out.println("No student found with roll number: " + rollno);
			}
		} catch (SQLException e) {
			System.out.println("SQL Error in StudentController.searchStudent(): " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error in StudentController.searchStudent(): " + e);
		}
	}

	public void deleteStudent(int rollno) {
		String query = "DELETE FROM student WHERE rollno=?";
		try (Connection conn = DBUtils.DBConnection.getConnection();
				PreparedStatement pst = conn.prepareStatement(query)) {

			pst.setInt(1, rollno);
			int rowsAffected = pst.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("Student with roll number " + rollno + " has been deleted.");
			} else {
				System.out.println("No student found with roll number: " + rollno);
			}
		} catch (SQLException e) {
			System.out.println("SQL Error in StudentController.deleteStudent(): " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error in StudentController.deleteStudent(): " + e);
		}
	}

	public void updateStudent(Student student) {
		String query = "UPDATE student SET full_name=?, address=?, mobile=?, email=?, branch=?, academic_year=? WHERE rollno=?";
		try (Connection conn = DBUtils.DBConnection.getConnection();
				PreparedStatement pst = conn.prepareStatement(query)) {

			pst.setString(1, student.getFullName());
			pst.setString(2, student.getAddress());
			pst.setLong(3, student.getMobile());
			pst.setString(4, student.getEmail());
			pst.setString(5, student.getBranch());
			pst.setString(6, student.getAcademicYear());
			pst.setInt(7, student.getRollno());

			int rowsAffected = pst.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println("Student with roll number " + student.getRollno() + " has been updated.");
			} else {
				System.out.println("No student found with roll number: " + student.getRollno());
			}
		} catch (SQLException e) {
			System.out.println("SQL Error in StudentController.updateStudent(): " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error in StudentController.updateStudent(): " + e);
		}
	}
}
