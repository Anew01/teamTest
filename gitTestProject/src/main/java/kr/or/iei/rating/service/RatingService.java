package kr.or.iei.rating.service;

import java.sql.Connection;

import common.JDBCTemplate;
import kr.or.iei.rating.dao.RatingDao;

public class RatingService {
	private RatingDao dao;

	public RatingService() {
		super();
		dao = new RatingDao();
	}

	public int insertRating(int feedNo, int rating) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.insertRating(conn, feedNo, rating);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
}
