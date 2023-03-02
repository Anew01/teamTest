<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko" dir="ltr">
<head>
<meta charset="UTF-8">
<head>
	<title>프로필 관리</title>
	<link rel="stylesheet" href="/css/adminPage/profile.css">
</head>
<body>
		<%@ include file = "/WEB-INF/views/adminPage/adminPageHeader.jsp" %>
         <div class="main-container">
            <div class="main-content">
                <div class="main-header">
                    <h1>프로필 관리</h1>
                </div>
                <div class="card">
                    <div>
                        <table class="profile-table">
                            <tr>
                                <img src="./user.png" class="profile-image">
                                <th><label for="" class="adminLabel">아이디</label></th>
                                <td><input type="text" name="name" class="adminInput" value="alstq" readonly></td>
                            </tr>
                            <tr>
                                <th>프로필 사진</th>
                                <td><input type="text"></td>
                            </tr>
                            <tr>
                                <th>프로필 사진</th>
                                <td><input type="text"></td>
                            </tr>
                            <tr>
                                <th>프로필 사진</th>
                                <td><input type="text"></td>
                            </tr>
                            <tr>
                                <th>프로필 사진</th>
                                <td><input type="text"></td>
                            </tr>
                            <tr>
                                <th>프로필 사진</th>
                                <td><input type="text"></td>
                            </tr>
                        </table>
                    </div>
                </div>
                <div class="card">
                    <p>㈜프렌트립 | 사업자 등록번호 : 261-81-04385|통신판매업신고번호 : 2016-서울성동-01088
                        대표 : 임수열|개인정보 관리 책임자 : 양사열|서울시 성동구 왕십리로 115 헤이그라운드 서울숲점 G703
                        ㈜프렌트립은 통신판매중개자로서 거래당사자가 아니며, 호스트가 등록한 상품정보 및 거래에 대해 ㈜프렌트립은 일체의 책임을 지지 않습니다.</p>
                </div>
            </div>
        </div>
    </div>
    <!-- sidebar.js -->
    <script src="/js/adminPage/sidebar.js"></script>
</body>
</html>