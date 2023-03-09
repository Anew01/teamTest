package kr.or.iei.inquiry.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import kr.or.iei.inquiry.vo.Inquiry;
import kr.or.iei.inquiry.vo.InquiryList;

public class InquiryDao {

	public ArrayList<InquiryList> allInquiryList(Connection conn, int fripNo) {
		PreparedStatement pstmt = null; 
		ResultSet rset = null; 
		ArrayList<InquiryList> list = new ArrayList<>();
		String query = "select * from frip_inquiry where frip_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, fripNo);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				InquiryList i = new InquiryList();
				i.setFiNo(rset.getInt("fi_no"));
				i.setFripInquiryNo(rset.getInt("frip_inquiry_no"));
				i.setFripNo(rset.getInt("frip_no"));
				i.setInquiryContent(rset.getString("inquiry_content"));
				i.setInquiryWriter(rset.getString("inquiry_writer"));
				i.setWriteDate(rset.getString("write_date"));
				list.add(i);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return list;
	}
	

}
