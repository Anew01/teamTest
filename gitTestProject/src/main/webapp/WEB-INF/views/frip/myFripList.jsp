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
<style>
	.page-content{
		display:flex;
	}
</style>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<div class="page-content">
		<%@include file="/WEB-INF/views/frip/fripSideBar.jsp" %>
		<div class="content">
  			<% for(Frip f : list) { %>
			<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
				<ol class="carousel-indicators">
					<% for(int i=0;i<f.getFilePath().size();i++) { %>
						<% if(i == 0) { %>
						    <li data-target="#carouselExampleIndicators" data-slide-to="<%= i %>" class="active"></li>
						<% } else { %>
							<li data-target="#carouselExampleIndicators" data-slide-to="<%= i %>"></li>
						<% } %>
					<% } %>
				</ol>
  			<div class="carousel-inner">
  					<% for(int i=0;i<f.getFilePath().size();i++) { %>
  						<% if(i == 0) { %>
		  					<div class="carousel-item active">
					      		<img class="d-block w-100" src="/upload/photo/<%=f.getFilePath().get(i) %>">
					    	</div>
  						<% } else {%>
  							<div class="carousel-item">
					      		<img class="d-block w-100" src="/upload/photo/<%=f.getFilePath().get(i) %>">
					    	</div>
  						<% } %>
  					<% } %>
  			</div>
			<a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
			    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
			    <span class="sr-only">Previous</span>
			</a>
			<a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
			    <span class="carousel-control-next-icon" aria-hidden="true"></span>
			    <span class="sr-only">Next</span>
			</a>
			</div>
  			<% } %>
		</div>
	</div>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>