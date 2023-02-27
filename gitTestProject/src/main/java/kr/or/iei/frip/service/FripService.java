package kr.or.iei.frip.service;

import java.sql.Connection;

import common.JDBCTemplate;
import kr.or.iei.frip.dao.FripDao;
import kr.or.iei.frip.vo.Frip;

public class FripService {
	private FripDao dao;
	
	public FripService() {
		dao = new FripDao();
	}

	public int insertFrip(Frip f) {
		Connection conn = JDBCTemplate.getConnection();
		int result1 = dao.insertFrip(conn, f);
		return result1;
	}

}
