<%@page import="kr.or.iei.frip.vo.FripMainDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	FripMainDate data = (FripMainDate)request.getAttribute("data");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/fripPage/fripMain.css">
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<div class="page-content">
		<%@include file="/WEB-INF/views/frip/fripSideBar.jsp" %>
		<div class="content">
			<div class="my-info wrap">
				<div class="info-title">안녕하세요</div>
				<div class="my-info-content">
					<% if(loginMember.getMemberProfile() != null) { %>
						<img src="/upload/member/<%= loginMember.getMemberProfile() %>">
					<% } else { %>
						<img src="/upload/member/no-profile.png">
					<% } %>
					<div><%= loginMember.getMemberId() %>님</div>	
				</div>
				<a href="/myFripList.do?memberId=<%= loginMember.getMemberId()%>">
					<button class="btn" style="background-color : #FEBE8C; color : white;">
						내 스프립 목록
					</button>
				</a>
			</div>
			<div class="all-frip-info wrap">
				<div class="info-table-box">
					<table class="tbl">
						<tbody>
							<tr>
								<td>
									<span>전체 프립 수</span>
									<div><%= data.getTotalFripCount() %></div>
								</td>
								<td>
									<span>전체 결제 수</span>
									<div><%= data.getTotalPaymentCount() %></div>
								</td>
								<td>
									<span>총 완료 프립 수</span>
									<div><%= data.getTotalExpiredFripCount() %></div>
								</td>
							</tr>
							<tr>
								<td>
									<span>전체 후기 수</span>
									<div><%= data.getTotalFeedCount() %></div>
								</td>
								<td colspan="2">
									<div>평균 별점</div>
									<% String result = String.format("%.1f",data.getTotalrankCount() ); %>
									<% for(int i=0;i<Double.parseDouble(result);i++) {%>
										<img src="/upload/photo/star-on.png" style="width: 25px;">
									<% } %>
									<span><%= result %></span>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="income-info">
					<div class="income-title">총 수익금</div>
					<div><%= data.getTotalIncome() %><span>원</span></div>
				</div>
			</div>
		</div>
	</div>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>