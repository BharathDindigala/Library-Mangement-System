package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DBUtils.DBConnection;
import model.Admin;
import view.MainMenu;

public class AdminController {
	public void validateAdminLogin(Admin admin) {
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pst = conn.prepareStatement("select * from admin where username=? and password=?");
			pst.setString(1, admin.getUsername());
			pst.setString(2, admin.getPassword());
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				System.out.println("Login success....");
				MainMenu mainMenu = new MainMenu();
				mainMenu.mainMenu();
			} else {
				System.out.println("Invalid username/password");
			}

			pst.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("Error: Admin.adminValidate :" + e);
		}
	}

}
