package recommend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class searchDAO extends connectionDAO{
	public static ArrayList<searchVO> searchList(){
		ArrayList<searchVO> search_list = new ArrayList<searchVO>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			pstm = conn.prepareStatement("select * from TOURSPOT order by V_RANK");
			rs = pstm.executeQuery();
			
			for(int i=0; i<135; i++) {
				rs.next();
				search_list.add(new searchVO(rs.getInt("ID"), rs.getInt("V_RANK"), rs.getString("NAME"), rs.getString("AREA"), rs.getString("ADDRESS")));
			}
			
			return search_list;
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return search_list;
	}
	
}
