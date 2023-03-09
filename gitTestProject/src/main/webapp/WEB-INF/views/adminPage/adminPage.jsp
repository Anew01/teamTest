<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%Member member=(Member)request.getAttribute("member"); %>
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
                                <form action="/updateMember.do" method="post" class="profile-form"
                                    enctype="multipart/form-data">
                                    <div class="input-wrap">
                                        <img src="/upload/member/<%=member.getMemberProfile() %>" class="profile-img">
                                        <label for="upProfile">
                                            <img src="/upload/admin/camera.png" id="camera">
                                        </label>
                                        <input type="file" name="upProfile" id="upProfile" class="input-form"
                                            accept=".jpg,.png,.jpeg" onchange="loadImg(this);">
                                        <input type="hidden" name="oldProfile" value="<%=member.getMemberProfile() %>">
                                    </div>
                                    <div class="input-wrap">
                                        <label for="memberId">아이디</label>
                                        <input type="text" name="memberId" id="memberId" class="input-form"
                                            value="<%=member.getMemberId() %>" readonly>
                                    </div>
                                    <div class="input-wrap">
                                        <label for="memberPw">비밀번호</label>
                                        <input type="text" name="memberPw" id="memberPw" class="input-form"
                                            value="<%=member.getMemberPw() %>">
                                    </div>
                                    <div class="input-wrap">
                                        <label for="memberName">이름</label>
                                        <input type="text" name="memberName" id="memberName" class="input-form"
                                            value="<%=member.getMemberName() %>" disabled>
                                    </div>
                                    <div class="input-wrap">
                                        <label for="memberPhone">전화번호</label>
                                        <input type="text" name="memberPhone" id="memberPhone" class="input-form"
                                            value="<%=member.getMemberPhone() %>">
                                    </div>
                                    <div class="input-wrap">
                                        <label for="memberAddr">상세주소 변경</label>
                                        <%if(member.getMemberAddrDetail()==null ||
                                            member.getMemberAddrDetail().equals("")) {%>
                                            <input type="text" name="memberAddr" id="memberAddr" class="input-form"
                                                value="상세 주소 없음">
                                            <%} else { %>
                                                <input type="text" name="memberAddr" id="memberAddr" class="input-form"
                                                    value="<%=member.getMemberAddrDetail() %>">
                                                <%} %>
                                    </div>
                                    <div class="input-wrap">
                                        <label for="memberLevel">등급</label>
                                        <input type="text" name="memberLevel" id="memberLevel" class="input-form"
                                            value="<%=member.getMemberLevel() %>" disabled>
                                    </div>
                                    <div class="input-wrap">
                                        <label for="memberDate">등록일</label>
                                        <input type="text" name="memberDate" id="memberDate" class="input-form"
                                            value="<%=member.getMemberLevel() %>" disabled>
                                    </div>
                                    <div class="input-wrap">
                                        <label for="memberIntro">관리자 소개</label>
                                        <textarea name="memberIntro" id="memberIntro" cols="132" rows="20"
                                            style="resize: none;"><%if(member.getMemberIntro() == null || member.getMemberIntro().equals("")) {%>관리자는 소개를 꼭 작성해주세요.<%} else {%><%=member.getMemberIntro() %><%} %></textarea>
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
                <script>
                    function loadImg(f) {
                        // this는 파일

                        // 첨부파일을 배열로 처리

                        // f.files.length != 0: 파일이 있고
                        // f.files[0] != 0: 파일이 정상이면
                        // files[0]: 파일 어차피 하나밖에 못 올림
                        if (f.files.length != 0 && f.files[0] != 0) {
                            const reader = new FileReader();
                            // 선택한 파일 정보를 읽어옴
                            reader.readAsDataURL(f.files[0]);
                            // 파일 정보를 다 읽어오면 동작할 함수
                            reader.onload = function (e) {
                                $(".profile-img").attr("src", e.target.result);
                            };
                        } else {
                            $(".profile-img").attr("src", "");
                        }
                    }
                </script>
        </body>

        </html>