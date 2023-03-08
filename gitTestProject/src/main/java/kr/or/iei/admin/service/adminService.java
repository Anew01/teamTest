package kr.or.iei.admin.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.StringTokenizer;

import common.JDBCTemplate;
import kr.or.iei.admin.dao.adminDao;
import kr.or.iei.admin.vo.FripAndFeedPageDate;
import kr.or.iei.admin.vo.MemberPageDate;
import kr.or.iei.feed.vo.Feed;
import kr.or.iei.frip.vo.Frip;
import kr.or.iei.member.vo.Member;

public class adminService {
	private adminDao dao;

	public adminService() {
		super();
		dao = new adminDao();
	}

	public MemberPageDate selectAllMember(int reqPage) {
		Connection connection = JDBCTemplate.getConnection();

		int numPerPage = 10;
		int end = numPerPage * reqPage;
		int start = end - numPerPage + 1;

		ArrayList<Member> list = dao.selectAllMember(connection, start, end);

		int totalCount = dao.selectMemberCount(connection);

		int totalPage = 0;

		if (totalCount % numPerPage == 0) {
			totalPage = totalCount / numPerPage;
		} else {
			totalPage = totalCount / numPerPage + 1;
		}

		int pageNaviSize = 5;
		int pageNO = ((reqPage - 1) / pageNaviSize) * pageNaviSize + 1;

		String pageNavi = "<ul class='pagination circle-style'>";

		if (pageNO != 1) { // 시작 페이지일아닐때
			// 시작 네비
			pageNavi += "<li>";
			pageNavi += "<a class='page-item' href='/allMember.do?reqPage=" + (pageNO - 1) + "'>";
			pageNavi += "<span class='material-icons'>chevron_left</span>";
			pageNavi += "</a></li>";
		}

		// 페이지 숫자 5개
		// 페이지 최조페이지 까지 for문
		for (int i = 0; i < pageNaviSize; i++) {
			if (pageNO == reqPage) { // 현재 페이지랑 현재 요청 페이지가 같을때 검은색 효과
				pageNavi += "<li>";
				pageNavi += "<a class='page-item active-page' href='/allMember.do?reqPage=" + (pageNO) + "'>";
				pageNavi += pageNO;
				pageNavi += "</a></li>";
			} else { // 아닐때
				pageNavi += "<li>";
				pageNavi += "<a class='page-item' href='/allMember.do?reqPage=" + (pageNO) + "'>";
				pageNavi += pageNO;
				pageNavi += "</a></li>";

			}
			pageNO++;

			if (pageNO > totalPage) { // 최종 페이지 나가기
				break;
			}
		}

		// 다음 버튼
		if (pageNO <= totalPage) { // 최종 페이지가 되면 다음가면 안됨
			pageNavi += "<li>";
			pageNavi += "<a class='page-item' href='/allMember.do?reqPage=" + (pageNO) + "'>";
			pageNavi += "<span class='material-icons'>chevron_right</span>";
			pageNavi += "</a></li>";
		}

		pageNavi += "</ul>";

		JDBCTemplate.close(connection);

		MemberPageDate memberPageDate = new MemberPageDate(list, pageNavi, start);

		return memberPageDate;
	}

	public int chageLevel(String memberId, int memberLevel) {
		Connection connection = JDBCTemplate.getConnection();

		int result = dao.chageLevel(connection, memberId, memberLevel);

		if (result > 0) {
			JDBCTemplate.commit(connection);
		} else {
			JDBCTemplate.rollback(connection);
		}

		JDBCTemplate.close(connection);

		return result;
	}

	public int deleteMember(String memberId) {
		Connection connection = JDBCTemplate.getConnection();

		int result = dao.deleteMember(connection, memberId);

		if (result > 0) {
			JDBCTemplate.commit(connection);
		} else {
			JDBCTemplate.rollback(connection);
		}

		JDBCTemplate.close(connection);

		return result;
	}

	public boolean checkedChangeLevel(String id, String level) {
		Connection connection = JDBCTemplate.getConnection();

		// no : 4/7 형태 level: 1/2/3 형태 처리 필요
		StringTokenizer sT1 = new StringTokenizer(id, "/");
		StringTokenizer sT2 = new StringTokenizer(level, "/");

		boolean result = true;

		while (sT1.hasMoreTokens()) {
			String memberId = sT1.nextToken();
			int memberLevel = Integer.parseInt(sT2.nextToken());

			int changeResult = dao.chageLevel(connection, memberId, memberLevel);

			if (changeResult == 0) { // 하나라도 실패하면
				result = false; // 모두 실패

				break; // 하나라도 실패하면 뒤에거 update x
			}
		}

		if (result) {
			JDBCTemplate.commit(connection);
		} else {
			JDBCTemplate.rollback(connection);
		}

		JDBCTemplate.close(connection);

		return result;
	}

	public boolean checkedWithdrawal(String id) {
		Connection connection = JDBCTemplate.getConnection();

		// no : 4/7 형태 level: 1/2/3 형태 처리 필요
		StringTokenizer sT1 = new StringTokenizer(id, "/");

		boolean result = true;

		while (sT1.hasMoreTokens()) {
			String memberId = sT1.nextToken();

			int deleteResult = dao.deleteMember(connection, memberId);

			if (deleteResult == 0) { // 하나라도 실패하면
				result = false; // 모두 실패

				break; // 하나라도 실패하면 뒤에거 update x
			}
		}

		if (result) {
			JDBCTemplate.commit(connection);
		} else {
			JDBCTemplate.rollback(connection);
		}

		JDBCTemplate.close(connection);

		return result;
	}

	public int updateMember(Member member) {
		Connection connection = JDBCTemplate.getConnection();

		int result = dao.updateMember(connection, member);

		if (result > 0) {
			JDBCTemplate.commit(connection);
		} else {
			JDBCTemplate.rollback(connection);
		}

		JDBCTemplate.close(connection);

		return result;
	}

	public FripAndFeedPageDate selectAllFripAndFeed(int fripReqPage, int feedReqPage) {
		Connection connection = JDBCTemplate.getConnection();

		int numPerPage = 10; // 10

		int fripEnd = numPerPage * fripReqPage;
		int fripStart = fripEnd - numPerPage + 1;
		int feedEnd = numPerPage * feedReqPage;
		int feedStart = feedEnd - numPerPage + 1;

		ArrayList<Frip> frips = dao.selectAllFrip(connection, fripStart, fripEnd);
		ArrayList<Feed> feeds = dao.selectAllFeed(connection, feedStart, feedEnd);

		int fripTotalCount = dao.selectFripCount(connection);
		int feedTotalCount = dao.selectFeedCount(connection);

		int fripTotalPage = 0;
		int feedTotalPage = 0;

		if (fripTotalCount % numPerPage == 0) {
			fripTotalPage = fripTotalCount / numPerPage;
		} else {
			fripTotalPage = fripTotalCount / numPerPage + 1;
		}

		if (feedTotalCount % numPerPage == 0) {
			feedTotalPage = feedTotalCount / numPerPage;
		} else {
			feedTotalPage = feedTotalCount / numPerPage + 1;
		}

		int pageNaviSize = 5;

		int fripPageNo = ((fripReqPage - 1) / pageNaviSize) * pageNaviSize + 1;
		int feedPageNo = ((feedReqPage - 1) / pageNaviSize) * pageNaviSize + 1;

		String fripPageNavi = "<ul class='pagination circle-style'>";
		String feedPageNavi = "<ul class='pagination circle-style'>";

		if (fripPageNo != 1) { // 시작 페이지일아닐때
			// 시작 네비
			fripPageNavi += "<li>";
			fripPageNavi += "<a class='page-item' href='/firpAndFeed.do?fripReqPage=" + (fripPageNo - 1)
					+ "&feedReqPage=" + feedReqPage + "'>";
			fripPageNavi += "<span class='material-icons'>chevron_left</span>";
			fripPageNavi += "</a></li>";
		}

		if (feedPageNo != 1) { // 시작 페이지일아닐때
			// 시작 네비
			feedPageNavi += "<li>";
			feedPageNavi += "<a class='page-item' href='/firpAndFeed.do?fripReqPage=" + fripReqPage + "&feedReqPage="
					+ (feedPageNo - 1) + "'>";
			feedPageNavi += "<span class='material-icons'>chevron_left</span>";
			feedPageNavi += "</a></li>";
		}

		// fripPageNation
		for (int i = 0; i < pageNaviSize; i++) {
			if (fripPageNo == fripReqPage) { // 현재 페이지랑 현재 요청 페이지가 같을때 검은색 효과
				fripPageNavi += "<li>";
				fripPageNavi += "<a class='page-item active-page' href='/firpAndFeed.do?fripReqPage=" + fripPageNo
						+ "&feedReqPage=" + feedReqPage + "'>";
				fripPageNavi += fripPageNo;
				fripPageNavi += "</a></li>";
			} else { // 아닐때
				fripPageNavi += "<li>";
				fripPageNavi += "<a class='page-item' href='/firpAndFeed.do?fripReqPage=" + fripPageNo + "&feedReqPage="
						+ feedReqPage + "'>";
				fripPageNavi += fripPageNo;
				fripPageNavi += "</a></li>";

			}

			fripPageNo++;

			if (fripPageNo > fripTotalPage) { // 최종 페이지 나가기
				break;
			}
		}

		// feedPageNoNation
		for (int i = 0; i < pageNaviSize; i++) {
			if (feedPageNo == feedReqPage) { // 현재 페이지랑 현재 요청 페이지가 같을때 검은색 효과
				feedPageNavi += "<li>";
				feedPageNavi += "<a class='page-item active-page' href='/firpAndFeed.do?fripReqPage=" + fripReqPage
						+ "&feedReqPage=" + feedPageNo + "'>";
				feedPageNavi += feedPageNo;
				feedPageNavi += "</a></li>";
			} else { // 아닐때
				feedPageNavi += "<li>";
				feedPageNavi += "<a class='page-item' href='/firpAndFeed.do?fripReqPage=" + fripReqPage
						+ "&feedReqPage=" + feedPageNo + "'>";
				feedPageNavi += feedPageNo;
				feedPageNavi += "</a></li>";

			}

			feedPageNo++;

			if (feedPageNo > feedTotalPage) { // 최종 페이지 나가기
				break;
			}
		}

		// 다음 버튼
		if (fripPageNo <= fripTotalPage) { // 최종 페이지가 되면 다음가면 안됨
			fripPageNavi += "<li>";
			fripPageNavi += "<a class='page-item' href='/firpAndFeed.do?fripReqPage=" + (fripPageNo) + "&feedReqPage="
					+ feedReqPage + "'>";
			fripPageNavi += "<span class='material-icons'>chevron_right</span>";
			fripPageNavi += "</a></li>";
			fripPageNavi += "</ul>";
		}

		// 다음 버튼
		if (feedPageNo <= feedTotalPage) { // 최종 페이지가 되면 다음가면 안됨
			feedPageNavi += "<li>";
			feedPageNavi += "<a class='page-item' href='/firpAndFeed.do?fripReqPage=" + fripReqPage + "&feedReqPage="
					+ (feedPageNo) + "'>";
			feedPageNavi += "<span class='material-icons'>chevron_right</span>";
			feedPageNavi += "</a></li>";
			feedPageNavi += "</ul>";
		}

		JDBCTemplate.close(connection);

		FripAndFeedPageDate fripAndFeedPageDate = new FripAndFeedPageDate(frips, fripPageNavi, fripStart, feeds,
				feedPageNavi, feedStart);

		return fripAndFeedPageDate;
	}

	public int fripAccept(int fripNo) {
		Connection connection = JDBCTemplate.getConnection();

		int result = dao.fripAccept(connection, fripNo);

		if (result > 0) {
			JDBCTemplate.commit(connection);
		} else {
			JDBCTemplate.rollback(connection);
		}

		JDBCTemplate.close(connection);

		return result;
	}

	public boolean checkedfripAccept(String fripNos) {
		Connection connection = JDBCTemplate.getConnection();

		// no : 4/7 형태 level: 1/2/3 형태 처리 필요
		StringTokenizer sT1 = new StringTokenizer(fripNos, "/");

		boolean result = true;

		while (sT1.hasMoreTokens()) {
			int fripNo = Integer.parseInt(sT1.nextToken());

			int changeResult = dao.fripAccept(connection, fripNo);

			if (changeResult == 0) { // 하나라도 실패하면
				result = false; // 모두 실패

				break; // 하나라도 실패하면 뒤에거 update x
			}
		}

		if (result) {
			JDBCTemplate.commit(connection);
		} else {
			JDBCTemplate.rollback(connection);
		}

		JDBCTemplate.close(connection);

		return result;
	}

	public boolean checkedfeedDelete(String feedNos) {
		Connection connection = JDBCTemplate.getConnection();

		// no : 4/7 형태 level: 1/2/3 형태 처리 필요
		StringTokenizer sT1 = new StringTokenizer(feedNos, "/");

		boolean result = true;

		while (sT1.hasMoreTokens()) {
			int feedNo = Integer.parseInt(sT1.nextToken());

			int changeResult = dao.feedDelte(connection, feedNo);

			if (changeResult == 0) { // 하나라도 실패하면
				result = false; // 모두 실패

				break; // 하나라도 실패하면 뒤에거 update x
			}
		}

		if (result) {
			JDBCTemplate.commit(connection);
		} else {
			JDBCTemplate.rollback(connection);
		}

		JDBCTemplate.close(connection);

		return result;
	}

	public int feedDelete(int feedNo) {
		Connection connection = JDBCTemplate.getConnection();

		int result = dao.feedDelte(connection, feedNo);

		if (result > 0) {
			JDBCTemplate.commit(connection);
		} else {
			JDBCTemplate.rollback(connection);
		}

		JDBCTemplate.close(connection);

		return result;
	}

	public int fripCancel(int fripNo) {
		Connection connection = JDBCTemplate.getConnection();

		int result = dao.fripCancel(connection, fripNo);

		if (result > 0) {
			JDBCTemplate.commit(connection);
		} else {
			JDBCTemplate.rollback(connection);
		}

		JDBCTemplate.close(connection);

		return result;
	}

	public boolean checkedfripCancel(String fripNos) {
		Connection connection = JDBCTemplate.getConnection();

		// no : 4/7 형태 level: 1/2/3 형태 처리 필요
		StringTokenizer sT1 = new StringTokenizer(fripNos, "/");

		boolean result = true;

		while (sT1.hasMoreTokens()) {
			int fripNo = Integer.parseInt(sT1.nextToken());

			int changeResult = dao.fripCancel(connection, fripNo);

			if (changeResult == 0) { // 하나라도 실패하면
				result = false; // 모두 실패

				break; // 하나라도 실패하면 뒤에거 update x
			}
		}

		if (result) {
			JDBCTemplate.commit(connection);
		} else {
			JDBCTemplate.rollback(connection);
		}

		JDBCTemplate.close(connection);

		return result;
	}

	public ArrayList<Member> selectSearchMember(String searchId) {
		Connection connection = JDBCTemplate.getConnection();

		ArrayList<Member> list = dao.selectSearchMember(connection, searchId);

		JDBCTemplate.close(connection);

		return list;
	}

}
