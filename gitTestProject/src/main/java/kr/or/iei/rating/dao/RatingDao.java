package kr.or.iei.rating.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import common.JDBCTemplate;

public class RatingDao {

	public int insertRating(Connection conn, int feedNo, int rating) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO RATING_TBL VALUES(RATING_TBL_SEQ.NEXTVAL, ?, ?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, feedNo);
			pstmt.setInt(2, rating);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
				
		return result;
	}

}
