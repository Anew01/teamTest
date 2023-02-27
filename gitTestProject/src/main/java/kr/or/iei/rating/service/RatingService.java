package kr.or.iei.rating.service;

import kr.or.iei.rating.dao.RatingDao;

public class RatingService {
	private RatingDao dao;

	public RatingService() {
		super();
		dao = new RatingDao();
	}
}
