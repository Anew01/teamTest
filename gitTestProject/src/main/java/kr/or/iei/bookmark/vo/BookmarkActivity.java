package kr.or.iei.bookmark.vo;

public class BookmarkActivity {
	private int favoriteNo;
	private int fripNo;
	private int memberNo;
	public BookmarkActivity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookmarkActivity(int favoriteNo, int fripNo, int memberNo) {
		super();
		this.favoriteNo = favoriteNo;
		this.fripNo = fripNo;
		this.memberNo = memberNo;
	}
	public int getFavoriteNo() {
		return favoriteNo;
	}
	public void setFavoriteNo(int favoriteNo) {
		this.favoriteNo = favoriteNo;
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
