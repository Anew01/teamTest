package kr.or.iei.payment.service;

import kr.or.iei.payment.dao.PaymentDao;

public class PaymentService {
	private PaymentDao payDao;

	public PaymentService() {
		super();
		payDao = new PaymentDao();
	}
	
	

}
