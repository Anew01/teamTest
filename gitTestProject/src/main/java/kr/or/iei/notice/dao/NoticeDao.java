package kr.or.iei.notice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

	public int selectNoticeCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		int totalCount = 0;
		String query = "SELECT COUNT(*) as cnt FROM NOTICE_TBL";

		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				totalCount = rset.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}

		return totalCount;
	}

	public ArrayList<Notice> selectNoticeList(Connection conn, int start, int end) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		ArrayList<Notice> list = new ArrayList<>();

		String query = "SELECT * FROM(SELECT ROWNUM AS rnum, n.* from(SELECT NOTICE_NO, NOTICE_TITLE, NOTICE_CONTENT, NOTICE_WRITER, ENROLL_DATE FROM NOTICE_TBL ORDER BY 1 DESC)n) WHERE rnum BETWEEN ? and ?";

		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, start);
			pstmt.setInt(2, end);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				Notice notice = new Notice();

				notice.setNoticeNo(rset.getInt("NOTICE_NO"));
				notice.setNoticeTitle(rset.getString("NOTICE_TITLE"));
				notice.setNoticeContent(rset.getString("NOTICE_CONTENT"));
				notice.setNoticeWriter(rset.getString("NOTICE_WRITER"));
				notice.setEnrollDate(rset.getString("ENROLL_DATE"));

				list.add(notice);

				System.out.println(notice.getNoticeContent());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}

		return list;
	}

	public Notice selectOneNotice(Connection connection, int noticeNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		Notice notice = null;
		String query = "SELECT * FROM NOTICE_TBL WHERE NOTICE_NO = ?";

		try {
			pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, noticeNo);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				notice = new Notice();

				notice.setNoticeNo(rset.getInt("NOTICE_NO"));
				notice.setNoticeTitle(rset.getString("NOTICE_TITLE"));
				notice.setNoticeContent(rset.getString("NOTICE_CONTENT"));
				notice.setNoticeCategory(rset.getString("NOTICE_CATEGORY"));
				notice.setNoticeWriter(rset.getString("NOTICE_WRITER"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return notice;
	}

	public int updateNotice(Connection connection, Notice notice) {
		PreparedStatement pstmt = null;

		int result = 0;

		String query = "UPDATE NOTICE_TBL SET NOTICE_TITLE = ?, NOTICE_CONTENT = ?, NOTICE_CATEGORY = ?, NOTICE_WRITER = ? WHERE NOTICE_NO = ?";

		try {
			pstmt = connection.prepareStatement(query);

			pstmt.setString(1, notice.getNoticeTitle());
			pstmt.setString(2, notice.getNoticeContent());
			pstmt.setString(3, notice.getNoticeCategory());
			pstmt.setString(4, notice.getNoticeWriter());
			pstmt.setInt(5, notice.getNoticeNo());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}

		return result;
	}

}
