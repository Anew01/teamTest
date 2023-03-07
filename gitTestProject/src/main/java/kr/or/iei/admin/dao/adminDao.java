package kr.or.iei.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import kr.or.iei.feed.vo.Feed;
import kr.or.iei.frip.vo.Frip;
import kr.or.iei.member.vo.Member;

public class adminDao {

	public ArrayList<Member> selectAllMember(Connection connection, int start, int end) {
		PreparedStatement preparedStatement = null;

		ResultSet resultSet = null;

		ArrayList<Member> list = new ArrayList<Member>();

		String query = "SELECT * FROM(SELECT ROWNUM AS rnum, n.* FROM (SELECT MEMBER_NO, MEMBER_ID, MEMBER_PW, MEMBER_NAME, NVL(MEMBER_ADDR, '없음') AS NVLADDR, NVL(MEMBER_PHONE, '없음') AS NVLPHONE, NVL(MEMBER_GENDER, '없음') AS NVLGENDER, MEMBER_LEVEL, ENROLL_DATE FROM MEMBER_TBL ORDER BY 1 DESC) n) WHERE rnum BETWEEN ? and ?";

		try {
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setInt(1, start);
			preparedStatement.setInt(2, end);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Member member = new Member();

				member.setMemberNo(resultSet.getInt("MEMBER_NO"));
				member.setMemberId(resultSet.getString("MEMBER_ID"));
				member.setMemberPw(resultSet.getString("MEMBER_PW"));
				member.setMemberName(resultSet.getString("MEMBER_NAME"));
				member.setMemberAddr(resultSet.getString("NVLADDR"));
				member.setMemberPhone(resultSet.getString("NVLPHONE"));
				member.setMemberGender(resultSet.getString("NVLGENDER"));
				member.setMemberLevel(resultSet.getInt("MEMBER_LEVEL"));
				member.setEnrollDate(resultSet.getString("ENROLL_DATE"));

				list.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(resultSet);
			JDBCTemplate.close(preparedStatement);
		}

		return list;
	}

	public int chageLevel(Connection connection, String memberId, int memberLevel) {
		PreparedStatement preparedStatement = null;

		int result = 0;

		String query = "UPDATE MEMBER_TBL SET MEMBER_LEVEL = ? WHERE MEMBER_ID = ?";

		try {
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setInt(1, memberLevel);
			preparedStatement.setString(2, memberId);

			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(preparedStatement);
		}

		return result;
	}

	public int deleteMember(Connection connection, String memberId) {
		PreparedStatement preparedStatement = null;

		int result = 0;

		String query = "DELETE FROM MEMBER_TBL WHERE MEMBER_ID = ?";

		try {
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, memberId);

			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(preparedStatement);
		}

		return result;
	}

	public int selectMemberCount(Connection connection) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		int totalCount = 0;

		String query = "SELECT COUNT(*) AS CNT FROM MEMBER_TBL";

		try {
			preparedStatement = connection.prepareStatement(query);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				totalCount = resultSet.getInt("CNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(resultSet);
			JDBCTemplate.close(preparedStatement);
		}

		return totalCount;
	}

	public int updateMember(Connection connection, Member member) {
		System.out.println(member.getMemberId());
		PreparedStatement pStatement = null;

		int result = 0;

		String query = "UPDATE MEMBER_TBL SET MEMBER_PW = ?, MEMBER_PHONE = ?, MEMBER_ADDR_DETAIL = ?, MEMBER_PROFILE = ?, MEMBER_INTRO = ? WHERE MEMBER_ID = ?";

		try {
			pStatement = connection.prepareStatement(query);

			pStatement.setString(1, member.getMemberPw());
			pStatement.setString(2, member.getMemberPhone());
			pStatement.setString(3, member.getMemberAddrDetail());
			pStatement.setString(4, member.getMemberProfile());
			pStatement.setString(5, member.getMemberIntro());
			pStatement.setString(6, member.getMemberId());

			result = pStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pStatement);
		}

		return result;
	}

	public ArrayList<Frip> selectAllFrip(Connection connection, int fripStart, int fripEnd) {
		PreparedStatement preparedStatement = null;

		ResultSet resultSet = null;

		ArrayList<Frip> frips = new ArrayList<Frip>();

		String query = "SELECT * FROM(SELECT ROWNUM AS rnum, n.* FROM (SELECT FRIP_NO, FRIP_WRITER, FRIP_AUTH, FRIP_TITLE, FRIP_ADDR, NVL(FRIP_LEVEL, '없음') AS NVLFRIP, FRIP_PRICE, WRITE_DATE FROM FRIP_TBL ORDER BY 1 DESC) n) WHERE rnum BETWEEN ? and ?";

		try {
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setInt(1, fripStart);
			preparedStatement.setInt(2, fripEnd);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Frip frip = new Frip();

				frip.setFripNo(resultSet.getInt("FRIP_NO"));
				frip.setFripWriter(resultSet.getString("FRIP_WRITER"));
				frip.setFripAuth(resultSet.getString("FRIP_AUTH"));
				frip.setFripTitle(resultSet.getString("FRIP_TITLE"));
				frip.setFripAddr(resultSet.getString("FRIP_ADDR"));
				frip.setFripLevel(resultSet.getString("NVLFRIP"));
				frip.setFripPrice(resultSet.getInt("FRIP_PRICE"));
				frip.setWriteDate(resultSet.getString("WRITE_DATE"));

				frips.add(frip);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(resultSet);
			JDBCTemplate.close(preparedStatement);
		}

		return frips;
	}

	public ArrayList<Feed> selectAllFeed(Connection connection, int feedStart, int feedEnd) {
		PreparedStatement preparedStatement = null;

		ResultSet resultSet = null;

		ArrayList<Feed> feeds = new ArrayList<Feed>();

		String query = "SELECT * FROM(SELECT ROWNUM AS rnum, n.* FROM (SELECT FEED_NO, FRIP_TITLE, FEED_CONTENT, FEED_WRITER, FEED_TBL.WRITE_DATE FROM FEED_TBL JOIN FRIP_TBL USING(FRIP_NO) ORDER BY 1 DESC) n) WHERE rnum BETWEEN ? and ?";

		try {
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setInt(1, feedStart);
			preparedStatement.setInt(2, feedEnd);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Feed feed = new Feed();

				feed.setFeedNo(resultSet.getInt("FEED_NO"));
				feed.setFeedWriter(resultSet.getString("FEED_WRITER"));
				feed.setWriteDate(resultSet.getString("WRITE_DATE"));
				feed.setFripTitle(resultSet.getString("FRIP_TITLE"));
				feed.setFeedContent(resultSet.getString("FEED_CONTENT"));

				feeds.add(feed);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(resultSet);
			JDBCTemplate.close(preparedStatement);
		}

		return feeds;
	}

	public int selectFripCount(Connection connection) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		int fripTotalCount = 0;

		String query = "SELECT COUNT(*) AS CNT FROM FRIP_TBL";

		try {
			preparedStatement = connection.prepareStatement(query);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				fripTotalCount = resultSet.getInt("CNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(resultSet);
			JDBCTemplate.close(preparedStatement);
		}

		return fripTotalCount;
	}

	public int selectFeedCount(Connection connection) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		int feedTotalCount = 0;

		String query = "SELECT COUNT(*) AS CNT FROM FEED_TBL";

		try {
			preparedStatement = connection.prepareStatement(query);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				feedTotalCount = resultSet.getInt("CNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(resultSet);
			JDBCTemplate.close(preparedStatement);
		}

		return feedTotalCount;
	}

	public int fripAccept(Connection connection, int fripNo) {
		PreparedStatement preparedStatement = null;

		int result = 0;

		String query = "UPDATE FRIP_TBL SET FRIP_AUTH = 1 WHERE FRIP_NO = ?";

		try {
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setInt(1, fripNo);

			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(preparedStatement);
		}

		return result;
	}

	public int fripDelete(Connection connection, int fripNo) {
		PreparedStatement preparedStatement = null;

		int result = 0;

		String query = "DELETE FROM FRIP_TBL WHERE FRIP_NO = ?";

		try {
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setInt(1, fripNo);

			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(preparedStatement);
		}

		return result;
	}

	public int feedDelte(Connection connection, int feedNo) {
		PreparedStatement preparedStatement = null;

		int result = 0;

		String query = "DELETE FROM FEED_TBL WHERE FEED_NO = ?";

		try {
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setInt(1, feedNo);

			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(preparedStatement);
		}

		return result;
	}

	public int fripCancel(Connection connection, int fripNo) {
		PreparedStatement preparedStatement = null;

		int result = 0;

		String query = "UPDATE FRIP_TBL SET FRIP_AUTH = 0 WHERE FRIP_NO = ?";

		try {
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setInt(1, fripNo);

			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(preparedStatement);
		}

		return result;
	}

}
