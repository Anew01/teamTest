<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html lang="ko" dir="ltr">

    <head>
        <meta charset="UTF-8">

        <head>
            <title>프로필 관리</title>
            <link rel="stylesheet" href="/css/adminPage/profile.css">
        </head>

    <body>
        <%@ include file="/WEB-INF/views/adminPage/adminPageHeader.jsp" %>
            <div class="main-container">
                <div class="main-content">
                    <div class="main-header">
                        <h1>프로필 관리</h1>
                    </div>
                    <div class="card">
                        <div class="page-content">
                            <form action="/updateMember.do" method="post" class="profile-form">
                                <div class="input-wrap">
                                    <label for="memberNo">회원번호</label>
                                    <input type="text" name="memberNo" id="memberNo" class="input-form" value="1"
                                        disabled>
                                </div>
                                <div class="input-wrap">
                                    <label for="memberId">아이디</label>
                                    <input type="text" name="memberId" id="memberId" class="input-form" value="gsdgsdg"
                                        readonly>
                                </div>
                                <div class="input-wrap">
                                    <label for="memberPw">비밀번호</label>
                                    <input type="password" name="memberPw" id="memberPw" class="input-form"
                                        value="1234">
                                </div>
                                <div class="input-wrap">
                                    <label for="memberName">이름</label>
                                    <input type="text" name="memberName" id="memberName" class="input-form" value="유저1"
                                        disabled>
                                </div>
                                <div class="input-wrap">
                                    <label for="memberPhone">전화번호</label>
                                    <input type="text" name="memberPhone" id="memberPhone" class="input-form"
                                        value="010-1111-1111">
                                </div>
                                <div class="input-wrap">
                                    <label for="memberAddr">주소</label>
                                    <input type="text" name="memberAddr" id="memberAddr" class="input-form" value="서울시">
                                </div>
                                <div class="input-wrap">
                                    <label for="memberLevel">등급</label>
                                    <input type="text" name="memberLevel" id="memberLevel" class="input-form"
                                        value="관리자" disabled>
                                </div>
                                <div class="input-wrap">
                                    <label for="memberDate">등록일</label>
                                    <input type="text" name="memberDate" id="memberDate" class="input-form"
                                        value="2022-12-12" disabled>
                                </div>
                                <div class="btn-box">
                                    <button type="submit" class="btn bc66 bs2">정보수정</button>
                                </div>
                            </form>
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