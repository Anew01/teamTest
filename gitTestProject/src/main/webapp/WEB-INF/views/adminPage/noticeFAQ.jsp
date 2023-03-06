<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>공지사항 FAQ</title>
        <link rel="stylesheet" href="/css/adminPage/noticeUser.css">
        <title>Insert title here</title>
    </head>

    <body>
        <%@ include file="/WEB-INF/views/common/header.jsp" %>
            <div class="notice-userList">
                <h1 class="notice-head">공지사항</h1>
                <div class="notice-tab">
                    <span class="all-notice">전체</span>
                    <span class="notice-notice">공지</span>
                    <span class="event-notice">이벤트</span>
                    <span class="FAQ">자주 묻는 질문</span>
                </div>
                <ul class="notice-ul">
                    <li>
                        <div class="notice-li">
                            <div class="notice-category">
                                FAQ
                            </div>
                            <div class="notice-title">
                                회원 탈퇴
                            </div>
                            <div class="notice-enrolldate">
                                2022-03-13
                            </div>
                        </div>
                        <div class="notice-content">
                            회원 탈퇴 링크
                        </div>
                    </li>
                </ul>
            </div>
            <%@ include file="/WEB-INF/views/common/footer.jsp" %>
                <script>
                    $(".notice-li").on("click", function () {
                        $(this).parent().children().eq(1).toggleClass("active");
                    });

                    $(".all-notice").on("click", function () {
                        location.href = "/noticeListUser.do?reqPage=1";
                    });

                    $(".notice-notice").on("click", function () {
                        location.href = "/noticeNoticeListUser.do?reqPage=1";
                    });

                    $(".event-notice").on("click", function () {
                        location.href = "/noticeEventListUser.do?reqPage=1";
                    })

                    $(".FAQ").on("click", function () {
                        location.href = "/noticeFAQListUser.do?reqPage=1";
                    })
                </script>
    </body>

    </html>