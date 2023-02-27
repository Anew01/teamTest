package kr.or.iei.member.service;

import kr.or.iei.member.dao.MemberDao;

public class MemberService {
	private MemberDao dao;

	public MemberService() {
		super();
		dao = new MemberDao();
	}
}
