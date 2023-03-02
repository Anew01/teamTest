package kr.or.iei.frip.vo;

public class FripJoinableDate {
	private String fripNo;
	private String startDate;
	private String endDate;
	private int maxCount;	
	
	public FripJoinableDate() {
		super();
	}
	public FripJoinableDate(String fripNo, String startDate, String endDate, int maxCount, String joinableTime) {
		super();
		this.fripNo = fripNo;
		this.startDate = startDate;
		this.endDate = endDate;
		this.maxCount = maxCount;
	}
	
	public String getFripNo() {
		return fripNo;
	}

	public void setFripNo(String fripNo) {
		this.fripNo = fripNo;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public int getMaxCount() {
		return maxCount;
	}
	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
	}
}
