package kr.or.iei.member.vo;

import java.util.ArrayList;

public class PaymentList {
	private int start;
	private String fripTitle;
	private int totalPrice;
	private String writeDate;
	private int fripNo;
	private int payMemberNo;
	
	public PaymentList() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	


	public PaymentList(int fripNo, int payMemberNo ,String fripTitle, int totalPrice, String writeDate) {
		super();
		this.fripNo = fripNo;
		this.payMemberNo = payMemberNo;
		this.fripTitle = fripTitle;
		this.totalPrice = totalPrice;
		this.writeDate = writeDate;
	}


	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}

	public String getFripTitle() {
		return fripTitle;
	}

	public void setFripTitle(String fripTitle) {
		this.fripTitle = fripTitle;
	}

	
	public String getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}



	public int getTotalPrice() {
		return totalPrice;
	}



	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}




	public int getFripNo() {
		return fripNo;
	}




	public void setFripNo(int fripNo) {
		this.fripNo = fripNo;
	}




	public int getPayMemberNo() {
		return payMemberNo;
	}




	public void setPayMemberNo(int payMemberNo) {
		this.payMemberNo = payMemberNo;
	}
	
	
	
}
