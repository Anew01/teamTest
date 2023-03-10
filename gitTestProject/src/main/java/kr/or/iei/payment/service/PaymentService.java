package kr.or.iei.payment.service;

import java.sql.Connection;

import common.JDBCTemplate;
import kr.or.iei.payment.dao.PaymentDao;

public class PaymentService {
	private PaymentDao payDao;

	public PaymentService() {
		super();
		payDao = new PaymentDao();
	}

	public int selectCountMyFripPayment(int fripNo) {
		Connection conn = JDBCTemplate.getConnection();
		int totalCount = payDao.selectCountMyFripPayment(conn, fripNo);
		JDBCTemplate.close(conn);
		return totalCount;
	}

	public Boolean checkMyPayment(int memberNo, int fripNo) {
		Connection conn = JDBCTemplate.getConnection();
		Boolean isPayed = payDao.selectMyPayment(conn, memberNo, fripNo);
		JDBCTemplate.close(conn);
		return isPayed;
	}

	public int insertPayment(String date, int price, int memberNo, int fripNo, int attendNo) {
		Connection conn = JDBCTemplate.getConnection();
		int result = payDao.insertPayment(conn, date, price, memberNo, fripNo, attendNo); 
		JDBCTemplate.close(conn);
		return result;
	}

}
