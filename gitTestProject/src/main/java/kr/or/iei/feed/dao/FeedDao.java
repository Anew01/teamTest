package kr.or.iei.feed.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import kr.or.iei.feed.vo.Feed;

public class FeedDao {

	public ArrayList<Feed> selectAllMyFripFeed(Connection conn, int fripNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Feed> list = new ArrayList<>();
		Feed f = null;
		String query = "select * from feed_tbl where frip_no=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, fripNo);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				f = new Feed();
				f.setFdNo(rset.getInt("fd_no"));
				f.setFeedContent(rset.getString("feed_content"));
				f.setFeedNo(rset.getInt("feed_no"));
				f.setFeedWriter(rset.getString("feed_writer"));
				f.setFilename(rset.getString("file_name"));
				f.setFilepath(rset.getString("file_path"));
				f.setWriteDate(rset.getString("write_date"));
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
