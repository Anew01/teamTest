package kr.or.iei.feed.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import kr.or.iei.feed.dao.FeedDao;
import kr.or.iei.feed.vo.Feed;

public class FeedService {
	private FeedDao dao;
	

	public FeedService() {
		super();
		dao = new FeedDao();
	}


	public int insertFeed(String feedWriter, String feedContent, int fripNo) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.insertFeed(conn, feedWriter, feedContent, fripNo);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}


	public Feed selectFeedNo(int fripNo) {
		Connection conn = JDBCTemplate.getConnection();
		Feed feed = dao.selectFeedNo(conn, fripNo);
		JDBCTemplate.close(conn);
		return feed;
	}


	public ArrayList<Feed> selectFeedInfo() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Feed> list = dao.selectFeedInfo(conn);
		JDBCTemplate.close(conn);
		return list;
	}

}
