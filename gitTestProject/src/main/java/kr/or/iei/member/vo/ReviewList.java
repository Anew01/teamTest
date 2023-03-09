package kr.or.iei.member.vo;
import java.util.ArrayList;

public class ReviewList {
	private int start;
	private String fripTitle;
	private String writeDate;
	private int fripNo;
	private String reviewMemberId;
	public ReviewList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReviewList(String fripTitle, String writeDate, int fripNo, String reviewMemberId) {
		super();
		
		this.fripTitle = fripTitle;
		this.writeDate = writeDate;
		this.fripNo = fripNo;
		this.reviewMemberId = reviewMemberId;
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
	public int getFripNo() {
		return fripNo;
	}
	public void setFripNo(int fripNo) {
		this.fripNo = fripNo;
	}
	public String getReviewMemberId() {
		return reviewMemberId;
	}
	public void setReviewMemberId(String reviewMemberId) {
		this.reviewMemberId = reviewMemberId;
	}
	
	
	
}
