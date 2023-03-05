<%@page import="kr.or.iei.member.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
		ArrayList<Member> mList = (ArrayList<Member>)request.getAttribute("mList");
    	ArrayList<Frip> fList = (ArrayList<Frip>)request.getAttribute("fList");
    	
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/mokupCss/feed.css">
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
    <%for (int i=0; i<mList.size(); i++){ %>
     	<%Member m = mList.get(i);%>
     	<%for(int j=0; j<fList.size(); j++){ %>
     	<%Frip f = fList.get(j); %>
	<div class="content-wrap">
        <div class="content-box">
            <div class="table-wrap">
                <table>
                    <tr>
                        <th rowspan="2"><img src="/headerBtnImage/마이페이지.png"></th>
                        <th class="memberId"><%=m.getMemberId() %></th>
                    </tr>
                    <tr>
                        <th class="sysdate">작성시간(피드전용servlet필요)</th>
                    </tr>
                </table>
            </div>
            <div class="content-img">
                <a href="#"><img src="/mainContentImg/컨텐츠테스트이미지.webp"></a>
            </div>
            <div class="feed-direct-btn">
                <a href="#"><%=f.getFripTitle() %></a>
            </div>
            <div class="content-info">
                <div>피드 내용 간략하게 들어가는 곳 입니다. 두줄만 나오고 더보기로 늘어남</div>
            </div>
            <div class="more-btn">
                <a href="#">더보기</a>
            </div>
	    </div>
    </div>
    	<%} %>
           	<%} %>
    <%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>