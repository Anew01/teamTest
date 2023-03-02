package kr.or.iei.member.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.StringTokenizer;

import common.JDBCTemplate;
import kr.or.iei.member.dao.MemberDao;
import kr.or.iei.member.vo.Member;

public class MemberService {
	private MemberDao dao;

	public MemberService() {
		super();
		dao = new MemberDao();
	}

	public ArrayList<Member> selectAllMember() {
		Connection connection = JDBCTemplate.getConnection();

		ArrayList<Member> list = dao.selectAllMember(connection);

		JDBCTemplate.close(connection);

		return list;
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
