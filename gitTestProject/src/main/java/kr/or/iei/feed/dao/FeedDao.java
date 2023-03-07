package kr.or.iei.feed.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.or.iei.feed.vo.Feed;

public class FeedDao {

	public ArrayList<Feed> selectAllMyFripFeed(Connection conn, int fripNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from feed_tbl where fripNo=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, fripNo);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
