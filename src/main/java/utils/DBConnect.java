package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

	private static String url = "jdbc:mysql://localhost:3306/imex";
	private static String user = "root";
	private static String password = "Ravi400500lak@";
	private static Connection con;

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			System.out.println("Database Connection Failed !");
			e.printStackTrace();
		}

		return con;
	}

}
