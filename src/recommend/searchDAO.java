package recommend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class searchDAO extends connectionDAO {
	public static searchVO tourSpotInfo(String data){
		searchVO tourspot_VO = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			pstm = conn.prepareStatement("select * from TOURSPOT where id = ?");
			pstm.setString(1, data);
			rs = pstm.executeQuery();
			rs.next();
			
			tourspot_VO = new searchVO(rs.getInt("ID"), rs.getInt("V_RANK"), rs.getString("NAME"),
					rs.getString("AREA"), rs.getString("ADDRESS"), rs.getString("IMG_1"), rs.getString("IMG_2"));
			
			if(rs.getString("ASSOCIATE_1") != null) {
				tourspot_VO.setAssociate_1(Integer.parseInt(rs.getString("ASSOCIATE_1")));
			}
			if(rs.getString("ASSOCIATE_2") != null) {
				tourspot_VO.setAssociate_2(Integer.parseInt(rs.getString("ASSOCIATE_2")));
			}
			if(rs.getString("ASSOCIATE_3") != null) {
				tourspot_VO.setAssociate_3(Integer.parseInt(rs.getString("ASSOCIATE_3")));
			}
			if(rs.getString("ASSOCIATE_4") != null) {
				tourspot_VO.setAssociate_4(Integer.parseInt(rs.getString("ASSOCIATE_4")));
			}
			if(rs.getString("ASSOCIATE_5") != null) {
				tourspot_VO.setAssociate_5(Integer.parseInt(rs.getString("ASSOCIATE_5")));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstm.close();
				rs.close();
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return tourspot_VO;
	}
	
	public static ArrayList<searchVO> searchList(String search_type) {
		
		
		ArrayList<searchVO> search_list = new ArrayList<searchVO>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		int data_num = 135;

		try {
			conn = getConnection();
			pstm = conn.prepareStatement("select * from TOURSPOT order by V_RANK");
			if(search_type.equals("1")) {
				data_num = 10;
			}
			rs = pstm.executeQuery();

			for (int i = 0; i < data_num; i++) {
				rs.next();
				search_list.add(new searchVO(rs.getInt("ID"), rs.getInt("V_RANK"), rs.getString("NAME"),
						rs.getString("AREA"), rs.getString("ADDRESS"), rs.getString("IMG_1"), rs.getString("IMG_2")));
			}

			return search_list;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return search_list;
	}
/*
	public static void main(String args[]) {

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			pstm = conn.prepareStatement("select * from TOURSPOT order by V_RANK");
			rs = pstm.executeQuery();

			for (int i = 0; i < 40; i++) {
				rs.next();
				System.out.println(rs.getString("NAME") + " : " + rs.getString("ASSOCIATE_5"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	*/
	
}
