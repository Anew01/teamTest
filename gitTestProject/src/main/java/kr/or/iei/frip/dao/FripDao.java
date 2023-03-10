package kr.or.iei.frip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import kr.or.iei.frip.vo.Frip;
import kr.or.iei.frip.vo.FripJoinableDate;

public class FripDao {

	public int insertFrip(Connection conn, Frip f) {
		PreparedStatement pstmt = null;
		String query = "insert into frip_tbl values(frip_seq.nextval,?,0,?,?,?,?,?,0,0,to_char(sysdate,'yyyy-mm-dd'),?)";
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, f.getFripWriter());
			pstmt.setString(2, f.getFripTitle());
			pstmt.setString(3, f.getFripContent());
			pstmt.setString(4, f.getFripAddr());
			pstmt.setString(5, f.getFripLevel());
			pstmt.setInt(6, f.getFripPrice());
			pstmt.setString(7, f.getFripAddrDetail());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	public int insertFripCategory(Connection conn, int fripNo, String fripCategory) {
		PreparedStatement pstmt = null;
		String query = "insert into frip_category values(frip_category_seq.nextval,?,?)";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, fripNo);
			pstmt.setString(2, fripCategory);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	public int selectFripNo(Connection conn, Frip f) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select frip_no from frip_tbl where frip_title=? and frip_writer=?";
		int fripNo = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, f.getFripTitle());
			pstmt.setString(2, f.getFripWriter());
			rset = pstmt.executeQuery();
			if(rset.next()) {
				fripNo = rset.getInt("frip_no");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fripNo;
	}
	public int insertFripFile(Connection conn, int fripNo, String filepath) {
		PreparedStatement pstmt = null;
		String query = "insert into frip_file values(frip_file_seq.nextval,?,?)";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, fripNo);
			pstmt.setString(2, filepath);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	public int insertFripJoinableDate(Connection conn, Frip f, int fripNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "insert into frip_joinable_date values(joinable_date_seq.nextval,?,?,?,?)";
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, fripNo);
			String startDate = "";
			String endDate = "";
			for(FripJoinableDate joinDate : f.getJoinableDates()) {
				startDate = joinDate.getStartDate();
				endDate = joinDate.getEndDate();
			}
			pstmt.setString(2, startDate);
			pstmt.setInt(3, f.getMaxCount());
			pstmt.setString(4, endDate);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	public ArrayList<Frip> selectAllFrip(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Frip> list = new ArrayList<>();
		Frip f = null;
		String query = "select * from frip_tbl t join frip_category c "
				+ "on (t.frip_no=c.frip_no)";
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				f = new Frip();
				f.setFripTitle(rset.getString("frip_title"));
				f.setFripAddr(rset.getString("frip_addr"));
				f.setFripAuth(rset.getString("frip_auth"));
				f.setFripCategory(rset.getString("category_name"));
				f.setFripContent(rset.getString("frip_content"));
				f.setFripIncome(rset.getInt("frip_income"));
				f.setFripLevel(rset.getString("frip_level"));
				f.setFripPrice(rset.getInt("frip_price"));
				f.setFripNo(rset.getInt("frip_no"));
				f.setFripStatus(rset.getString("frip_status"));
				f.setWriteDate(rset.getString("write_date"));
				f.setFripWriter(rset.getString("frip_writer"));
				list.add(f);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return list;
	}
	public ArrayList<String> selectFripFiles(Connection conn, int fripNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<String> list = new ArrayList<>();
		String filepath = "";
		String query = "select * from frip_file where frip_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, fripNo);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				filepath = rset.getString("file_path");
				list.add(filepath);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return list;
	}
	public ArrayList<FripJoinableDate> selectJoinableDates(Connection conn, int fripNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<FripJoinableDate> list = new ArrayList<>();
		FripJoinableDate date = null;
		String query = "select * from frip_joinable_date where frip_no=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, fripNo);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				date = new FripJoinableDate();
				date.setStartDate(rset.getString("start_date"));
				date.setEndDate(rset.getString("end_date"));
				date.setMaxCount(rset.getInt("max_count"));
				list.add(date);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
	public ArrayList<Frip> selectMyFrip(Connection conn, String fripWriter) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Frip> list = new ArrayList<>();
		Frip f = null;
		String query = "select * from frip_tbl t join frip_category c\n"
				+ "on (t.frip_no=c.frip_no) \n"
				+ "where frip_writer=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, fripWriter);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				f = new Frip();
				f.setFripTitle(rset.getString("frip_title"));
				f.setFripAddr(rset.getString("frip_addr"));
				f.setFripAuth(rset.getString("frip_auth"));
				f.setFripCategory(rset.getString("category_name"));
				f.setFripContent(rset.getString("frip_content"));
				f.setFripIncome(rset.getInt("frip_income"));
				f.setFripLevel(rset.getString("frip_level"));
				f.setFripPrice(rset.getInt("frip_price"));
				f.setFripNo(rset.getInt("frip_no"));
				f.setFripStatus(rset.getString("frip_status"));
				f.setWriteDate(rset.getString("write_date"));
				f.setFripWriter(rset.getString("frip_writer"));
				list.add(f);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
	public Frip selectOneFripByNo(Connection conn, int fripNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Frip f = null;
		String query = "select * from frip_tbl t join frip_category c on (t.frip_no=c.frip_no) where t.frip_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, fripNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				f = new Frip();
				f.setFripTitle(rset.getString("frip_title"));
				f.setFripAddr(rset.getString("frip_addr"));
				f.setFripAuth(rset.getString("frip_auth"));
				f.setFripCategory(rset.getString("category_name"));
				f.setFripContent(rset.getString("frip_content"));
				f.setFripIncome(rset.getInt("frip_income"));
				f.setFripLevel(rset.getString("frip_level"));
				f.setFripPrice(rset.getInt("frip_price"));
				f.setFripNo(rset.getInt("frip_no"));
				f.setFripStatus(rset.getString("frip_status"));
				f.setWriteDate(rset.getString("write_date"));
				f.setFripWriter(rset.getString("frip_writer"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return f;
	}
	public ArrayList<Frip> selectAllFripByCategory(Connection conn, String fripCategory) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Frip> list = new ArrayList<>();
		Frip f = null;
		String query = "";
		try {
			if (fripCategory.equals("ALL")) {
				query = "select * from frip_tbl a \r\n"
						+ "left join frip_category b using(frip_no) \r\n"
						+ "left join feed_tbl c using(frip_no)\r\n"
						+ "left join rating_tbl using(feed_no)";
				pstmt = conn.prepareStatement(query);
				rset = pstmt.executeQuery();
			}else if("main".equals(fripCategory)) {
				query = "select \r\n"
						+ "*\r\n"
						+ "from (select a.frip_no as ratingNo, decode(AVG(c.RATING), null, 0, ROUND(AVG(c.RATING),1)) as rating\r\n"
						+ "from frip_tbl a\r\n"
						+ "left join feed_tbl b on a.frip_no = b.frip_no\r\n"
						+ "left join rating_tbl c on b.feed_no = c.feed_no\r\n"
						+ "group by a.frip_no\r\n"
						+ ") a\r\n"
						+ "inner join frip_tbl b on a.ratingNo = b.frip_no\r\n"
						+ "inner join frip_category c on b.frip_no = c.frip_no\r\n"
						+ "where rownum < 4\r\n"
						+ "order by RATING DESC";
				pstmt = conn.prepareStatement(query);
				rset = pstmt.executeQuery();
			} else if("newFeed".equals(fripCategory)) {
				query ="SELECT * FROM FEED_TBL WHERE ROWNUM < 4 ORDER BY FEED_NO DESC";
				pstmt = conn.prepareStatement(query);
				rset = pstmt.executeQuery();
			} else {
				query = "select * from frip_tbl a \r\n"
						+ "left join frip_category b using(frip_no) \r\n"
						+ "left join feed_tbl c using(frip_no)\r\n"
						+ "left join rating_tbl using(feed_no)\r\n"
						+ "where b.category_name = ?";
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, fripCategory);
				rset = pstmt.executeQuery();
			}
			while(rset.next()) {
				f = new Frip();
				f.setFripTitle(rset.getString("frip_title"));
				f.setFripAddr(rset.getString("frip_addr"));
				f.setFripAuth(rset.getString("frip_auth"));
				f.setFripCategory(rset.getString("category_name"));
				f.setFripContent(rset.getString("frip_content"));
				f.setFripIncome(rset.getInt("frip_income"));
				f.setFripLevel(rset.getString("frip_level"));
				f.setFripPrice(rset.getInt("frip_price"));
				f.setFripNo(rset.getInt("frip_no"));
				f.setFripStatus(rset.getString("frip_status"));
				f.setWriteDate(rset.getString("write_date"));
				f.setFripWriter(rset.getString("frip_writer"));
				f.setAvgRating(rset.getString("rating"));
				list.add(f);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
	public int selectLastestFripJoinableDatePK(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select max(joinable_date_no) as latestPK from frip_joinable_date";
		int latestPK = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				latestPK = rset.getInt("latestPK");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return latestPK;
	}
	public FripJoinableDate selectOneFripJoinableDateByNo(Connection conn, int latestPK) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from frip_joinable_date where joinable_date_no=?";
		FripJoinableDate date = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, latestPK);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				date = new FripJoinableDate();
				date.setEndDate(rset.getString("end_date"));
				date.setFripNo(rset.getString("frip_no"));
				date.setMaxCount(rset.getInt("max_count"));
				date.setJoinableDateNo(rset.getInt("joinable_date_no"));
				date.setStartDate(rset.getString("start_date"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return date;
	}
	public String selectRating(Connection conn, int fripNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String avgRating = "0.0";
		System.out.println(fripNo);
		String query = 
				"select ROUND(AVG(D.RATING),1)AS RATING\r\n"
				+ "from frip_tbl A \r\n"
				+ "LEFT JOIN feed_tbl C ON A.FRIP_NO = C.FRIP_NO\r\n"
				+ "LEFT JOIN RATING_TBL D ON C.FEED_NO = D.FEED_NO\r\n"
				+ "WHERE A.FRIP_NO = ?\r\n"
				+ "GROUP BY A.FRIP_NO";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, fripNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				String rating = rset.getString("RATING");
				if (rating==null) {
					avgRating = "0.0";
				} else {
					avgRating = rating;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		System.out.println(avgRating);
		return avgRating;
	}

	public int deleteFripFilepath(Connection conn, int fripNo, String filepath) {
		PreparedStatement pstmt = null;
		String query = "delete from frip_file where frip_no=? and file_path=?";
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, fripNo);
			pstmt.setString(2, filepath);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int updateFrip(Connection conn, Frip f) {
		PreparedStatement pstmt = null;
		String query = "update frip_tbl set frip_title=?, frip_addr=?, frip_detail_addr=?, frip_level=?, frip_price=?, frip_content=? where frip_no=?";
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, f.getFripTitle());
			pstmt.setString(2, f.getFripAddr());
			pstmt.setString(3, f.getFripAddrDetail());
			pstmt.setString(4, f.getFripLevel());
			pstmt.setInt(5, f.getFripPrice());
			pstmt.setString(6, f.getFripContent());
			pstmt.setInt(7, f.getFripNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int updateFripCategory(Connection conn, int fripNo, String fripCategory) {
		PreparedStatement pstmt = null;
		String query = "update frip_category set category_name=? where frip_no=?";
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, fripCategory);
			pstmt.setInt(2, fripNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	public ArrayList<Frip> selectNewFeed(Connection conn, String newFeed) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Frip> list = new ArrayList<>();
		String query ="SELECT * FROM FRIP_TBL \r\n"
				+ "left join frip_category using(frip_no)\r\n"
				+ "left join feed_tbl  using(frip_no) \r\n"
				+ "left join rating_tbl using(feed_no) \r\n"
				+ "WHERE ROWNUM < 4 ORDER BY FRIP_NO DESC";
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
		while(rset.next()) {
			Frip f = new Frip();
			f.setFripTitle(rset.getString("frip_title"));
			f.setFripAddr(rset.getString("frip_addr"));
			f.setFripAuth(rset.getString("frip_auth"));
			f.setFripContent(rset.getString("frip_content"));
			f.setFripIncome(rset.getInt("frip_income"));
			f.setFripLevel(rset.getString("frip_level"));
			f.setFripPrice(rset.getInt("frip_price"));
			f.setFripNo(rset.getInt("frip_no"));
			f.setFripStatus(rset.getString("frip_status"));
			f.setWriteDate(rset.getString("write_date"));
			f.setFripWriter(rset.getString("frip_writer"));
			f.setAvgRating(rset.getString("rating"));
			f.setFripCategory(rset.getString("category_name"));
			list.add(f);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		JDBCTemplate.close(rset);
		JDBCTemplate.close(pstmt);
	}
	return list;
	}
	public ArrayList<Frip> searchFrip(Connection conn, String searchFrip) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Frip> list = new ArrayList<>();
		String query = "SELECT * FROM FRIP_TBL\r\n"
				+ "left join frip_category  using(frip_no)"
				+ "left join feed_tbl  using(frip_no)\r\n"
				+ "left join rating_tbl using(feed_no)\r\n"
				+ "WHERE FRIP_TITLE LIKE ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+searchFrip+"%");
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Frip f = new Frip();
				f.setFripTitle(rset.getString("frip_title"));
				f.setFripAddr(rset.getString("frip_addr"));
				f.setFripAuth(rset.getString("frip_auth"));
				f.setFripContent(rset.getString("frip_content"));
				f.setFripIncome(rset.getInt("frip_income"));
				f.setFripLevel(rset.getString("frip_level"));
				f.setFripPrice(rset.getInt("frip_price"));
				f.setFripNo(rset.getInt("frip_no"));
				f.setFripStatus(rset.getString("frip_status"));
				f.setWriteDate(rset.getString("write_date"));
				f.setFripWriter(rset.getString("frip_writer"));
				f.setAvgRating(rset.getString("rating"));
				f.setFripCategory(rset.getString("category_name"));
				list.add(f);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}	
}