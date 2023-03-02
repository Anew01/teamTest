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
		String query = "insert into frip_tbl values(frip_seq.nextval,?,0,?,?,?,?,?,0,0,to_char(sysdate,'yyyy-mm-dd'))";
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, f.getFripWriter());
			pstmt.setString(2, f.getFripTitle());
			pstmt.setString(3, f.getFripContent());
			pstmt.setString(4, f.getFripAddr());
			pstmt.setString(5, f.getFripLevel());
			pstmt.setInt(6, f.getFripPrice());
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
			System.out.println(startDate);
			System.out.println(endDate);
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
}
