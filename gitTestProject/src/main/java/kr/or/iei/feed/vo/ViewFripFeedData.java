package kr.or.iei.feed.vo;


public class ViewFripFeedData {
	private Feed f;
	private String memProfilepath;
	
	public ViewFripFeedData() {
		super();
	}
	public ViewFripFeedData(Feed f, String memProfilepath) {
		super();
		this.f = f;
		this.memProfilepath = memProfilepath;
	}
	public Feed getF() {
		return f;
	}
	public void setF(Feed f) {
		this.f = f;
	}
	public String getMemProfilepath() {
		return memProfilepath;
	}
	public void setMemProfilepath(String memProfilepath) {
		this.memProfilepath = memProfilepath;
	}
}
