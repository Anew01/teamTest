<%@page import="kr.or.iei.feed.vo.Feed"%>
<%@page import="kr.or.iei.member.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
		ArrayList<Member> mList = (ArrayList<Member>)request.getAttribute("mList");
    	ArrayList<Frip> fList = (ArrayList<Frip>)request.getAttribute("fList");
    	ArrayList<Feed> feedList = (ArrayList<Feed>)request.getAttribute("feedList");
    	
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
	<a href="insertFeedFrm.do">피드작성하기</a>
	<%for(int i=0; i<feedList.size(); i++){ %>
	<%Feed feed = feedList.get(i);%>
	<div class="content-wrap">
        <div class="content-box">
            <div class="table-wrap">
               <table>
                   <tr>
                       <th rowspan="2"><img src="/headerBtnImage/마이페이지.png"></th>
                       <%Member m = mList.get(i); %>
                       <th class="memberId"><%=feed.getFeedWriter()%></th>
                   </tr>
                   <tr>
                       <th class="sysdate"><%=feed.getWriteDate()%></th>
                   </tr>
               </table>
           </div>
           <div class="content-img">
       		<%
       		Frip frip = fList.get(i);
       		%>
       		<%if(frip.getFilePath().size() != 0) {%>
            	<%String filePath = frip.getFilePath().get(0); %>
            	<img src="/upload/photo/<%=filePath%>" style="width: 200px; height: 200px;">
            	<%}else{ %>
            	<img src="/upload/photo/noImg.gif" style="width: 200px; height: 200px;">
            	<%} %>
           </div>
           <div class="feed-direct-btn">
               <a href="#"><%=frip.getFripTitle()%></a>
           </div>
           <div class="content-info">
               <div><%=feed.getFeedContent() %></div>
           </div>
           <div class="more-btn">
               <a href="#">더보기</a>
            </div>
	    </div>
    </div>
	<%} %>
    <%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>