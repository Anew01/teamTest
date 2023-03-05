<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/member/enrollFrm.css">
</head>
<body>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<div class="page-content">
 <div class="join-wrap">
        <div class="join-header">
            <h3>스프립 시작하기</h3>
        </div>
        <div class="join-content">
            <form action="/enrollFrm.do" method="post" autocomplete="off">
                <div class="inputs-wrap">
                  
                <div class="join-btn-wrap">
                    <input type="submit" value="이메일로 시작하기" id="join_email">
                    <input type="submit" value="카카오로 시작하기" id="join_kakao">
                </div>
            </form>
        </div>
    </div>
</div>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>