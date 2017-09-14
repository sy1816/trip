package recommend;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

public class connectionDAO {

	public static Connection getConnection() {
		Connection conn = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "tour", "tiger");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
	
	public static Connection getConnection_oracle() {
		Connection conn = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://112.175.184.93";
			conn = DriverManager.getConnection(url, "tourforkorea", "tourtour123");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
	public static void main(String args[]) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		System.out.println("Before");
		try {
			conn = getConnection();
			System.out.println("Before - 2");
			
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery("select * from TOURSPOT");
			
			while(rs.next()) {
				System.out.println(rs.getInt(1));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
