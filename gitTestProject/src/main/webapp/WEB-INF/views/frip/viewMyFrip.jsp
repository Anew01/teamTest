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
<link rel="stylesheet" href="css/fripPage/viewMyFrip.css">
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<div class="page-content">
		<%@include file="/WEB-INF/views/frip/fripSideBar.jsp" %>
		<div class="content">
			<div class="frip-detail">
				<div class="detail-title"><%= f.getFripTitle() %></div>
				<div class="slide-box">
	  				<div id="carousel" class="carousel slide" data-bs-ride="true" style="width : 200px;">
						<div class="carousel-indicators">
						    <% for(int j=0;j<f.getFilePath().size();j++) { %>
						    	<% if(j == 0) { %>
								    <button type="button" data-bs-target="#carousel" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
						    	<% } else { %>
								    <button type="button" data-bs-target="#carousel" data-bs-slide-to="<%= j %>" aria-label="Slide <%= j + 1%>"></button>
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
								<div class="carousel-item active">
									<img src="/upload/photo/noImg.gif" class="d-block w-100" alt="...">
							]	</div>
							<% } %>
						</div>
						<button class="carousel-control-prev" type="button" data-bs-target="#carousel" data-bs-slide="prev">
						    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
						    <span class="visually-hidden">Previous</span>
						</button>
						<button class="carousel-control-next" type="button" data-bs-target="#carousel" data-bs-slide="next">
						    <span class="carousel-control-next-icon" aria-hidden="true"></span>
						    <span class="visually-hidden">Next</span>
						</button>
					</div>
				</div>
				<div class="detail">
					<div>
						<span>주소</span>
						<span><%= f.getFripAddr() %></span>
					</div>
					<div>
						<span>난이도</span>
						<span><%= f.getFripLevel() %></span>
					</div>
					<div>
						<span>1인당 금액</span>
						<span><%= f.getFripPrice() %></span>
					</div>
					<div>
						<span>프립 신청결과</span>
						<span><%= f.getFripAuth() %></span>
					</div>
				</div>
				<div class="detail-btn-wrap">
					<a href="#">
						<button class="btn btn-primary">바로가기</button>
					</a>
					<a href="#">
						<button class="btn btn-primary">수정하기</button>
					</a>
				</div>
			</div>
			<div class="frip-right-wrap">
				<div class="frip-income-wrap">
					<div class="income-title">총 수입금</div>
					<div>
						<span>스프립에 참가한 총 인원수</span>
						<span>0명</span>
					</div>
					<div>
						<span>총 수입금</span>
						<span>0원</span>
					</div>
				</div>
				<div class="frip-inquiry-feed-wrap">
					<div class="inquiry-wrap">
						<div class="inquiry-title">
							<span>문의글</span>
							<a href="#">
								<button class="btn btn-link">더보기</button>
							</a>
						</div>
						<div class="inquiry-content">
							<div>Text - Double click to edit</div>
							<div>Text - Double click to edit</div>
						</div>
					</div>
					<div class="feed-wrap">
						<div class="feed-title">
							<span>내 평점</span>
							<a href="#">
								<button class="btn btn-link">더보기</button>	
							</a>
						</div>
						<div class="feed-content">
							<div class="feed-rating">ㅁㅁㅁㅁ</div>
							<div class="feed-rating-number">4.0</div>
						</div>
					</div>
				</div>
			</div>
			<div class="frip-date-wrap">
				<div class="date-title">스프립 날짜 설정</div>
				<div class="date-input-warp">
					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<label class="input-group-text" for="startDate">스프립 시작날짜</label>
						</div>
						<input type="date" class="form-control" name="startDate" id="startDate" required>
					</div>
					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<label class="input-group-text" for="endDate">스프립 마감날짜</label>
						</div>
						<input type="date" class="form-control" name="endDate" id="endDate" required>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>