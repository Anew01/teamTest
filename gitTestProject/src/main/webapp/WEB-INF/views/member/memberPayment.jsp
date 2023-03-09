<%@page import="kr.or.iei.payment.vo.Payment"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    
    ArrayList<Frip> list = (ArrayList<Frip>)request.getAttribute("list");
Member member = (Member) request.getAttribute("m");
int start = (int)request.getAttribute("start");
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
 		<%Frip f = list.get(i); %>
 			<tr class="tr-1">
 				<td><%=i+start %></td>
 				<td>
 					<a href="/noticeView.do?noticeNo=<%=f.getFripNo() %>">
 				<%=p.getNoticeTitle() %>
 					</a>
 				</td>
 				<td><%=p.getNoticeWriter() %></td>
 				<td><%=p.getRegDate() %></td>
 			</tr>
 		<%} %>
 	</table>
	</div>
	<%@ include file="/WEB-INF/views/common/footer.jsp"%>
</body>
</html>