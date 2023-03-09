<%@page import="kr.or.iei.member.vo.ReviewList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
ArrayList<ReviewList> list = (ArrayList<ReviewList>) request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.page-content {
	margin: 0 auto;
}

.review-wrap {
	width: 1200px;
	background-color: #fff;
	margin: 100px auto;
}

.page-header>h1 {
	text-align: left;
	padding: 25px;
	font-family: nn_eb;
	font-size: 2em;
}

.review-tbl {
	width: 900px;
	margin: 0 auto;
}

.review-tbl tr {
	border-bottom: 1px solid #ccc;
	text-align: center;
	height: 40px;
}

.table-wrap {
	margin: 0 auto;
}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp"%>
	<div class="page-content">
		<div class="review-wrap">
			<div class="page-header">
				<h1>후기</h1>
			</div>
			<hr>
			<table class="review-tbl">
				<tr>
					<th style="width: 10%">번호</th>
					<th style="width: 40%">스프립 정보</th>
					<th style="width: 40%">작성일자</th>
				</tr>
				<%
				for (int i = 0; i < list.size(); i++) {
				%>
				<!-- 0부터면 처음부터 -->
				<%
				ReviewList rl = list.get(i);
				%>
				<tr>
					<td><%=i + 1%></td>
					<td><a href="/joinFrip.do?fripNo=<%=rl.getFripNo()%>"> <%=rl.getFripTitle()%>
					</a></td>
					<td><%=rl.getWriteDate()%></td>
				</tr>
				<%
				}
				%>
			</table>
		</div>
	</div>
	<%@ include file="/WEB-INF/views/common/footer.jsp"%>
</body>
</html>