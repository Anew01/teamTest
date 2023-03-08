<%@page import="kr.or.iei.member.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	Member mem = (Member)session.getAttribute("m");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="d-flex flex-column flex-shrink-0 p-3" style="width: 160px; background-color : #FFFBC1; border : none;">
    <a href="/fripMain.do?memberId=<%= mem.getMemberId() %>" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-white text-decoration-none">
      <span class="fs-4" style="color : #85c88a">내프립 관리</span>
    </a>
    <hr style="color : #FEBE8C;">
    <ul class="nav nav-pills flex-column mb-auto">
      <li class="nav-item">
        <a href="/insertFripFrm.do" class="nav-link text-black" aria-current="page">
         프립등록
        </a>
      </li>
      <li>
        <a href="/myFripList.do?memberId=<%= mem.getMemberId() %>" class="nav-link text-black">
          프립목록
        </a>
      </li>
    </ul>
  </div>
</body>
</html>