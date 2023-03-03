<%@page import="kr.or.iei.frip.vo.Frip"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	Frip f = (Frip)request.getAttribute("f");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<div class="page-content">
		<%@include file="/WEB-INF/views/frip/fripSideBar.jsp" %>
		<div class="content">
			<div class="frip-detail">
				<div class="detail-title"><%= f.getFripTitle() %></div>
			</div>
		</div>
	</div>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>