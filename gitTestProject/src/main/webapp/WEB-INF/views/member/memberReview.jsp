<%@page import="kr.or.iei.feed.vo.Feed"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    ArrayList<Feed> list = (ArrayList<Feed>)request.getAttribute("list");
Member member = (Member) request.getAttribute("m");
int start = (int)request.getAttribute("start");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/member/memberReview.css">
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
				<h1>후기</h1>
			</div>
			<hr>
			<table class="tbl tbl-hover notice-tbl">
 		<tr class="tr-2">
 			<th style="width:10%">번호</th>
 			<th style="width:10%">스프립 정보</th>
 		</tr>
 		<%for(int i=0;i<list.size();i++){ %> 
 		<!-- 0부터면 처음부터 -->
 		<%Notice n = list.get(i); %>
 			<tr class="tr-1">
 				<td><%=i+start %></td>
 				<td>
 					<a href="/noticeView.do?noticeNo=<%=n.getNoticeNo() %>">
 				<%=n.getNoticeTitle() %>
 					</a>
 				</td>
 			</tr>
 		<%} %>
 	</table>
	</div>
	<%@ include file="/WEB-INF/views/common/footer.jsp"%>
</body>
</html>