package view;

import java.util.InputMismatchException;
import java.util.Scanner;
import controller.StudentController;
import model.Student;

public class StudentMenu {
	StudentController studentController = new StudentController();

	public void studentMenu() {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("           Library Application");
			System.out.println("-".repeat(60));

			System.out.println("STUDENT MENU");
			System.out.println("1. Add");
			System.out.println("2. View");
			System.out.println("3. Search");
			System.out.println("4. Delete");
			System.out.println("5. Update");
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

			switch (choice) {
			case 1: {
				Student student = new Student();
				System.out.print("Enter rollno: ");
				student.setRollno(sc.nextInt());
				sc.nextLine(); // Consume newline

				System.out.print("Enter full name: ");
				student.setFullName(sc.nextLine());

				System.out.print("Enter address: ");
				student.setAddress(sc.nextLine());

				System.out.print("Enter mobile: ");
				student.setMobile(sc.nextLong());
				sc.nextLine(); // Consume newline

				System.out.print("Enter email: ");
				student.setEmail(sc.nextLine());

				System.out.print("Enter branch: ");
				student.setBranch(sc.nextLine());

				System.out.print("Enter academic year: ");
				student.setAcademicYear(sc.nextLine());

				studentController.addStudent(student);
				break;
			}
			case 2:
				studentController.viewStudents();
				break;
			case 3: {
				System.out.print("Enter roll number to search: ");
				int rollno = sc.nextInt();
				studentController.searchStudent(rollno);
				break;
			}
			case 4: {
				System.out.print("Enter roll number to delete: ");
				int rollno = sc.nextInt();
				studentController.deleteStudent(rollno);
				break;
			}
			case 5: {
				System.out.print("Enter roll number to update: ");
				int rollno = sc.nextInt();
				sc.nextLine(); // Consume newline

				// Creating a new student object for updating
				Student student = new Student();
				student.setRollno(rollno);

				System.out.print("Enter new full name: ");
				student.setFullName(sc.nextLine());

				System.out.print("Enter new address: ");
				student.setAddress(sc.nextLine());

				System.out.print("Enter new mobile: ");
				student.setMobile(sc.nextLong());
				sc.nextLine(); // Consume newline

				System.out.print("Enter new email: ");
				student.setEmail(sc.nextLine());

				System.out.print("Enter new branch: ");
				student.setBranch(sc.nextLine());

				System.out.print("Enter new academic year: ");
				student.setAcademicYear(sc.nextLine());

				studentController.updateStudent(student);
				break;
			}
			case 6:
				System.out.println("Exiting the Student Menu...");
				sc.close(); // Close the scanner
				return; // Exit the method
			default:
				System.out.println("Invalid choice! Please try again.");
			}
		}
	}
}
