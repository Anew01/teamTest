package kr.or.iei.frip.vo;

public class FripJoinableDate {
	private String fripNo;
	private String joinableDate;
	private int maxCount;
	private String joinableTime;
	
	
	public FripJoinableDate() {
		super();
	}
	public FripJoinableDate(String fripNo, String joinableDate, int maxCount, String joinableTime) {
		super();
		this.fripNo = fripNo;
		this.joinableDate = joinableDate;
		this.maxCount = maxCount;
		this.joinableTime = joinableTime;
	}

	public String getFripNo() {
		return fripNo;
	}

	public void setFripNo(String fripNo) {
		this.fripNo = fripNo;
	}

	public String getJoinableDate() {
		return joinableDate;
	}

	public void setJoinableDate(String joinableDate) {
		this.joinableDate = joinableDate;
	}

	public int getMaxCount() {
		return maxCount;
	}

	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
	}

	public String getJoinableTime() {
		return joinableTime;
	}

	public void setJoinableTime(String joinableTime) {
		this.joinableTime = joinableTime;
	}
}
