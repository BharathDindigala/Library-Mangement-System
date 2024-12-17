package view;

import java.util.Scanner;

import controller.AdminController;
import model.Admin;

public class AdminLogin {
	Scanner sc = new Scanner(System.in);
	AdminController adminController = new AdminController();

	public void adminLoginView() {
		System.out.println("              Library Application");
		System.out.println("-".repeat(60));
		System.out.println("\t\tAdmin Login");
		System.out.println("-".repeat(60));


		Admin admin = new Admin();
		System.out.println("\nEnter Userame:");
		admin.setUsername(sc.next());

		System.out.println("Enter Password:");
		admin.setPassword(sc.next());

		adminController.validateAdminLogin(admin);
	}
}
