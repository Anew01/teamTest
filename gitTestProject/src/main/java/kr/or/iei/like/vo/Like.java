package kr.or.iei.like.vo;

public class Like {
	private int likeNo;
	private int fripNo;
	private int memberNo;
	public Like() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Like(int likeNo, int fripNo, int memberNo) {
		super();
		this.likeNo = likeNo;
		this.fripNo = fripNo;
		this.memberNo = memberNo;
	}
	public int getLikeNo() {
		return likeNo;
	}
	public void setLikeNo(int likeNo) {
		this.likeNo = likeNo;
	}
	public int getFripNo() {
		return fripNo;
	}
	public void setFripNo(int fripNo) {
		this.fripNo = fripNo;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	
}
