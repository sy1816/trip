package recommend;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

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
/*	
	public static Connection getConnection() {
		Connection conn = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:/@dbtourforkorea.cxnc2jzecful.ap-northeast-2.rds.amazonaws.com:1521:ORCL";
			conn = DriverManager.getConnection(url, "tourManager", "tourtour123");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	*/
	
	
	
	
	
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
