package kr.or.iei.member.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.StringTokenizer;

import common.JDBCTemplate;
import kr.or.iei.member.dao.MemberDao;
import kr.or.iei.member.vo.Member;
import kr.or.iei.member.vo.MemberPageDate;

public class MemberService {
	private MemberDao dao;

	public MemberService() {
		super();
		dao = new MemberDao();
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
}
