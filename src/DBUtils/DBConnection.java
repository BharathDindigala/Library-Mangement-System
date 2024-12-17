package DBUtils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			// step 1: driver loading
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// step 2:connection to DB
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "apex", "apex12345");
			System.out.println("Connection ok.");

		} catch (Exception e) {
			System.out.println("Connection error:" + e);
		}
		return conn;
	}

}
