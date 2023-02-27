package kr.or.iei.fripCategory.service;

import kr.or.iei.fripCategory.dao.FripCategoryDao;

public class FripCategoryService {
	private FripCategoryDao dao;

	public FripCategoryService() {
		super();
		dao = new FripCategoryDao();
	}
}
