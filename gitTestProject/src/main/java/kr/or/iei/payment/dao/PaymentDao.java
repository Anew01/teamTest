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

}
