package kr.or.iei.inquiry.vo;

public class InquiryList {
	private int fripInquiryNo;
	private int fripNo;
	private String inquiryWriter;
	private String inquiryContent;
	private int fiNo;
	private String writeDate;
	public InquiryList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public InquiryList(int fripInquiryNo, int fripNo, String inquiryWriter, String inquiryContent, int fiNo,
			String writeDate) {
		super();
		this.fripInquiryNo = fripInquiryNo;
		this.fripNo = fripNo;
		this.inquiryWriter = inquiryWriter;
		this.inquiryContent = inquiryContent;
		this.fiNo = fiNo;
		this.writeDate = writeDate;
	}
	public int getFripInquiryNo() {
		return fripInquiryNo;
	}
	public void setFripInquiryNo(int fripInquiryNo) {
		this.fripInquiryNo = fripInquiryNo;
	}
	public int getFripNo() {
		return fripNo;
	}
	public void setFripNo(int fripNo) {
		this.fripNo = fripNo;
	}
	public String getInquiryWriter() {
		return inquiryWriter;
	}
	public void setInquiryWriter(String inquiryWriter) {
		this.inquiryWriter = inquiryWriter;
	}
	public String getInquiryContent() {
		return inquiryContent;
	}
	public void setInquiryContent(String inquiryContent) {
		this.inquiryContent = inquiryContent;
	}
	public int getFiNo() {
		return fiNo;
	}
	public void setFiNo(int fiNo) {
		this.fiNo = fiNo;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	
	

}
