package kr.or.iei.member.vo;

public class Member {
	private int memberNo;
	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberPhone;
	private String memberAddr;
	private String memberAddrDetail;
	private String memberGender;
	private int memberLevel;
	private String memberProfile;
	private String memberOldProfile;
	private int memberLike;
	private String enrollDate;
	private String memberIntro;

	public Member() {
		super();
	}
	

	public Member(int memberNo, String memberId, int memberLevel) {
		super();
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.memberLevel = memberLevel;
	}
	
	public Member(String memberId,String memberPw ) {
		super();
		
		this.memberId = memberId;
		this.memberPw = memberPw;
		
	}


	public Member(String memberId, String memberPw, String memberName, String memberPhone, String memberAddr,
			String memberAddrDetail, String memberProfile, String memberOldProfile) {
		super();
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberPhone = memberPhone;
		this.memberAddr = memberAddr;
		this.memberAddrDetail = memberAddrDetail;
		this.memberProfile = memberProfile;
		this.memberOldProfile = memberOldProfile;
	}


	public Member(int memberNo, String memberId, String memberPw, String memberName, String memberPhone,
			String memberAddr, String memberAddrDetail, String memberGender, int memberLevel, String memberProfile, int memberLike,
			String enrollDate, String memberIntro) {
		super();
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberPhone = memberPhone;
		this.memberAddr = memberAddr;
		this.memberAddrDetail = memberAddrDetail;
		this.memberGender = memberGender;
		this.memberLevel = memberLevel;
		this.memberProfile = memberProfile;
		this.memberLike = memberLike;
		this.enrollDate = enrollDate;
		this.memberIntro = memberIntro;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public String getMemberAddr() {
		return memberAddr;
	}

	public void setMemberAddr(String memberAddr) {
		this.memberAddr = memberAddr;
	}

	public String getMemberAddrDetail() {
		return memberAddrDetail;
	}

	public void setMemberAddrDetail(String memberAddrDetail) {
		this.memberAddrDetail = memberAddrDetail;
	}

	public String getMemberGender() {
		return memberGender;
	}

	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}

	public int getMemberLevel() {
		return memberLevel;
	}

	public void setMemberLevel(int memberLevel) {
		this.memberLevel = memberLevel;
	}

	public String getMemberProfile() {
		return memberProfile;
	}

	public void setMemberProfile(String memberProfile) {
		this.memberProfile = memberProfile;
	}
	public String getMemberOldProfile() {
		return memberOldProfile;
	}

	public void setMemberOldProfile(String memberOldProfile) {
		this.memberOldProfile = memberOldProfile;
	}


	public int getMemberLike() {
		return memberLike;
	}

	public void setMemberLike(int memberLike) {
		this.memberLike = memberLike;
	}

	public String getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getMemberIntro() {
		return memberIntro;
	}

	public void setMemberIntro(String memberIntro) {
		this.memberIntro = memberIntro;
	}

}
