package kr.or.iei.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import kr.or.iei.member.vo.Member;

public class MemberDao {

	public ArrayList<Member> selectAllMember(Connection connection) {
		PreparedStatement preparedStatement = null;

		ResultSet resultSet = null;

		ArrayList<Member> list = new ArrayList<Member>();

		String query = "SELECT * FROM MEMBER_TBL";

		try {
			preparedStatement = connection.prepareStatement(query);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Member member = new Member();

				member.setMemberNo(resultSet.getInt("MEMBER_NO"));
				member.setMemberId(resultSet.getString("MEMBER_ID"));
				member.setMemberPw(resultSet.getString("MEMBER_PW"));
				member.setMemberName(resultSet.getString("MEMBER_NAME"));
				member.setMemberAddr(resultSet.getString("MEMBER_ADDR"));
				member.setMemberPhone(resultSet.getString("MEMBER_PHONE"));
				member.setMemberGender(resultSet.getString("MEMBER_GENDER"));
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

}
