<%@page import="kr.or.iei.feed.vo.Feed"%>
<%@page import="kr.or.iei.member.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
		ArrayList<Member> memberList = (ArrayList<Member>)request.getAttribute("memberList");
    	ArrayList<Frip> fripList = (ArrayList<Frip>)request.getAttribute("fripList");
    	ArrayList<Feed> feedList = (ArrayList<Feed>)request.getAttribute("feedList");
    	Frip f = (Frip) request.getAttribute("f");
    %>
    <!-- 
    	필요한 값
    	개인 프로필 : memberProfile > member_tbl > 피드를 작성한 회원의 프로필사진
    	피드 작성자 : feedWriter > feed_tbl > 피드를 작성한 회원의 feed_writer : member_tbl(memberId)
    	프립 이미지 : fripFilePath > frip_tbl > 해당피드를 작성한 프립의 이미지
    	프립 타이틀 : fripTitle > frip_tbl > 해당 프립의 이름 a태그로 해당 프립의 상세페이지로 이동
    	피드 내용  : feed_content > feed_tbl > ㅇㅇ
     -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/mokupCss/feed.css">
<style>
	.feed-box{
		border : 1px solid black;
	}
</style>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<%for(int i=0; i<feedList.size(); i++){ %>
	<%Feed feed = feedList.get(i); %>
	<div class="feed-box">
	<h6>작성자 : <%=feed.getFeedWriter() %></h6>
	<h6>피드내용: <%=feed.getFeedContent()%></h6>
	</div>
	<%} %>
	
	<%--
		<%if(f.getFilePath().size() != 0) {%>
			<img src="/upload/photo/<%=f.getFilePath().get(0)%>">
		<%} else { %>
			<img src="/upload/photo/no-photo.png">
		<%} %>
		 --%>
    <%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>
<!-- 	<a href="insertFeedFrm.do">피드작성하기</a> -->
<!-- 	<div class="content-wrap"> -->
<!--         <div class="content-box"> -->
<%-- 	<%for(int i=0; i<feedList.size(); i++){ %> --%>
<%-- 	<%Feed feed = feedList.get(i);%> --%>
<%--     <%Member m = mList.get(i); %> --%>
<!--             <div class="table-wrap"> -->
<!--                <table> -->
<!--                    <tr> -->
<!--                        <th rowspan="2"><img src="/headerBtnImage/마이페이지.png"></th> -->
<%--                        <th class="memberId"><%=feed.getFeedWriter()%></th> --%>
<!--                    </tr> -->
<!--                    <tr> -->
<%--                        <th class="sysdate"><%=feed.getWriteDate()%></th> --%>
<!--                    </tr> -->
<!--                </table> -->
<!--            </div> -->
<!--            <div class="content-img"> -->
<%-- 			<%if(f.getFilePath().size() != 0) {%> --%>
<%--             	<img src="/upload/photo/<%=f.getFilePath().get(0)%>%>" style="width: 200px; height: 200px;"> --%>
<%--             	<%}else{ %> --%>
<!--             	<img src="/upload/photo/no-photo.png" style="width: 200px; height: 200px;"> -->
<%--             	<%} %> --%>
<!--            </div> -->
<!--            <div class="feed-direct-btn"> -->
<%--                <a href="#"><%=f.getFripTitle()%></a> --%>
<!--            </div> -->
<!--            <div class="content-info"> -->
<%--                <div><%=feed.getFeedContent() %></div> --%>
<!--            </div> -->
<!--            <div class="more-btn"> -->
<!--                <a href="#">더보기</a> -->
<!--             </div> -->
<%-- 	<%} %> --%>
<!-- 	    </div> -->
<!--     </div> -->