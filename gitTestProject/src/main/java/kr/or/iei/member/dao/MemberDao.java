package kr.or.iei.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.function.Predicate;

import common.JDBCTemplate;
import kr.or.iei.member.vo.Member;

public class MemberDao {

	public ArrayList<Member> selectAllMember(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Member> list = new ArrayList<>();
		String query = "SELECT * FROM MEMBER_TBL";
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Member m = new Member();
				m.setMemberNo(rset.getInt("member_no"));
				m.setMemberId(rset.getString("member_id"));
				m.setMemberPw(rset.getString("member_pw"));
				m.setMemberName(rset.getString("member_name"));
				m.setMemberAddr(rset.getString("member_addr"));
				m.setMemberPhone(rset.getString("member_phone"));
				m.setMemberGender(rset.getString("member_gender"));
				m.setMemberLevel(rset.getInt("member_level"));
				m.setMemberProfile(rset.getString("member_profile"));
				m.setEnrollDate(rset.getString("enroll_date"));
				m.setMemberIntro(rset.getString("member_intro"));
				list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public int insertMember(Connection conn, Member m) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into member_tbl values(member_no_seq.nextval,?,?,?,?,?,?,3,?,to_char(sysdate,'yyyy-mm-dd'),?,?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m.getMemberId());
			pstmt.setString(2, m.getMemberPw());
			pstmt.setString(3, m.getMemberName());
			pstmt.setString(4, m.getMemberAddr());
			pstmt.setString(5, m.getMemberPhone());
			pstmt.setString(6, m.getMemberGender());
			pstmt.setString(7, m.getMemberProfile());
			pstmt.setString(8, m.getMemberIntro());
			pstmt.setString(9, m.getMemberAddrDetail());
			
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public Member selectOneMember(Connection conn, Member m) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member member = null;
		String query = "select * from member_tbl where member_id=? and member_pw=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m.getMemberId());
			pstmt.setString(2, m.getMemberPw());
			rset = pstmt.executeQuery();
			if(rset.next()) {
				member = new Member();
				member.setEnrollDate(rset.getString("enroll_date"));
				member.setMemberAddr(rset.getString("member_addr"));
				member.setMemberId(rset.getString("member_id"));
				member.setMemberLevel(rset.getInt("member_level"));
				member.setMemberName(rset.getString("member_name"));
				member.setMemberNo(rset.getInt("member_no"));
				member.setMemberPhone(rset.getString("member_phone"));
				member.setMemberPw(rset.getString("member_pw"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return member;
	}


}
