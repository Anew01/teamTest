package kr.or.iei.frip.vo;

import java.util.ArrayList;

public class Frip {
	private int fripNo;
	private String fripWriter;
	private String fripAuth;
	private String fripTitle;
	private String fripContent;
	private String fripAddr;
	private String fripLevel;
	private String fripCategory;
	private String fripTime;
	private int maxCount;
	private int fripPrice;
	private int fripIncome;
	private String fripStatus;
	private String writeDate;
	private ArrayList<String> filePath;
	private ArrayList<FripJoinableDate> joinableDates;
	
	public Frip() {
		super();
	}
	public Frip(int fripNo, String fripWriter, String fripAuth, String fripTitle, String fripContent, String fripAddr,
			String fripLevel, String fripCategory, String fripDate, String fripTime, int maxCount, int fripPrice,
			int fripIncome, String fripStatus, String writeDate, ArrayList<String> filePath,
			ArrayList<FripJoinableDate> joinableDates) {
		super();
		this.fripNo = fripNo;
		this.fripWriter = fripWriter;
		this.fripAuth = fripAuth;
		this.fripTitle = fripTitle;
		this.fripContent = fripContent;
		this.fripAddr = fripAddr;
		this.fripLevel = fripLevel;
		this.fripCategory = fripCategory;
		this.fripTime = fripTime;
		this.maxCount = maxCount;
		this.fripPrice = fripPrice;
		this.fripIncome = fripIncome;
		this.fripStatus = fripStatus;
		this.writeDate = writeDate;
		this.filePath = filePath;
		this.joinableDates = joinableDates;
	}

	public int getFripNo() {
		return fripNo;
	}
	public void setFripNo(int fripNo) {
		this.fripNo = fripNo;
	}
	public String getFripWriter() {
		return fripWriter;
	}
	public void setFripWriter(String fripWriter) {
		this.fripWriter = fripWriter;
	}
	public String getFripAuth() {
		return fripAuth;
	}
	public void setFripAuth(String fripAuth) {
		this.fripAuth = fripAuth;
	}
	public String getFripTitle() {
		return fripTitle;
	}
	public void setFripTitle(String fripTitle) {
		this.fripTitle = fripTitle;
	}
	public String getFripContent() {
		return fripContent;
	}
	public void setFripContent(String fripContent) {
		this.fripContent = fripContent;
	}
	public String getFripAddr() {
		return fripAddr;
	}
	public void setFripAddr(String fripAddr) {
		this.fripAddr = fripAddr;
	}
	public String getFripLevel() {
		return fripLevel;
	}
	public void setFripLevel(String fripLevel) {
		this.fripLevel = fripLevel;
	}
	public int getFripPrice() {
		return fripPrice;
	}
	public void setFripPrice(int fripPrice) {
		this.fripPrice = fripPrice;
	}
	public int getFripIncome() {
		return fripIncome;
	}
	public void setFripIncome(int fripIncome) {
		this.fripIncome = fripIncome;
	}
	public String getFripStatus() {
		return fripStatus;
	}
	public void setFripStatus(String fripStatus) {
		this.fripStatus = fripStatus;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}

	public ArrayList<String> getFilePath() {
		return filePath;
	}

	public void setFilePath(ArrayList<String> filePath) {
		this.filePath = filePath;
	}

	public String getFripCategory() {
		return fripCategory;
	}

	public void setFripCategory(String fripCategory) {
		this.fripCategory = fripCategory;
	}
	public String getFripTime() {
		return fripTime;
	}

	public void setFripTime(String fripTime) {
		this.fripTime = fripTime;
	}

	public int getMaxCount() {
		return maxCount;
	}

	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
	}
	public ArrayList<FripJoinableDate> getJoinableDates() {
		return joinableDates;
	}
	public void setJoinableDates(ArrayList<FripJoinableDate> joinableDates) {
		this.joinableDates = joinableDates;
	}
}
