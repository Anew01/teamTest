<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link rel="stylesheet" href="/css/member/find-pw.css">
    <link rel="stylesheet" href="js/jquery-3.6.3.min.js">
</head>
<body>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<div class="page-content">
<div class="join-wrap">
        <div class="join-header">
            <span>발송 완료</span>
        </div>
        <div class="join-content">
            <form action="/loginFrm.do" method="post" autocomplete="off">
                <div class="inputs-wrap">
                    <div class="join-input-wrap">
                        
                        <p>만약 받지 못했다면 스팸함 / 메일주소</p>
                        <p>확인 부탁드립니다. 그래도 해결되지 않는다면</p>
                        <p>cs@sprip.com으로 문의바랍니다.</p>
                    </div>
                <div class="join-btn-wrap">
                    <input type="submit" value="로그인하러 가기">
                </div>
            </form>
        </div>
    </div>
</div>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>