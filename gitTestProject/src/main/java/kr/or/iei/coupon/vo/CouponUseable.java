package kr.or.iei.coupon.vo;

public class CouponUseable {
	private int couponUseableNo;
	private String isUsed;
	private int memberNo;
	private int couponNo;
	
	public CouponUseable() {
		super();
		
	}
	
	public CouponUseable(int couponUseableNo, String isUsed, int memberNo, int couponNo) {
		super();
		this.couponUseableNo = couponUseableNo;
		this.isUsed = isUsed;
		this.memberNo = memberNo;
		this.couponNo = couponNo;
	}
	
	public int getCouponUseableNo() {
		return couponUseableNo;
	}
	
	public void setCouponUseableNo(int couponUseableNo) {
		this.couponUseableNo = couponUseableNo;
	}
	
	public String getIsUsed() {
		return isUsed;
	}
	
	public void setIsUsed(String isUsed) {
		this.isUsed = isUsed;
	}
	
	public int getMemberNo() {
		return memberNo;
	}
	
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	
	public int getCouponNo() {
		return couponNo;
	}
	
	public void setCouponNo(int couponNo) {
		this.couponNo = couponNo;
	}
	
	
}
