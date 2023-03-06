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
            	<% for(String filePath : f.getFilePath()) { %>
            		<img src="/upload/photo/<%=filePath%>">
            	<% } %>
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
                <%=f.getAvgRating() %>
            </div>
        </div>
		<%} %>
    </div>		
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
	
</body>
</html>