<%@page import="kr.or.iei.member.vo.PaymentList"%>
<%@page import="kr.or.iei.payment.vo.Payment"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    
    ArrayList<PaymentList> list = (ArrayList<PaymentList>)request.getAttribute("list");
	PaymentList pl = (PaymentList)request.getAttribute("pl");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/member/memberPayment.css">
<style>
	.notice-tbl a:hover{
		text-decoration: underLine;
	}
	.notice-tbl tr{
		border-bottom: 1px solid #ccc;
	}
	.notice-tbl tr>td:nth-child(2){
		text-align: left;
	}
	
</style>
</head>
<body>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<div class="page-content">
	
	<div class="join-wrap">
			<div class="join-header">
				<h1>결제내역</h1>
			</div>
			<hr>
				<table class="tbl tbl-hover notice-tbl">
 		<tr class="tr-2">
 			<th style="width:10%">번호</th>
 			<th style="width:10%">스프립 정보</th>
 			<th style="width:10%">결제금액</th>
 			<th style="width:10%">결제일자</th>
 		</tr>
 		  
 		<%for(int i=0;i<list.size();i++){ %> 
 		<!-- 0부터면 처음부터 -->
 		<%PaymentList plt = list.get(i); %>
 			<tr class="tr-1">
 				<td><%=i+1 %></td>
 				<td>
 					<a href="/joinFrip.do?fripNo=<%=plt.getFripNo() %>">
 				<%=plt.getFripTitle() %>
 					</a>
 				</td>
 				<td><%=plt.getTotalPrice() %></td>
 				<td></td>
 				<td><%=plt.getWriteDate() %></td>
 				 
 			</tr>
 		<%} %>
 		
 	</table>
	</div>
	<%@ include file="/WEB-INF/views/common/footer.jsp"%>
</body>
</html>