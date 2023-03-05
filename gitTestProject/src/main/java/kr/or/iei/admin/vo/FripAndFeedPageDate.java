package kr.or.iei.admin.vo;

import java.util.ArrayList;

import kr.or.iei.feed.vo.Feed;
import kr.or.iei.frip.vo.Frip;

public class FripAndFeedPageDate {
	private ArrayList<Frip> frips;
	private String fripPageNavi;
	private int fripStart;
	private ArrayList<Feed> feeds;
	private String feedPageNavi;
	private int feedStart;

	public FripAndFeedPageDate() {
		super();

	}

	public FripAndFeedPageDate(ArrayList<Frip> frips, String fripPageNavi, int fripStart, ArrayList<Feed> feeds,
			String feedPageNavi, int feedStart) {
		super();
		this.frips = frips;
		this.fripPageNavi = fripPageNavi;
		this.fripStart = fripStart;
		this.feeds = feeds;
		this.feedPageNavi = feedPageNavi;
		this.feedStart = feedStart;
	}

	public ArrayList<Frip> getFrips() {
		return frips;
	}

	public void setFrips(ArrayList<Frip> frips) {
		this.frips = frips;
	}

	public String getFripPageNavi() {
		return fripPageNavi;
	}

	public void setFripPageNavi(String fripPageNavi) {
		this.fripPageNavi = fripPageNavi;
	}

	public int getFripStart() {
		return fripStart;
	}

	public void setFripStart(int fripStart) {
		this.fripStart = fripStart;
	}

	public ArrayList<Feed> getFeeds() {
		return feeds;
	}

	public void setFeeds(ArrayList<Feed> feeds) {
		this.feeds = feeds;
	}

	public String getFeedPageNavi() {
		return feedPageNavi;
	}

	public void setFeedPageNavi(String feedPageNavi) {
		this.feedPageNavi = feedPageNavi;
	}

	public int getFeedStart() {
		return feedStart;
	}

	public void setFeedStart(int feedStart) {
		this.feedStart = feedStart;
	}

}
