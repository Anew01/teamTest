package kr.or.iei.notice.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import kr.or.iei.notice.dao.NoticeDao;
import kr.or.iei.notice.vo.Notice;
import kr.or.iei.notice.vo.NoticePageData;

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

	public NoticePageData selectNoticeList(int reqPage) {
		Connection conn = JDBCTemplate.getConnection();

		int numPerPage = 10;

		int end = numPerPage * reqPage;
		int start = end - numPerPage + 1;

		int totalCount = dao.selectNoticeCount(conn);

		int totalPage = 0;

		if (totalCount % numPerPage == 0) {
			totalPage = totalCount / numPerPage;
		} else {
			totalPage = totalCount / numPerPage + 1;
		}

		int pageNaviSize = 5;

		int pageNo = ((reqPage - 1) / pageNaviSize) * pageNaviSize + 1;

		String pageNavi = "<ul class='pagination circle-style'>";

		if (pageNo != 1) {
			pageNavi += "<li>";
			pageNavi += "<a class='page-item' href='/noticeList.do?reqPage=" + (pageNo - 1) + "'>";
			pageNavi += "<span class='material-icons'>chevron_left</span>";
			pageNavi += "</a></li>";
		}

		for (int i = 0; i < pageNaviSize; i++) {
			if (pageNo == reqPage) {
				pageNavi += "<li>";
				pageNavi += "<a class='page-item active-page' href='/noticeList.do?reqPage=" + (pageNo) + "'>";
				pageNavi += pageNo;
				pageNavi += "</a></li>";
			} else {
				pageNavi += "<li>";
				pageNavi += "<a class='page-item' href='/noticeList.do?reqPage=" + (pageNo) + "'>";
				pageNavi += pageNo;
				pageNavi += "</a></li>";
			}
			pageNo++;
			if (pageNo > totalPage) {
				break;
			}
		}

		if (pageNo <= totalPage) {
			pageNavi += "<li>";
			pageNavi += "<a class='page-item' href='/noticeList.do?reqPage=" + (pageNo) + "'>";
			pageNavi += "<span class='material-icons'>chevron_right</span>";
			pageNavi += "</a></li>";
		}
		pageNavi += "</ul>";

		ArrayList<Notice> list = dao.selectNoticeList(conn, start, end);

		JDBCTemplate.close(conn);

		NoticePageData noticePageData = new NoticePageData(list, pageNavi, start);

		return noticePageData;
	}

	public Notice getNotice(int noticeNo) {
		Connection connection = JDBCTemplate.getConnection();

		Notice notice = dao.selectOneNotice(connection, noticeNo);

		JDBCTemplate.close(connection);

		return notice;
	}

	public int upadteNotice(Notice notice) {
		Connection connection = JDBCTemplate.getConnection();

		int result = dao.updateNotice(connection, notice);

		if (result > 0) {
			JDBCTemplate.commit(connection);
		} else {
			JDBCTemplate.rollback(connection);
		}

		JDBCTemplate.close(connection);

		return result;
	}

	public int deleteNotice(int noticeNo) {
		Connection connection = JDBCTemplate.getConnection();

		int result = dao.deleteNotice(connection, noticeNo);

		if (result > 0) {
			JDBCTemplate.commit(connection);
		} else {
			JDBCTemplate.rollback(connection);
		}

		JDBCTemplate.close(connection);

		return result;
	}

	public Notice slectOneNotice(int noticeNo) {
		Connection connection = JDBCTemplate.getConnection();

		Notice notice = dao.selectOneNotice(connection, noticeNo);

		JDBCTemplate.close(connection);

		return notice;
	}

	public NoticePageData selectNoticeListUser(int reqPage) {
		Connection conn = JDBCTemplate.getConnection();

		int numPerPage = 10;

		int end = numPerPage * reqPage;
		int start = end - numPerPage + 1;

		int totalCount = dao.selectNoticeCount(conn);

		int totalPage = 0;

		if (totalCount % numPerPage == 0) {
			totalPage = totalCount / numPerPage;
		} else {
			totalPage = totalCount / numPerPage + 1;
		}

		int pageNaviSize = 5;

		int pageNo = ((reqPage - 1) / pageNaviSize) * pageNaviSize + 1;

		String pageNavi = "<ul class='pagination circle-style'>";

		if (pageNo != 1) {
			pageNavi += "<li>";
			pageNavi += "<a class='page-item' href='/noticeListUser.do?reqPage=" + (pageNo - 1) + "'>";
			pageNavi += "<span class='material-icons'>chevron_left</span>";
			pageNavi += "</a></li>";
		}

		for (int i = 0; i < pageNaviSize; i++) {
			if (pageNo == reqPage) {
				pageNavi += "<li>";
				pageNavi += "<a class='page-item active-page' href='/noticeListUser.do?reqPage=" + (pageNo) + "'>";
				pageNavi += pageNo;
				pageNavi += "</a></li>";
			} else {
				pageNavi += "<li>";
				pageNavi += "<a class='page-item' href='/noticeListUser.do?reqPage=" + (pageNo) + "'>";
				pageNavi += pageNo;
				pageNavi += "</a></li>";
			}
			pageNo++;
			if (pageNo > totalPage) {
				break;
			}
		}

		if (pageNo <= totalPage) {
			pageNavi += "<li>";
			pageNavi += "<a class='page-item' href='/noticeListUser.do?reqPage=" + (pageNo) + "'>";
			pageNavi += "<span class='material-icons'>chevron_right</span>";
			pageNavi += "</a></li>";
		}
		pageNavi += "</ul>";

		ArrayList<Notice> list = dao.selectNoticeList(conn, start, end);

		JDBCTemplate.close(conn);

		NoticePageData noticePageData = new NoticePageData(list, pageNavi, start);

		return noticePageData;
	}

	public NoticePageData selectNoticeNoticeList(int reqPage) {
		Connection conn = JDBCTemplate.getConnection();

		int numPerPage = 10;

		int end = numPerPage * reqPage;
		int start = end - numPerPage + 1;

		int totalCount = dao.selectNoticeNoticeCount(conn);

		int totalPage = 0;

		if (totalCount % numPerPage == 0) {
			totalPage = totalCount / numPerPage;
		} else {
			totalPage = totalCount / numPerPage + 1;
		}

		int pageNaviSize = 5;

		int pageNo = ((reqPage - 1) / pageNaviSize) * pageNaviSize + 1;

		String pageNavi = "<ul class='pagination circle-style'>";

		if (pageNo != 1) {
			pageNavi += "<li>";
			pageNavi += "<a class='page-item' href='/noticeNoticeListUser.do?reqPage=" + (pageNo - 1) + "'>";
			pageNavi += "<span class='material-icons'>chevron_left</span>";
			pageNavi += "</a></li>";
		}

		for (int i = 0; i < pageNaviSize; i++) {
			if (pageNo == reqPage) {
				pageNavi += "<li>";
				pageNavi += "<a class='page-item active-page' href='/noticeNoticeListUser.do?reqPage=" + (pageNo)
						+ "'>";
				pageNavi += pageNo;
				pageNavi += "</a></li>";
			} else {
				pageNavi += "<li>";
				pageNavi += "<a class='page-item' href='/noticeNoticeListUser.do?reqPage=" + (pageNo) + "'>";
				pageNavi += pageNo;
				pageNavi += "</a></li>";
			}
			pageNo++;
			if (pageNo > totalPage) {
				break;
			}
		}

		if (pageNo <= totalPage) {
			pageNavi += "<li>";
			pageNavi += "<a class='page-item' href='/noticeNoticeListUser.do?reqPage=" + (pageNo) + "'>";
			pageNavi += "<span class='material-icons'>chevron_right</span>";
			pageNavi += "</a></li>";
		}

		pageNavi += "</ul>";

		ArrayList<Notice> list = dao.selectNoticeNoticeList(conn, start, end);

		JDBCTemplate.close(conn);

		NoticePageData noticePageData = new NoticePageData(list, pageNavi, start);

		return noticePageData;
	}

	public NoticePageData selectEventNoticeList(int reqPage) {
		Connection conn = JDBCTemplate.getConnection();

		int numPerPage = 10;

		int end = numPerPage * reqPage;
		int start = end - numPerPage + 1;

		int totalCount = dao.selectEventNoticeCount(conn);

		int totalPage = 0;

		if (totalCount % numPerPage == 0) {
			totalPage = totalCount / numPerPage;
		} else {
			totalPage = totalCount / numPerPage + 1;
		}

		int pageNaviSize = 5;

		int pageNo = ((reqPage - 1) / pageNaviSize) * pageNaviSize + 1;

		String pageNavi = "<ul class='pagination circle-style'>";

		if (pageNo != 1) {
			pageNavi += "<li>";
			pageNavi += "<a class='page-item' href='/noticeNoticeListUser.do?reqPage=" + (pageNo - 1) + "'>";
			pageNavi += "<span class='material-icons'>chevron_left</span>";
			pageNavi += "</a></li>";
		}

		for (int i = 0; i < pageNaviSize; i++) {
			if (pageNo == reqPage) {
				pageNavi += "<li>";
				pageNavi += "<a class='page-item active-page' href='/noticeNoticeListUser.do?reqPage=" + (pageNo)
						+ "'>";
				pageNavi += pageNo;
				pageNavi += "</a></li>";
			} else {
				pageNavi += "<li>";
				pageNavi += "<a class='page-item' href='/noticeNoticeListUser.do?reqPage=" + (pageNo) + "'>";
				pageNavi += pageNo;
				pageNavi += "</a></li>";
			}
			pageNo++;
			if (pageNo > totalPage) {
				break;
			}
		}

		if (pageNo <= totalPage) {
			pageNavi += "<li>";
			pageNavi += "<a class='page-item' href='/noticeNoticeListUser.do?reqPage=" + (pageNo) + "'>";
			pageNavi += "<span class='material-icons'>chevron_right</span>";
			pageNavi += "</a></li>";
		}

		pageNavi += "</ul>";

		ArrayList<Notice> list = dao.selectEventNoticeList(conn, start, end);

		JDBCTemplate.close(conn);

		NoticePageData noticePageData = new NoticePageData(list, pageNavi, start);

		return noticePageData;
	}

}
