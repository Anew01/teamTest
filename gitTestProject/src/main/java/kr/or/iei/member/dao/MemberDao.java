package kr.or.iei.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.function.Predicate;

import common.JDBCTemplate;
import kr.or.iei.member.vo.Member;
import kr.or.iei.member.vo.PaymentList;
import kr.or.iei.member.vo.ReviewList;

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
		String query = "insert into member_tbl values(member_no_seq.nextval,?,?,?,?, ?, '', 3 , '', to_char(sysdate,'yyyy-mm-dd') ,'' ,?, '' )";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m.getMemberId());
			pstmt.setString(2, m.getMemberPw());
			pstmt.setString(3, m.getMemberName());
			pstmt.setString(4, m.getMemberAddr());
			pstmt.setString(5, m.getMemberPhone());
			pstmt.setString(6, m.getMemberAddrDetail());
			
			
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
				member.setMemberNo(rset.getInt("member_no"));
				member.setMemberId(rset.getString("member_id"));
				member.setMemberPw(rset.getString("member_pw"));
				member.setMemberName(rset.getString("member_name"));
				member.setMemberPhone(rset.getString("member_phone"));
				member.setMemberAddr(rset.getString("member_addr"));
				member.setMemberAddrDetail(rset.getString("member_addr_detail"));
				member.setMemberLevel(rset.getInt("member_level"));
				member.setMemberProfile(rset.getString("member_profile"));
				member.setEnrollDate(rset.getString("enroll_date"));
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

	public Member selectOneMember(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from member_tbl where member_id=?";
		Member m = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				m = new Member();
				m.setMemberNo(rset.getInt("member_no"));
				m.setMemberId(rset.getString("member_id"));
				m.setMemberPw(rset.getString("member_pw"));
				m.setMemberName(rset.getString("member_name"));
				m.setMemberPhone(rset.getString("member_phone"));
				m.setMemberAddr(rset.getString("member_addr"));
				m.setMemberAddrDetail(rset.getString("member_addr_detail"));
				m.setMemberLevel(rset.getInt("member_level"));
				m.setMemberProfile(rset.getString("member_profile"));
				m.setEnrollDate(rset.getString("enroll_date"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return m;
	}

	public int updateMember(Connection conn, Member member) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update member_tbl set member_pw=?, member_name=?, member_phone=?, member_addr=?, member_addr_detail=?, member_profile=?, member_old_profile=? where member_id=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getMemberPw());
			pstmt.setString(2, member.getMemberName());
			pstmt.setString(3, member.getMemberPhone());
			pstmt.setString(4, member.getMemberAddr());
			pstmt.setString(5, member.getMemberAddrDetail());
			pstmt.setString(6, member.getMemberProfile());
			pstmt.setString(7, member.getMemberOldProfile());
			pstmt.setString(8, member.getMemberId());
			result = pstmt.executeUpdate();	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
		
	}

	public int updateDeleteMember(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update member_tbl set member_level=4 where member_id=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			result = pstmt.executeUpdate();	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int updateHostMember(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update member_tbl set member_level=2 where member_id=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			result = pstmt.executeUpdate();	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int updateMemberPw(Connection conn, Member member) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update member_tbl set member_pw=? where member_id=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getMemberPw());
			pstmt.setString(2, member.getMemberId());
			result = pstmt.executeUpdate();	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}


	public Member selectOneMemberByJoin(Connection conn, int fripNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member m = null;
		String query = "SELECT MEMBER_NAME FROM MEMBER_TBL LEFT JOIN FRIP_TBL ON (MEMBER_ID = FRIP_WRITER) WHERE FRIP_NO =?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, fripNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				m = new Member();
				m.setMemberName(rset.getString("member_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
			
		return m;
	}

	public ArrayList<PaymentList> selectMemberPayment(Connection conn, int MemberNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<PaymentList> list = new ArrayList<>();
		String query = "select b.frip_no, c.member_no, b.frip_title, c.total_price, c.payment_date from member_tbl a, frip_tbl b, payment_tbl c where b.FRIP_NO = c.FRIP_NO and a.member_no = c.member_no and a.member_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, MemberNo);
			rset = pstmt.executeQuery();
			PaymentList pl = new PaymentList();
			while(rset.next()) {
				pl.setFripNo(rset.getInt("frip_no"));
				pl.setPayMemberNo(MemberNo);
				pl.setFripTitle(rset.getString("frip_title"));
				pl.setTotalPrice(rset.getInt("total_price"));
				pl.setWriteDate(rset.getString("payment_date"));
				list.add(pl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public ArrayList<ReviewList> selectMemberReview(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ReviewList> list = new ArrayList<>();
		String query = "select b.frip_no, b.frip_title, c.write_date from member_tbl a , frip_tbl b , feed_tbl c  where b.frip_no = c.frip_no and a.member_id = c.feed_writer and a.member_id=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();
			ReviewList rl = new ReviewList();
			while(rset.next()) {
				rl.setFripNo(rset.getInt("frip_no"));
				rl.setReviewMemberId(memberId);
				rl.setFripTitle(rset.getString("frip_title"));
				rl.setWriteDate(rset.getString("write_date"));
				list.add(rl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}


}
