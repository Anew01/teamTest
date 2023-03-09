package kr.or.iei.inquiry.vo;

public class Inquiry {
	private int inquiryNo;
	private String inquiryTitle;
	private String inquiryContent;
	private String inquiryCategory;
	private String inquiryEmail;
	private String enrollDate;
	private String inquiryWriter;
	private int fripNo;

	public Inquiry() {
		super();

	}
	
	

	public Inquiry(String inquiryContent, String inquiryWriter, int fripNo) {
		super();
		this.inquiryContent = inquiryContent;
		this.inquiryWriter = inquiryWriter;
		this.fripNo = fripNo;
		
	}



	public Inquiry(int inquiryNo, String inquiryTitle, String inquiryContent, String inquiryCategory,
			String inquiryEmail, String enrollDate, String inquiryWriter) {
		super();
		this.inquiryNo = inquiryNo;
		this.inquiryTitle = inquiryTitle;
		this.inquiryContent = inquiryContent;
		this.inquiryCategory = inquiryCategory;
		this.inquiryEmail = inquiryEmail;
		this.enrollDate = enrollDate;
		this.inquiryWriter = inquiryWriter;
	}

	public int getInquiryNo() {
		return inquiryNo;
	}

	public void setInquiryNo(int inquiryNo) {
		this.inquiryNo = inquiryNo;
	}

	public String getInquiryTitle() {
		return inquiryTitle;
	}

	public void setInquiryTitle(String inquiryTitle) {
		this.inquiryTitle = inquiryTitle;
	}

	public String getInquiryContent() {
		return inquiryContent;
	}

	public void setInquiryContent(String inquiryContent) {
		this.inquiryContent = inquiryContent;
	}

	public String getInquiryCategory() {
		return inquiryCategory;
	}

	public void setInquiryCategory(String inquiryCategory) {
		this.inquiryCategory = inquiryCategory;
	}

	public String getInquiryEmail() {
		return inquiryEmail;
	}

	public void setInquiryEmail(String inquiryEmail) {
		this.inquiryEmail = inquiryEmail;
	}

	public String getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getInquiryWriter() {
		return inquiryWriter;
	}

	public void setInquiryWriter(String inquiryWriter) {
		this.inquiryWriter = inquiryWriter;
	}



	public int getFripNo() {
		return fripNo;
	}

	public void setFripNo(int fripNo) {
		this.fripNo = fripNo;
	}
	
	

}
