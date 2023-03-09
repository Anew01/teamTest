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
<link rel="stylesheet" href="/css/member/mypage.css">
 <script src="https://t1.kakaocdn.net/kakao_js_sdk/2.1.0/kakao.min.js"
            integrity="sha384-dpu02ieKC6NUeKFoGMOKz6102CLEWi9+5RQjWSV0ikYSFFd8M3Wp2reIcquJOemx"
            crossorigin="anonymous"></script>
        <script>Kakao.init('933fdb3f5c64bf38bb66bc3494744435');</script>
</head>
<body>
<%@ include file="/WEB-INF/views/common/header_mypage.jsp" %>
 <div class="page-content">
        <div class="top">
            <div class="profile-wrap">
            <a href="/myInfo.do?memberId=<%=loginMember.getMemberId() %>">
				<div class="profile-image"><img src="/upload/member/<%=member.getMemberProfile() %>" class="profile-img" width="50px"></div>
                <div class="profile-name">
                    <div><%=loginMember.getMemberName() %></div>
                </div>
            </a>
            </div>
        </div>
        <br>
        <hr>
        <div class="sub-menu">
            <div>내 활동</div><br>
            <form action="/memberPayment.do?memberNo=<%= member.getMemberNo()%>">
            <input type="submit" value="결제내역">
            <input type="hidden" name="memberNo" id="memberNo" value="<%= member.getMemberNo()%>">
            </form>
            <form action="/memberReview.do?memberId=<%= member.getMemberId()%>">
            <div><input type="submit" value="후기">
            <input type="hidden" name="memberId" id="memberId" value="<%= member.getMemberId()%>">
            </form>
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
					<div><a href="/fripMain.do?memberId=<%= loginMember.getMemberId() %>">나의 스프립</a></div>
			<%}else{ %>
					<div><a href="/updateHostMember.do">신청하기</a></div>
			<%} %>
            </div>
        </div>
        <br>
        <hr>
        <div class="sub-menu">
            <div>고객센터</div><br>
             <div id="kakao-talk-channel-chat-button" data-channel-public-id="_RTXDxj" data-title="question"
            data-size="large" data-color="yellow" data-shape="pc" data-support-multiple-densities="true"></div>
        </div>
        <br>
    </div>
    <script>
            window.kakaoAsyncInit = function () {
                Kakao.Channel.createChatButton({
                    container: '#kakao-talk-channel-chat-button',
                });
            };

            (function (d, s, id) {
                var js, fjs = d.getElementsByTagName(s)[0];
                if (d.getElementById(id)) return;
                js = d.createElement(s); js.id = id;
                js.src = 'https://t1.kakaocdn.net/kakao_js_sdk/2.1.0/kakao.channel.min.js';
                js.integrity = 'sha384-MEvxc+j9wOPB2TZ85/N6G3bt3K1/CgHSGNSM+88GoytFuzP4C9szmANjTCNfgKep';
                js.crossOrigin = 'anonymous';
                fjs.parentNode.insertBefore(js, fjs);
            })(document, 'script', 'kakao-js-sdk');
        </script>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>