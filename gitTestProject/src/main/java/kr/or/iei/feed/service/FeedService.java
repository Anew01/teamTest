package kr.or.iei.feed.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import kr.or.iei.feed.dao.FeedDao;
import kr.or.iei.feed.vo.Feed;

public class FeedService {
	private FeedDao dao;
	public FeedService() {
		dao = new FeedDao();
	}
	public ArrayList<Feed> selectAllMyFripFeed(int fripNo) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Feed> list = dao.selectAllMyFripFeed(conn, fripNo);
		return null;
	}
	
	
}
