package kr.or.iei.fripCategory.vo;

public class FripCategory {
	private int categoryNo;
	private int fripNo;
	private String categoryName;
	public FripCategory() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FripCategory(int categoryNo, int fripNo, String categoryName) {
		super();
		this.categoryNo = categoryNo;
		this.fripNo = fripNo;
		this.categoryName = categoryName;
	}
	public int getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}
	public int getFripNo() {
		return fripNo;
	}
	public void setFripNo(int fripNo) {
		this.fripNo = fripNo;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}
