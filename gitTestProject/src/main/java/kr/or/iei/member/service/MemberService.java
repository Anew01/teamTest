package kr.or.iei.member.service;

import java.sql.Connection;
import java.util.ArrayList;

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

	public int chageLevel(int memberNo, int memberLevel) {
		return 0;
	}
}
