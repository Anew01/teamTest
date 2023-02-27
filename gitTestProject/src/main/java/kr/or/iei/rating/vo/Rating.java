package kr.or.iei.rating.vo;

public class Rating {
	private int ratingNo;
	private int feedNo;
	private int rating;
	public Rating() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Rating(int ratingNo, int feedNo, int rating) {
		super();
		this.ratingNo = ratingNo;
		this.feedNo = feedNo;
		this.rating = rating;
	}
	public int getRatingNo() {
		return ratingNo;
	}
	public void setRatingNo(int ratingNo) {
		this.ratingNo = ratingNo;
	}
	public int getFeedNo() {
		return feedNo;
	}
	public void setFeedNo(int feedNo) {
		this.feedNo = feedNo;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
}
