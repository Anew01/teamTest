package kr.or.iei.notice.service;

import java.sql.Connection;

import common.JDBCTemplate;
import kr.or.iei.notice.dao.NoticeDao;
import kr.or.iei.notice.vo.Notice;

public class NoticeService {
	private NoticeDao dao;

	public NoticeService() {
		super();

		dao = new NoticeDao();
	}

	public int insertNotice(Notice notice) {
		Connection conn = JDBCTemplate.getConnection();

		int result = dao.insertNotice(conn, notice);

		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}

		JDBCTemplate.close(conn);

		return result;
	}

}
