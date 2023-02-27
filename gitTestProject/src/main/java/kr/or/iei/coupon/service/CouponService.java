package kr.or.iei.coupon.service;

import kr.or.iei.coupon.dao.CouponDao;

public class CouponService {
	private CouponDao couponDao;

	public CouponService() {
		super();
		
		couponDao = new CouponDao();
	}
}
