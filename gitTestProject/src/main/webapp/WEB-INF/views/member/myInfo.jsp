
<%@page import="kr.or.iei.member.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
Member member = (Member) request.getAttribute("m");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/member/myinfo.css">
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header_mypage.jsp"%>
	<div class="page-content">
		<div class="join-wrap">
			<div class="join-header">
				<h1>내 정보</h1>
			</div>
			<hr>
			<div class="join-content">
				<form action="/updateMyInfo.do" method="post" autocomplete="off">
					<div class="inputs-wrap">
						<div class="profile-wrap">
							<div class="profile-image">
								<a href='#'><img src="img/iconmonstr-user-20-240.png"
									width="100px"></a>
							</div>
						</div>
						<div class="join-input-wrap">
							<div>
								<label for="memberId">이메일</label>
							</div>
							<div>
								<input type="text" name="memberId" id="memberId"
									value="<%=member.getMemberId()%>" readonly>

							</div>
						</div>
						<div class="join-input-wrap">
							<div>
								<label for="memberPw">비밀번호</label>
							</div>
							<div>
								<input type="password" name="memberPw" id="memberPw"
									value="<%=member.getMemberPw()%>">
							</div>
						</div>
						<div class="join-input-wrap">
							<div>
								<label for="pwre">비밀번호 확인</label>
							</div>
							<div>
								<input type="password" name="pwre" id="pwre">
							</div>
						</div>
						<div class="join-input-wrap">
							<div>
								<label for="memberName">이름</label>
							</div>
							<div>
								<input type="text" name="memberName" id="memberName"
									value="<%=member.getMemberName()%>">
							</div>
						</div>
						<div class="join-input-wrap">
							<div>
								<label for="memberPhone">전화번호</label>
							</div>
							<div>
								<input type="text" name="memberPhone" id="memberPhone"
									value="<%=member.getMemberPhone()%>">
							</div>
						</div>
						<!-- 
                    <div class="join-input-wrap">
                        <div>
                            <label>성별</label>
                        </div>
                        <div>
                            <input type="radio" name="gender" id="m" value="m">
                            <label for="m">남자</label>
                            <input type="radio" name="gender" id="f" value="f">
                            <label for="f">여자</label>
                        </div>
                    </div>
                     -->
						<div class="join-input-wrap">
							<div>
								<label for="memberAddr">주소</label>
							</div>
							<div>
								<input type="text" name="memberAddr" id="memberAddr"
									value="<%=member.getMemberAddr()%>">
								<button type="button" class="addr-btn">주소검색</button>
							</div>
							<div>
								<input type="text" name="memberAddrDetail" id="memberAddrDetail">

							</div>
						</div>
					</div>
					<div class="join-btn-wrap">
						<input type="submit" value="수정하기"> <a
							href="/updateDeleteMember.do?memberId="<%=loginMember.getMemberId()%>">
							<input type="button" value="탈퇴하기" id="deleteMemberBtn" onclick="func1();">
						</a>
					</div>
				</form>
			</div>
		</div>
		<script>
			function func1() {
				confirm("회원탈퇴를 진행하시겠습니까?");
			}
		</script>
	</div>
	<%@ include file="/WEB-INF/views/common/footer.jsp"%>
</body>
</html>