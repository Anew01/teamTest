<%@page import="kr.or.iei.inquiry.vo.InquiryList"%>
<%@page import="kr.or.iei.feed.vo.Feed"%>
<%@page import="kr.or.iei.member.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	ArrayList<InquiryList> list = (ArrayList<InquiryList>)request.getAttribute("list");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/mokupCss/feed.css">
<style>
	.whole-wrap{
		margin-top: 50px;
	}
	.wrap{
		margin: 10px auto;
		padding: 30px;
		width: 60%;
		border: 1px solid #F7A4A4;
		border-radius: 30px;
	}
	.content{
		padding: 10px;
	}
	.wrap:hover {
  		box-shadow: 0px 0px 20px 5px rgba(247, 164, 164, 0.5);
  		transition: all 0.5s ease-in-out;
  		background-color: #F7A4A4;
  		cursor: pointer;
	}
	.inquiry-box>table>tbody>tr>th{
		width: 400px;
		text-align: center;
		padidng: 10px;
	}
	.inquiry-box>table>tbody>tr>td{
		width: 800px;
		padidng: 10px;
	}
	th, td{
	padding: 10px;
	}
	
	
</style>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<%for(int i=0; i<list.size(); i++){ %>
	<%InquiryList iqr = list.get(i); %>
	<div class="whole-wrap">
		<div class="wrap">
			<div class="inquiry-box">
			  <table>
			    <tr>
			      <th>작성자</th>
			      <td><%=iqr.getInquiryWriter() %></td>
			    </tr>
			    <tr>
			      <th>피드내용</th>
			      <td><%=iqr.getInquiryContent()%></td>
			    </tr>
			    <tr>
			      <th>작성일</th>
			      <td><%=iqr.getWriteDate() %></td>
			    </tr>
			  </table>
			</div>
		</div>
	</div>
	<%} %>
    <%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>