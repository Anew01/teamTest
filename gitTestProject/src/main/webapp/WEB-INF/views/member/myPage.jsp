<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/member/mypage.css">
</head>
<body>
<%@ include file="/WEB-INF/views/common/header_mypage.jsp" %>
 <div class="page-content">
        <div class="top">
            <div class="profile-wrap">
            <a href="/myInfo.do?memberId=<%=loginMember.getMemberId() %>">
				<div class="profile-image"><img src="img/iconmonstr-user-20-240.png" width="50px"></div>
                <div class="profile-name">
                    <div><%=loginMember.getMemberName() %></div>
                </div>
            </a>
            </div>
        </div>
        <br>
        <div class="profile-detail">
            <div>후기<br><span>0</span></div>
            <div>피드<br><span>0</span></div>
            <div>좋아요<br><span>0</span></div>
        </div>
        <br>
        <hr>
        <div class="sub-menu">
            <div>내 활동</div><br>
            <div>결제내역</div>
        </div>
        <br>
        <hr>
        <div class="sub-menu">
            <div>고객센터</div><br>
            <div>공지사항</div>
            <div>FAQ</div>
            <div>고객센터 문의</div>
        </div>
        <br>
        <hr>
        <div class="sub-menu">
        <%if(loginMember.getMemberLevel()==1) {%>
            <div>회원관리</div><br>
            <%}else{ %>
            	<div>호스트</div><br>
            <%} %>
            <div>
           <%if(loginMember.getMemberLevel()==1) {%>
					<div><a href="/adminPage.do">회원관리</a></div>
			<%} else if(loginMember.getMemberLevel()==2) {%>
					<div><a href="/fripMain.do">나의 스프립</a></div>
			<%}else{ %>
					<div><a href="/updateHostMember.do">신청하기</a></div>
			<%} %>
            </div>
        </div>
        <br>
        <hr>
        <div class="sub-menu">
            <div>설정</div><br>
            <div>설정</div>
            <div>약관 및 정책</div>
        </div>
    </div>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>