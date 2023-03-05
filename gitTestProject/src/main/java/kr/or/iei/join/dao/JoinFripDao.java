package kr.or.iei.join.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;
import kr.or.iei.join.vo.JoinFrip;

public class JoinFripDao {

	public JoinFrip selectCount(Connection conn, String date, int fripNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		JoinFrip j = null;
		String query = "SELECT b.max_count AS maxCount\r\n"
				+ "     , (SELECT COUNT(*) FROM PAYMENT_TBL WHERE FRIP_NO = A.FRIP_NO AND PAYMENT_DATE = ?) AS useCount\r\n"
				+ "FROM FRIP_TBL A \r\n"
				+ "INNER JOIN FRIP_JOINABLE_DATE B ON A.FRIP_NO = B.FRIP_NO\r\n"
				+ "WHERE A.FRIP_NO = ? \r\n"
				+ "AND B.START_DATE <= ? \r\n"
				+ "AND B.END_DATE >= ? ";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, date);
			pstmt.setInt(2, fripNo);
			pstmt.setString(3, date);
			pstmt.setString(4, date);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				j = new JoinFrip();
				j.setMaxCnt(rset.getString("maxCount"));
				j.setUseCnt(rset.getString("useCount"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return j;
	}

}
