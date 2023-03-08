package kr.or.iei.feed.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import kr.or.iei.feed.dao.FeedDao;
import kr.or.iei.feed.vo.Feed;
import kr.or.iei.feed.vo.ViewFripFeedData;
import kr.or.iei.member.service.MemberService;
import kr.or.iei.member.vo.Member;

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

	public ArrayList<ViewFripFeedData> selectAllMyFripFeed(int fripNo) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Feed> feedList = dao.selectAllMyFripFeed(conn, fripNo);
		ArrayList<ViewFripFeedData> list = new ArrayList<>();
		ViewFripFeedData data = null;
		if(feedList.size() > 0 ){
			for(Feed f : feedList) {
				String memberId = f.getFeedWriter();
				MemberService memService = new MemberService();
				Member m = memService.selectOneMember(memberId);
				String memProfilepath = m.getMemberProfile();
				data = new ViewFripFeedData();
				data.setF(f);
				data.setMemProfilepath(memProfilepath);
				list.add(data);
			}
		}
		JDBCTemplate.close(conn);
		return list;
	}

	public int insertFeed(String feedWriter, String feedContent, int fripNo, int fdNo) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.insertFeedComment(conn, feedWriter, feedContent, fripNo, fdNo);
			if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int firstFeed(int fripNo, String feedWriter) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.firstFeed(conn, fripNo, feedWriter);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<Feed> selectOneFeed(int fripNo) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Feed> fList = dao.selectOneFeed(conn, fripNo);
		JDBCTemplate.close(conn);
		return fList;
	}
}


