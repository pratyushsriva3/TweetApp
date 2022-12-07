package ps.uta.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBProp {

	public static Connection provideConnection() {

		Connection conn = null;

		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String url = "jdbc:mysql://localhost:3306/tweet_app_db";

		try {
			conn = DriverManager.getConnection(url, "root", "root");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;

	}

}
