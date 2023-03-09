package kr.or.iei.inquiry.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import kr.or.iei.inquiry.dao.InquiryDao;
import kr.or.iei.inquiry.vo.InquiryList;

public class InquiryService {
	private InquiryDao dao ;

	public InquiryService() {
		super();
		dao = new InquiryDao();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<InquiryList> allInquiryList(int fripNo) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<InquiryList> list = dao.allInquiryList(conn, fripNo);
		JDBCTemplate.close(conn);
		return list;
	}
	
	

}
