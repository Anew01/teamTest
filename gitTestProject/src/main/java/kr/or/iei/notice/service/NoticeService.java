package kr.or.iei.notice.service;

import kr.or.iei.notice.dao.NoticeDao;

public class NoticeService {
	private NoticeDao noticeDao;

	public NoticeService(NoticeDao noticeDao) {
		super();

		noticeDao = new NoticeDao();
	}
}
