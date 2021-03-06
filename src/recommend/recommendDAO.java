package recommend;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class recommendDAO extends connectionDAO{
	
	// 여행지 이름 초기화
	public static void InitialTour(Connection conn, ArrayList<tourVO> tour) {
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			pstm = conn.prepareStatement("select * from TOURSPOT order by ID");
			rs = pstm.executeQuery();
			for(int i= 1; i<136; i++) {
				rs.next();
				tour.add(new tourVO(i, rs.getString("NAME"), rs.getString("ADDRESS"), rs.getString("IMG_1")));
			}
					
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 지수 합산 함수
	public static void addQuotient(Connection conn, String name, ArrayList<tourVO> tour) {
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			pstm = conn.prepareStatement("select * from QUOTIENT order by ID");
			rs = pstm.executeQuery();	
		
			for(int i=0; i<135; i++) {
				rs.next();
				tour.get(i).setQuotient(tour.get(i).getQuotient() + rs.getDouble(name));
//				System.out.println(tour.get(i).getQuotient());
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstm.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	// 추천 서비스
	public static ArrayList<tourVO> recommendService(String gender,String  age,String nation,String   job,String   with,String   purpose,String   month) {
		ArrayList<tourVO> tour = new ArrayList<tourVO>();
		ArrayList<tourVO> recommend_tour = new ArrayList<tourVO>();
		Connection conn = null;
		String name = null;

		try {
			conn = getConnection();

			// 여행지 이름 초기화
			InitialTour(conn, tour);
			
			// 여기부터 지수들을 더하면 됩니다.
			// 먼저 성별부터 됩니다.
			if(!gender.equals("-1")) {
				name = "GENDER_";
				name = name.concat(gender);

				addQuotient(conn, name, tour);
			}
		
			// age
			if(!age.equals("-1")) {
				name = "AGE_";
				name = name.concat(age);

				addQuotient(conn, name, tour);
			}

			// nation
			if(!nation.equals("-1")) {
				name = "NATION_";
				name = name.concat(nation);

				addQuotient(conn, name, tour);
			}
			
			// job
			if(!job.equals("-1")) {
				name = "JOB_";
				name = name.concat(job);

				addQuotient(conn, name, tour);
			}
			
			// with
			if(!with.equals("-1")) {
				name = "WITH_";
				name = name.concat(with);
				
				addQuotient(conn, name, tour);
			} 
			
			// purpose
			if(!purpose.equals("-1")) {
				name = "PURPOSE_";
				name = name.concat(purpose);

				addQuotient(conn, name, tour);
			}
			
			// month
			if(!month.equals("-1")) {
				name = "MONTH_";
				name = name.concat(month);
				System.out.println(name);

				addQuotient(conn, name, tour);
			}
			
			/*
			for(int i=0; i<135; i++) {
				System.out.println("i : " + i + " / t : " + tour.get(i));
			}
			*/

			Collections.sort(tour, new Comparator<tourVO>() {
				@Override
				public int compare(tourVO o1, tourVO o2) {
					if(o1.getQuotient() < o2.getQuotient()) {
						return 1;
					} else if(o1.getQuotient() > o2.getQuotient()) {
						return -1;
					} else {
						return 0;
					}
				}
			});
			
			for(int i=0; i<5; i++) {
				recommend_tour.add(tour.get(i));
			}
			
			System.out.println(recommend_tour);
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return recommend_tour;
	}
	
	public static void main(String args[]) {
		
		Connection conn = null;
		ArrayList<tourVO> tour = new ArrayList<tourVO>();
		
		try {
			conn = getConnection();
			recommendService("-1", "-1", "-1", "-1", "-1", "-1", "1");
			
		} catch(Exception e) {
			e.printStackTrace();
		} 

	}

}
