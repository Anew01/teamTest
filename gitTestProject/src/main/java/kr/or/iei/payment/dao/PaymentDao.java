package kr.or.iei.payment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;

public class PaymentDao {

	public int selectCountMyFripPayment(Connection conn, int fripNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int totalCount = 0;
		String query = "select count(*) as cnt from payment_tbl where frip_no=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, fripNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				totalCount = rset.getInt("cnt");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return totalCount;
	}

	public Boolean selectMyPayment(Connection conn, int memberNo, int fripNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from payment_tbl where member_no=? and frip_no=?";
		Boolean isPayed = false;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, fripNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				isPayed = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return isPayed;
	}

	public int insertPayment(Connection conn, String date, int price, int memberNo, int fripNo, int attendNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "insert into payment_tbl values(payment_tbl_seq.nextval, ?,?,'신용카드',?,?,to_char(sysdate,'YYY-MM-DD'),?)";
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, fripNo);
			pstmt.setInt(3, price);
			pstmt.setInt(4, price);
			pstmt.setInt(5, attendNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
}
