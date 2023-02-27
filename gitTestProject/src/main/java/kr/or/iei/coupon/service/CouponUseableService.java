package kr.or.iei.coupon.service;

import kr.or.iei.coupon.dao.CouponUseableDao;

public class CouponUseableService {
	private CouponUseableDao couponUseableDao;

	public CouponUseableService() {
		super();
		
		couponUseableDao = new CouponUseableDao();
	}
	
}
