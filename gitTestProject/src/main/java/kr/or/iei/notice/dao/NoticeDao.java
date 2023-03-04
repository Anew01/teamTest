package kr.or.iei.notice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import common.JDBCTemplate;
import kr.or.iei.notice.vo.Notice;

public class NoticeDao {

	public int insertNotice(Connection conn, Notice notice) {
		PreparedStatement pstmt = null;

		int result = 0;

		String query = "INSERT INTO NOTICE_TBL VALUES(NOTICE_TBL_SEQ.NEXTVAL, ?, ?, ?, TO_CHAR(SYSDATE, 'YYYY-MM-DD'), ?)";

		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, notice.getNoticeTitle());
			pstmt.setString(2, notice.getNoticeContent());
			pstmt.setString(3, notice.getNoticeCategory());
			pstmt.setString(4, notice.getNoticeWriter());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}

		return result;
	}

}
