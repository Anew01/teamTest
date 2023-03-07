package kr.or.iei.feed.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

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
				f.setFeedNo(rset.getInt("feed_no"));
				f.setFeedWriter(rset.getString("feed_writer"));
				f.setFripNo(rset.getInt("frip_no"));
				f.setFeedContent(rset.getString("feed_content"));
				f.setFilename(rset.getString("file_name"));
				f.setFilepath(rset.getString("file_path"));
				f.setFdNo(rset.getInt("fd_no"));
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
		
	public int insertFeed(Connection conn, String feedWriter, String feedContent, int fripNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO FEED_TBL VALUES(FEED_TBL_SEQ.NEXTVAL, ?, ?, ?, null, null, null, TO_CHAR(SYSDATE, 'YYYY-MM-DD'))";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, feedWriter);
			pstmt.setInt(2, fripNo);
			pstmt.setString(3, feedContent);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public Feed selectFeedNo(Connection conn, int fripNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Feed feed = null;
		String query = "SELECT FEED_NO FROM FEED_TBL WHERE frip_no = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, fripNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				feed = new Feed();
				feed.setFeedNo(rset.getInt("feed_no"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		
		return feed;
	}

	public ArrayList<Feed> selectFeedInfo(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Feed> list = new ArrayList<>();
		String query = "SELECT * FROM FEED_TBL";
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Feed f = new Feed();
				f.setFeedNo(rset.getInt("feed_no"));
				f.setFeedWriter(rset.getString("feed_writer"));
				f.setFripNo(rset.getInt("frip_no"));
				f.setFeedContent(rset.getString("feed_content"));
				f.setFilename(rset.getString("file_name"));
				f.setFilepath(rset.getString("file_path"));
				f.setFdNo(rset.getInt("fd_no"));
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
