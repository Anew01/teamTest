<%@page import="kr.or.iei.member.vo.PaymentList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
ArrayList<PaymentList> list = (ArrayList<PaymentList>) request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.page-header>h1 {
	text-align: left;
	padding: 25px;
	font-family: nn_eb;
	font-size: 2em;
}

.payment-wrap {
	width: 1200px;
	background-color: #fff;
	margin: 100px auto;
}

.payment-tbl {
	width: 900px;
	margin: 0 auto;
}

.payment-tbl tr {
	border-bottom: 1px solid #ccc;
	text-align: center;
	height: 40px;
}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp"%>
	<div class="page-content">
		<div class="payment-wrap">
			<div class="page-header">
				<h1>결제내역</h1>
			</div>
			<hr>
			<br>
			<table class="payment-tbl">
				<tr>
					<th style="width: 10%">번호</th>
					<th style="width: 40%">스프립 정보</th>
					<th style="width: 25%">결제금액</th>
					<th style="width: 25%">결제일자</th>
				</tr>

				<%
				for (int i = 0; i < list.size(); i++) {
				%>
				<!-- 0부터면 처음부터 -->
				<%
				PaymentList plt = list.get(i);
				%>
				<tr>
					<td><%=i + 1%></td>
					<td><a href="/joinFrip.do?fripNo=<%=plt.getFripNo()%>"> <%=plt.getFripTitle()%>
					</a></td>
					<td><%=plt.getTotalPrice()%></td>
					<td><%=plt.getWriteDate()%></td>
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