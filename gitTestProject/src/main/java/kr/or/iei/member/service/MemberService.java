package kr.or.iei.member.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import kr.or.iei.member.dao.MemberDao;
import kr.or.iei.member.vo.Member;
import kr.or.iei.member.vo.PaymentList;
import kr.or.iei.member.vo.ReviewList;

public class MemberService {
	private MemberDao dao;

	public MemberService() {
		super();

		dao = new MemberDao();
	}

	public ArrayList<Member> selectAllMember() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Member> list = dao.selectAllMember(conn);
		JDBCTemplate.close(conn);
		return list;
	}

	public int insertMember(Member m) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.insertMember(conn,m);
		if(result>0) {
			JDBCTemplate.commit(conn);;
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public Member selectOneMember(Member m) {
		Connection conn = JDBCTemplate.getConnection();
		Member member = dao.selectOneMember(conn,m);
		JDBCTemplate.close(conn);
		return member;
	}

	public Member selectOneMember(String memberId) {
		Connection conn = JDBCTemplate.getConnection();
		Member m = dao.selectOneMember(conn, memberId);
		JDBCTemplate.close(conn);
		return m;
	}


	public int updateMember(Member member) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.updateMember(conn,member);
		if(result>0) {
			JDBCTemplate.commit(conn);;
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int updateDeleteMember(String memberId) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.updateDeleteMember(conn,memberId);
		if(result>0) {
			JDBCTemplate.commit(conn);;
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int updateHostMember(String memberId) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.updateHostMember(conn,memberId);
		if(result>0) {
			JDBCTemplate.commit(conn);;
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int updateMemberPw(Member member) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.updateMemberPw(conn,member);
		if(result>0) {
			JDBCTemplate.commit(conn);;
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	public Member selectOneMemberByJoin(int fripNo) {
		Connection conn = JDBCTemplate.getConnection();
		Member m = dao.selectOneMemberByJoin(conn, fripNo);
		JDBCTemplate.close(conn);
		return m;
	}

	public  ArrayList<PaymentList> selectMemberPayment(int memberNo) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<PaymentList> list = dao.selectMemberPayment(conn, memberNo);
		JDBCTemplate.close(conn);
		return list;
	}

	public ArrayList<ReviewList> selectMemberReview(String memberId) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<ReviewList> list = dao.selectMemberReview(conn, memberId);
		JDBCTemplate.close(conn);
		return list;
	}

}
