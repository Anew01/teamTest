package kr.or.iei.coupon.vo;

public class Coupon {
	private int couponNo;
	private String couponName;
	private int discountPrice; 
	private int couponCount;
	private String expireDate;
	private String couponFile;
	
	public Coupon() {
		super();
		}

	public Coupon(int couponNo, String couponName, int discountPrice, int couponCount, String expireDate,
			String couponFile) {
		super();
		this.couponNo = couponNo;
		this.couponName = couponName;
		this.discountPrice = discountPrice;
		this.couponCount = couponCount;
		this.expireDate = expireDate;
		this.couponFile = couponFile;
	}

	public int getCouponNo() {
		return couponNo;
	}

	public void setCouponNo(int couponNo) {
		this.couponNo = couponNo;
	}

	public String getCouponName() {
		return couponName;
	}

	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}

	public int getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(int discountPrice) {
		this.discountPrice = discountPrice;
	}

	public int getCouponCount() {
		return couponCount;
	}

	public void setCouponCount(int couponCount) {
		this.couponCount = couponCount;
	}

	public String getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}

	public String getCouponFile() {
		return couponFile;
	}

	public void setCouponFile(String couponFile) {
		this.couponFile = couponFile;
	}
	
	
}
