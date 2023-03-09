package kr.or.iei.join.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import kr.or.iei.frip.vo.FripJoinableDate;
import kr.or.iei.inquiry.vo.Inquiry;
import kr.or.iei.join.vo.JoinFrip;
import oracle.net.aso.i;

public class JoinFripDao {

	public JoinFrip selectCount(Connection conn, String date, int fripNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		JoinFrip j = null;
		String query = "SELECT b.max_count AS maxCount\r\n"
				+ "     , (SELECT COUNT(*) FROM PAYMENT_TBL WHERE FRIP_NO = A.FRIP_NO AND PAYMENT_DATE = ?) AS useCount\r\n"
				+ "FROM FRIP_TBL A \r\n"
				+ "INNER JOIN FRIP_JOINABLE_DATE B ON A.FRIP_NO = B.FRIP_NO\r\n"
				+ "WHERE A.FRIP_NO = ? \r\n"
				+ "AND B.START_DATE <= ? \r\n"
				+ "AND B.END_DATE >= ? ";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, date);
			pstmt.setInt(2, fripNo);
			pstmt.setString(3, date);
			pstmt.setString(4, date);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				j = new JoinFrip();
				j.setMaxCnt(rset.getString("maxCount"));
				j.setUseCnt(rset.getString("useCount"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return j;
	}

	public ArrayList<JoinFrip> selectFripByDate(Connection conn, FripJoinableDate joinableDate) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<JoinFrip> list = new ArrayList<>();
		JoinFrip jf = null;
		String query = "select * from join_frip where frip_no=? and to_date(join_date,'YYYY-MM-DD') between to_date(?,'YYYY-MM-DD') and to_date(?,'YYYY-MM-DD')";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(joinableDate.getFripNo()));
			pstmt.setString(2, joinableDate.getStartDate());
			pstmt.setString(3, joinableDate.getEndDate());
			rset = pstmt.executeQuery();
			while(rset.next()) {
				jf = new JoinFrip();
				jf.setJoinFripNo(rset.getInt("join_frip_no"));
				jf.setMemberNo(rset.getInt("member_no"));
				jf.setFripNo(rset.getInt("frip_no"));
				jf.setJoinableDateNo(rset.getInt("joinable_date_no"));
				jf.setPaymentNo(rset.getInt("payment_no"));
				jf.setJoinCount(rset.getInt("join_count"));
				jf.setJoinDate(rset.getString("join_date"));
				list.add(jf);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public int inquiryInsert(Connection conn, Inquiry i) {
		PreparedStatement pstmt = null;
		int result= 0;
		String query = "insert into frip_inquiry values(frip_inquiry_seq.nextval,?,?,?,null,to_char(sysdate, 'yyyy-mm-dd'))";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, i.getFripNo());
			pstmt.setString(2, i.getInquiryWriter());
			pstmt.setString(3, i.getInquiryContent());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	
		
		



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
