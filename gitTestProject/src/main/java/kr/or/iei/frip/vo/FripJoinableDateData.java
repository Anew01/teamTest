package kr.or.iei.frip.vo;

public class FripJoinableDateData {
	private int result;
	private FripJoinableDate joinableDate;
	
	public FripJoinableDateData() {
		super();
	}
	public FripJoinableDateData(int result, FripJoinableDate joinableDate) {
		super();
		this.result = result;
		this.joinableDate = joinableDate;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public FripJoinableDate getJoinableDate() {
		return joinableDate;
	}
	public void setJoinableDate(FripJoinableDate joinableDate) {
		this.joinableDate = joinableDate;
	}
}
