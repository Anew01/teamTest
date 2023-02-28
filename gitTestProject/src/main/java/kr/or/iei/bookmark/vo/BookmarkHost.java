package kr.or.iei.bookmark.vo;

public class BookmarkHost {
	private int bookmarkHostNo;
	private String memberId;
	private String hostId;
	public BookmarkHost() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookmarkHost(int bookmarkHostNo, String memberId, String hostId) {
		super();
		this.bookmarkHostNo = bookmarkHostNo;
		this.memberId = memberId;
		this.hostId = hostId;
	}
	public int getBookmarkHostNo() {
		return bookmarkHostNo;
	}
	public void setBookmarkHostNo(int bookmarkHostNo) {
		this.bookmarkHostNo = bookmarkHostNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getHostId() {
		return hostId;
	}
	public void setHostId(String hostId) {
		this.hostId = hostId;
	}
	
	
	
}
