package kr.or.iei.frip.vo;

public class FripJoinableDate {
	private int joinableDateNo;
	private String fripNo;
	private String startDate;
	private String endDate;
	private int maxCount;	
	
	public FripJoinableDate() {
		super();
	}
	public FripJoinableDate(int joinableDateNo, String fripNo, String startDate, String endDate, int maxCount) {
		super();
		this.joinableDateNo = joinableDateNo;
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
	public int getJoinableDateNo() {
		return joinableDateNo;
	}
	public void setJoinableDateNo(int joinableDateNo) {
		this.joinableDateNo = joinableDateNo;
	}
}
