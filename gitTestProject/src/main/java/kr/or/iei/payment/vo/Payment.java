package kr.or.iei.payment.vo;

public class Payment {
	private int paymentNo;
	private int memberNo;
	private int fripNo;
	private int discountPrice;
	private String paymentType;
	private int totalPrice;
	private int finalPrice;
	private String paymentDate;
	private String fripTitle;
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Payment(int paymentNo, int memberNo, int fripNo, int discountPrice, String paymentType, int totalPrice,
			int finalPrice) {
		super();
		this.paymentNo = paymentNo;
		this.memberNo = memberNo;
		this.fripNo = fripNo;
		this.discountPrice = discountPrice;
		this.paymentType = paymentType;
		this.totalPrice = totalPrice;
		this.finalPrice = finalPrice;
	}
	
	public Payment(int totalPrice, String paymentDate, String fripTitle) {
		super();
		this.totalPrice = totalPrice;
		this.paymentDate = paymentDate;
		this.fripTitle = fripTitle;
	}
	public int getPaymentNo() {
		return paymentNo;
	}
	public void setPaymentNo(int paymentNo) {
		this.paymentNo = paymentNo;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public int getFripNo() {
		return fripNo;
	}
	public void setFripNo(int fripNo) {
		this.fripNo = fripNo;
	}
	public int getDiscountPrice() {
		return discountPrice;
	}
	public void setDiscountPrice(int discountPrice) {
		this.discountPrice = discountPrice;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getFinalPrice() {
		return finalPrice;
	}
	public void setFinalPrice(int finalPrice) {
		this.finalPrice = finalPrice;
	}
	public String getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}
	public String getFripTitle() {
		return fripTitle;
	}
	public void setFripTitle(String fripTitle) {
		this.fripTitle = fripTitle;
	}
	
	
	
}
