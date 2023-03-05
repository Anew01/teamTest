<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/member/login.css">
</head>
<body>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<div class="page-content">
 <div class="join-wrap">
        <div class="join-header">
            <span>로그인</span>
        </div>
        <hr>
        <div class="join-content">
            <form action="/login.do" method="post" autocomplete="off">
                <div class="inputs-wrap">
                    <div class="join-input-wrap">
                        <div>
                            <input type="text" name="loginId" id="loginId" placeholder="아이디(이메일)" onfocus="this.placeholder=''" onblur="this.placeholder='아이디(이메일)'" required> 
                        </div>
                    </div>
                    <div class="join-input-wrap">
                        <div>
                            <input type="password" name="loginPw" id="loginPw" placeholder="비밀번호" onfocus="this.placeholder=''" onblur="this.placeholder='비밀번호'" required> 
                        </div>
                    </div>
                    <div class="subMenu">
                        <span><a href="/enrollMain.do">회원가입</a></span>
                        <span><a href='#'>비밀번호 찾기</a></span>
                    </div>
                <div class="join-btn-wrap">
                    <input type="submit" value="로그인">
                </div>
            </form>
        </div>
    </div>
</div>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>