package kr.or.iei.member.vo;

import java.util.ArrayList;

public class PaymentList {
	ArrayList<PaymentList> list = new ArrayList<PaymentList>();
	private int start;
	private String fripTitle;
	private int totalPrice;
	private String writeDate;
	
	public PaymentList() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	


	public PaymentList(String fripTitle, int totalPrice, String writeDate) {
		super();
		this.fripTitle = fripTitle;
		this.totalPrice = totalPrice;
		this.writeDate = writeDate;
	}



	public ArrayList<PaymentList> getList() {
		return list;
	}
	public void setList(ArrayList<PaymentList> list) {
		this.list = list;
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

	
}
