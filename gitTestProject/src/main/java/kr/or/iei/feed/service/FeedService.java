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
		dao = new FeedDao();
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
	
	
}
