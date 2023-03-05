package kr.or.iei.join.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;
import kr.or.iei.frip.vo.Frip;

public class JoinFripDao {

	public int checkCalander(Connection conn, int fripNo, String calendar) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result= 0;
		//1.원하는 플립과 날짜에서 가능한 프립 날짜가 있는지 // end_date와 start_date는 같은 날짜를 넣는다.
		String query = "select joinable_date_no from frip_joinable_date where frip_no=? and (?<=end_date and ?>=start_date)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, fripNo);
			pstmt.setString(2, calendar);
			pstmt.setString(3, calendar);
			rset=pstmt.executeQuery();
			if(rset.next()) {
				result=1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int checkMaxCount(Connection conn, int fripNo, String calendar) {
		 //2. 원하는 날짜에 이 플립이 몇명이 들어가는지 세오기 
		 //-> 2-1. 최대인원수
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int maxCount = 0;
		String query = "select max_count from frip_joinable_date where frip_no=? and (?<=end_date and ?>=start_date)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, fripNo);
			pstmt.setString(2, calendar);
			pstmt.setString(3, calendar);
			rset=pstmt.executeQuery();
			if(rset.next()) {
				maxCount = rset.getInt("max_count");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return maxCount;
	}

	public int checkJoinCount(Connection conn, String calendar, int fripNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int joinCount = 0;
		String query = "select sum(join_count) from join_frip where join_date=? and frip_no=?";
		try {
			pstmt= conn.prepareStatement(query);
			pstmt.setString(1, calendar);
			pstmt.setInt(2, fripNo);
			rset=pstmt.executeQuery();
			if(rset.next()) {
				joinCount = rset.getInt("join_count");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return joinCount;
	}

}
