package kr.or.iei.feed.vo;

public class Feed {
	private int feedNo;
	private String feedWriter;
	private int fripNo;
	private String FeedContent;
	private String filename;
	private String filepath;
	private int fdNo;
	private String writeDate;
	public Feed() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Feed(int feedNo, String feedWriter, int fripNo, String feedContent, String filename, String filepath,
			int fdNo, String writeDate) {
		super();
		this.feedNo = feedNo;
		this.feedWriter = feedWriter;
		this.fripNo = fripNo;
		FeedContent = feedContent;
		this.filename = filename;
		this.filepath = filepath;
		this.fdNo = fdNo;
		this.writeDate = writeDate;
	}
	public int getFeedNo() {
		return feedNo;
	}
	public void setFeedNo(int feedNo) {
		this.feedNo = feedNo;
	}
	public String getFeedWriter() {
		return feedWriter;
	}
	public void setFeedWriter(String feedWriter) {
		this.feedWriter = feedWriter;
	}
	public int getFripNo() {
		return fripNo;
	}
	public void setFripNo(int fripNo) {
		this.fripNo = fripNo;
	}
	public String getFeedContent() {
		return FeedContent;
	}
	public void setFeedContent(String feedContent) {
		FeedContent = feedContent;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public int getFdNo() {
		return fdNo;
	}
	public void setFdNo(int fdNo) {
		this.fdNo = fdNo;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
}
