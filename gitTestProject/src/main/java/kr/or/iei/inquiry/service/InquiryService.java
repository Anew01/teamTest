package kr.or.iei.inquiry.service;

import kr.or.iei.inquiry.dao.InquiryDao;

public class InquiryService {
	private InquiryDao inquiryDao;

	public InquiryService() {
		super();
		
		inquiryDao = new InquiryDao();
	}
	
}
