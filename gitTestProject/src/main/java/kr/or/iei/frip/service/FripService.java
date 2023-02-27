package kr.or.iei.frip.service;

import kr.or.iei.frip.dao.FripDao;
import kr.or.iei.frip.vo.Frip;

public class FripService {
	private FripDao dao;
	
	public FripService() {
		dao = new FripDao();
	}

	public int insertFrip(Frip f) {
		return 0;
	}

}
