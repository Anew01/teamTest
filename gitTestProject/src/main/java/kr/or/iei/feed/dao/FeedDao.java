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
		String query = "INSERT INTO FEED_TBL VALUES(FEED_TBL_SEQ.NEXTVAL, ?, ?, ?, null, null, null, SYSDATE)";
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

	public int insertFeedComment(Connection conn, String feedWriter, String feedContent, int fripNo, int fdNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO FEED_TBL VALUES(FEED_TBL_SEQ.NEXTVAL, ?, ?, ?, null, null, ?, SYSDATE)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, feedWriter);
			pstmt.setInt(2, fripNo);
			pstmt.setString(3, feedContent);
			pstmt.setInt(4, fdNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int firstFeed(Connection conn, int fripNo, String feedWriter) {
		PreparedStatement pstmt = null; 
		int result = 0;
		String query = "INSERT INTO FEED_TBL VALUES(FEED_TBL_SEQ.NEXTVAL, ?, ?, 'sprip',null,null,null, TO_CHAR(SYSDATE, 'YYYY-MM-DD'))";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, feedWriter);
			pstmt.setInt(2, fripNo);
			System.out.println("feedDao?????? feedWriter ??? : "+feedWriter);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ArrayList<Feed> selectOneFeed(Connection conn, int fripNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Feed> fList = new ArrayList<>();
		String query = "SELECT * FROM FEED_TBL WHERE FRIP_NO = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, fripNo);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Feed feed = new Feed();
				feed.setFeedNo(rset.getInt("feed_no"));
				feed.setFeedWriter(rset.getString("feed_writer"));
				feed.setFripNo(rset.getInt("frip_no"));
				feed.setFeedContent(rset.getString("feed_content"));
				feed.setFilename(rset.getString("file_name"));
				feed.setFilepath(rset.getString("file_path"));
				feed.setFdNo(rset.getInt("fd_no"));
				feed.setWriteDate(rset.getString("write_date"));
				fList.add(feed);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return fList;
	}

	public int selectLastestFeedNo(Connection conn, int fripNo, String feedWriter) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT max(feed_no) as lateNo FROM FEED_TBL WHERE FRIP_NO = ? and feed_writer=?";
		int feedNo = -1;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, fripNo);
			pstmt.setString(2, feedWriter);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				feedNo = rset.getInt("lateNo");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return feedNo;
	}

	public int insertFeed(Connection conn, String feedWriter, String feedContent, int fripNo, String filepath) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO FEED_TBL VALUES(FEED_TBL_SEQ.NEXTVAL, ?, ?, ?, null, ?, null, SYSDATE)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, feedWriter);
			pstmt.setInt(2, fripNo);
			pstmt.setString(3, feedContent);
			pstmt.setString(4, filepath);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public Feed selectFeed(Connection conn, int feedNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Feed f = null;
		String query = "SELECT * FROM FEED_TBL WHERE FEED_NO = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, feedNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				Feed feed = new Feed();
				feed.setFeedNo(rset.getInt("feed_no"));
				feed.setFeedWriter(rset.getString("feed_writer"));
				feed.setFripNo(rset.getInt("frip_no"));
				feed.setFeedContent(rset.getString("feed_content"));
				feed.setFilename(rset.getString("file_name"));
				feed.setFilepath(rset.getString("file_path"));
				feed.setFdNo(rset.getInt("fd_no"));
				feed.setWriteDate(rset.getString("write_date"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return f;
	}
}
