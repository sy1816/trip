package recommend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class recommendDAO {
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
	
	public static ArrayList<tourVO> recommendService(int gender,int  age,int  nation,int  job,int  with,int  purpose,int  month) {
		ArrayList<tourVO> tour = new ArrayList<tourVO>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			pstm = conn.prepareStatement("select * from QUOTIENT where NAME like ?");
			pstm.setString(1, "%" + "정읍" + "%");
			rs = pstm.executeQuery();
			rs.next();

			System.out.println(rs.getDouble("MONTH_1"));

		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return tour;
	}
	
	public static void main(String args[]) {

	}

}
