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
	
	

}
