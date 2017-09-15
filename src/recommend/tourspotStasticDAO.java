package recommend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class tourspotStasticDAO extends connectionDAO {
	public tourspotStasticVO tourSpotStastic(String id) {
		tourspotStasticVO tour = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			pstm = conn.prepareStatement("select * from STASTIC where id = ?");
			pstm.setString(1, id);
			rs = pstm.executeQuery();
			rs.next();
			
			tour = new tourspotStasticVO();
			tour.setId(rs.getInt("ID"));
			tour.setName(rs.getString("NAME"));
			tour.setGender_c(new int[] {rs.getInt("GENDER_1"),rs.getInt("GENDER_2")});
			tour.setMonth_c(new int[] {rs.getInt("MONTH_1"), rs.getInt("MONTH_2"), rs.getInt("MONTH_3"), rs.getInt("MONTH_4"), 
					rs.getInt("MONTH_5"), rs.getInt("MONTH_6"), rs.getInt("MONTH_7"), rs.getInt("MONTH_8"), 
					rs.getInt("MONTH_9"), rs.getInt("MONTH_10"), rs.getInt("MONTH_11"), rs.getInt("MONTH_12") 
			});
			tour.setNation_c(new int[] {rs.getInt("NATION_1"), rs.getInt("NATION_2"), rs.getInt("NATION_3"), rs.getInt("NATION_4"), 
					rs.getInt("NATION_5"), rs.getInt("NATION_6"), rs.getInt("NATION_7"), rs.getInt("NATION_8"), 
					rs.getInt("NATION_9"), rs.getInt("NATION_10"), rs.getInt("NATION_11"), rs.getInt("NATION_12"), 
					rs.getInt("NATION_13"), rs.getInt("NATION_14"), rs.getInt("NATION_15"), rs.getInt("NATION_16") 
			});
			tour.setPurpose_c(new int[] {rs.getInt("PURPOSE_1"), rs.getInt("PURPOSE_2"), rs.getInt("PURPOSE_3"), rs.getInt("PURPOSE_4"), 
					rs.getInt("PURPOSE_5"), rs.getInt("PURPOSE_6"), rs.getInt("PURPOSE_7")
			});
			tour.setWith_c(new int[] {rs.getInt("WITH_1"), rs.getInt("WITH_2"), rs.getInt("WITH_3"), rs.getInt("WITH_4"), 
					rs.getInt("WITH_5")
			});
			tour.setJob_c(new int[] {rs.getInt("JOB_1"), rs.getInt("JOB_2"), rs.getInt("JOB_3"), rs.getInt("JOB_4"), 
					rs.getInt("JOB_5"), rs.getInt("JOB_6"), rs.getInt("JOB_7"), rs.getInt("JOB_8"), 
					rs.getInt("JOB_9"), rs.getInt("JOB_10"), rs.getInt("JOB_11"), rs.getInt("JOB_12") 
			});
			
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
		
		return tour;
	}
	
	/*
	public static void main(String args[]) {

		try {
			System.out.println(new tourspotStasticDAO().tourSpotStastic("1"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	*/

}
