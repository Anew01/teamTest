<%@page import="kr.or.iei.frip.vo.FripJoinableDate"%>
<%@page import="kr.or.iei.frip.vo.Frip"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    ArrayList<Frip> list = (ArrayList<Frip>)request.getAttribute("list");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="/css/mokupCss/Frip.css">
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	 <div class="content-wrap">
	 	<% for(Frip f : list) { %>
        <div class="frip-box">
            <div class="img-box">
            	<%if(f.getFilePath().size() != 0) {%>
            	<%String filePath = f.getFilePath().get(0); %>
            	<a href="/joinFrip.do?fripNo=<%=f.getFripNo()%>"><img src="/upload/photo/<%=filePath%>"></a>
            	<%}else{ %>
            	<a href="/joinFrip.do?fripNo=<%=f.getFripNo()%>"><img src="/upload/photo/noImg.gif"></a>
            	<%} %>
            </div>
            <div class="f-title">
                <%=f.getFripTitle() %>
            </div>
            <div class="f-addr">
              	<%=f.getFripAddr() %>
            </div>
            <%for(int q=0; q<1; q++){ %>
               <%FripJoinableDate fjd = f.getJoinableDates().get(q); %>
            <div class="j-date">
            	<%=fjd.getStartDate() %> ~ <%=fjd.getEndDate() %>
            </div>
            <%} %>
            <div class="f-price">
                <%=f.getFripPrice() %>
            </div>
            <div class="rating">
                <img src="/mainContentImg/star.png" style="width: 20px; height:20px;"> <%=f.getAvgRating() %>
            </div>
        </div>
		<%} %>
    </div>		
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>