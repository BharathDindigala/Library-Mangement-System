package view;

import java.util.InputMismatchException;
import java.util.Scanner;

import controller.StaffController;
import model.Staff;

public class StaffMenu {
	StaffController staffController = new StaffController();

	public void staffMenu() {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("           Library Application");
			System.out.println("-".repeat(60));

			System.out.println("STAFF MENU");
			System.out.println("1. Add");
			System.out.println("2. View");
			System.out.println("3. Search");
			System.out.println("4. Update");
			System.out.println("5. Delete");
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
				Staff staff = new Staff();
				System.out.print("Enter Staff ID: ");
				staff.setStaffId(sc.nextInt());
				sc.nextLine(); // Consume newline

				System.out.print("Enter full name: ");
				staff.setFullName(sc.nextLine());

				System.out.print("Enter designation: ");
				staff.setDesignation(sc.nextLine());

				System.out.print("Enter mobile: ");
				staff.setMobile(sc.nextLong());
				sc.nextLine(); // Consume newline

				System.out.print("Enter email: ");
				staff.setEmail(sc.nextLine());

				System.out.print("Enter branch: ");
				staff.setBranch(sc.nextLine());

				System.out.print("Enter join date (yyyy-mm-dd): ");
				String joinDate = sc.nextLine();
				staff.setJoinDate(java.sql.Date.valueOf(joinDate));

				staffController.addStaff(staff);
			} else if (choice == 2) {
				staffController.viewStaff();
			} else if (choice == 3) {
				System.out.print("Enter Staff ID to search: ");
				int staffId = sc.nextInt();
				staffController.searchStaff(staffId);
			} else if (choice == 4) {
				System.out.print("Enter Staff ID to update: ");
				int staffId = sc.nextInt();
				sc.nextLine(); // Consume newline

				Staff staff = new Staff();
				staff.setStaffId(staffId);

				System.out.print("Enter new full name: ");
				staff.setFullName(sc.nextLine());

				System.out.print("Enter new designation: ");
				staff.setDesignation(sc.nextLine());

				System.out.print("Enter new mobile: ");
				staff.setMobile(sc.nextLong());
				sc.nextLine(); // Consume newline

				System.out.print("Enter new email: ");
				staff.setEmail(sc.nextLine());

				System.out.print("Enter new branch: ");
				staff.setBranch(sc.nextLine());

				System.out.print("Enter new join date (yyyy-mm-dd): ");
				String joinDate = sc.nextLine();
				staff.setJoinDate(java.sql.Date.valueOf(joinDate));

				staffController.updateStaff(staff);
			} else if (choice == 5) {
				System.out.print("Enter Staff ID to delete: ");
				int staffId = sc.nextInt();
				staffController.deleteStaff(staffId);
			} else if (choice == 6) {
				System.out.println("Exiting the Staff Menu...");
				sc.close(); // Close the scanner
				return; // Exit the method
			} else {
				System.out.println("Invalid choice! Please try again.");
			}
		}
	}
}
