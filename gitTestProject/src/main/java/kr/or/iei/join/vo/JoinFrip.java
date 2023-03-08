package kr.or.iei.join.vo;

public class JoinFrip {
	private int joinFripNo;
	private int memberNo;
	private int fripNo;
	private int joinableDateNo;
	private int paymentNo;
	private int joinCount;
	private String joinDate;
	private String maxCnt;
	private String useCnt;
	
	public JoinFrip() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public JoinFrip(int joinFripNo, int memberNo, int fripNo, int joinableDateNo, int paymentNo, int joinCount,
			String joinDate, String maxCnt, String useCnt) {
		super();
		this.joinFripNo = joinFripNo;
		this.memberNo = memberNo;
		this.fripNo = fripNo;
		this.joinableDateNo = joinableDateNo;
		this.paymentNo = paymentNo;
		this.joinCount = joinCount;
		this.joinDate = joinDate;
		this.maxCnt = maxCnt;
		this.useCnt = useCnt;
	}

	public int getJoinFripNo() {
		return joinFripNo;
	}
	public void setJoinFripNo(int joinFripNo) {
		this.joinFripNo = joinFripNo;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public int getFripNo() {
		return fripNo;
	}
	public void setFripNo(int fripNo) {
		this.fripNo = fripNo;
	}
	public int getJoinableDateNo() {
		return joinableDateNo;
	}
	public void setJoinableDateNo(int joinableDateNo) {
		this.joinableDateNo = joinableDateNo;
	}
	public int getPaymentNo() {
		return paymentNo;
	}
	public void setPaymentNo(int paymentNo) {
		this.paymentNo = paymentNo;
	}
	public int getJoinCount() {
		return joinCount;
	}
	public void setJoinCount(int joinCount) {
		this.joinCount = joinCount;
	}
	public String getMaxCnt() {
		return maxCnt;
	}
	public void setMaxCnt(String maxCnt) {
		this.maxCnt = maxCnt;
	}
	public String getUseCnt() {
		return useCnt;
	}
	public void setUseCnt(String useCnt) {
		this.useCnt = useCnt;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
}
