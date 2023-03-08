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
<link rel="stylesheet" href="css/fripPage/myFripList.css">
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<div class="page-content">
		<%@include file="/WEB-INF/views/frip/fripSideBar.jsp" %>
		<div class="content">
  			<div class="content-title">My Sprip List</div>
  			<div class="slide-content">
  				<% for(int i=0;i<list.size();i++) { %>
  				<% Frip f = list.get(i); %>
  				<div class="slide-box">
  				<div id="carousel-<%= i %>" class="carousel slide" data-bs-ride="true" style="width : 200px;">
					<div class="carousel-indicators">
					    <% for(int j=0;j<f.getFilePath().size();j++) { %>
					    	<% if(j == 0) { %>
							    <button type="button" data-bs-target="#carousel-<%= i %>" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
					    	<% } else { %>
							    <button type="button" data-bs-target="#carousel-<%= i %>" data-bs-slide-to="<%= j %>" aria-label="Slide <%= j + 1%>"></button>
					    	<% } %>
					    <% } %>
				  	</div>
					<div class="carousel-inner">
						<% if(f.getFilePath().size() > 0 && f.getFilePath().get(0) != null) { %>
							<% for(int j=0;j<f.getFilePath().size();j++) { %>
								<% if(j == 0) { %>
									<div class="carousel-item active" onclick="viewFrip(<%= f.getFripNo() %>)">
								    	<img src="/upload/photo/<%= f.getFilePath().get(j) %>" class="d-block w-100" alt="...">
								    </div>
								<% } else { %>
								   	<div class="carousel-item" onclick="viewFrip(<%= f.getFripNo() %>)">
								    	<img src="/upload/photo/<%= f.getFilePath().get(j) %>" class="d-block w-100" alt="...">
								    </div>
								<% } %>
							<% } %>
						<% } else { %>
							<div class="carousel-item active" onclick="viewFrip(<%= f.getFripNo() %>)">
								<img src="/upload/photo/no-photo.png" class="d-block w-100" alt="...">
							</div>
						<% } %>
					</div>
					<button class="carousel-control-prev" type="button" data-bs-target="#carousel-<%= i %>" data-bs-slide="prev">
					    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
					    <span class="visually-hidden">Previous</span>
					</button>
					<button class="carousel-control-next" type="button" data-bs-target="#carousel-<%= i %>" data-bs-slide="next">
					    <span class="carousel-control-next-icon" aria-hidden="true"></span>
					    <span class="visually-hidden">Next</span>
					</button>
				</div>
				<div class="slide-title"><%= f.getFripTitle() %></div>
  				</div>
				<% } %>
  			</div>
		</div>
	</div>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
	<script>
		function viewFrip(fripNo){
			location.href="/viewMyFrip.do?fripNo="+fripNo;
		}
	</script>
	
</body>
</html>