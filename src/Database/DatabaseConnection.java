package Database;

import java.sql.Connection;
import java.sql.DriverManager;


public class DatabaseConnection  {

	public Connection getConnection() throws Exception {

		try {

			String driver = "oracle.jdbc.driver.OracleDriver";
			String url = "jdbc:mysql://localhost:3306/flightreservation?autoReconnect=true&useSSL=false";
			String username = "root";
			String password = "24665123";
			Class.forName(driver);

			Connection conn = DriverManager.getConnection(url, username, password);
			System.out.println("Connection Successfull!");
			return conn;

		} catch (Exception e) {
			System.out.println("Connection Not Successfull");
		}
		return null;
	}
}