<%@page import="kr.or.iei.notice.vo.Notice" %>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
        <% ArrayList<Notice> list = (ArrayList<Notice>)request.getAttribute("list");
                String pageNavi = (String)request.getAttribute("pageNavi");
                int start = (int)request.getAttribute("start");
                %>
                <!DOCTYPE html>
                <html>

                <head>
                    <meta charset="UTF-8">
                    <title>공지사항 사용자</title>
                    <link rel="stylesheet" href="/css/adminPage/noticeUser.css">
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
                                <%for(int i=0; i<list.size(); i++){ %>
                                    <%Notice notice=list.get(i); %>
                                        <li>
                                            <div class="notice-li">
                                                <div class="notice-category">
                                                    <%=notice.getNoticeCategory() %>
                                                </div>
                                                <div class="notice-title">
                                                    <%=notice.getNoticeTitle() %>
                                                </div>
                                                <div class="notice-enrolldate">
                                                    <%=notice.getEnrollDate() %>
                                                </div>
                                            </div>
                                            <div class="notice-content">
                                                <%=notice.getNoticeContent() %>
                                            </div>
                                        </li>
                                        <%} %>
                            </ul>
                            <div id="pageNavi">
                                <%=pageNavi %>
                            </div>
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
                                    location.href = "/noticeFAQListUser.do";
                                })

                                $(document).ready(function () {
                                    for (let index = 0; index < $(".notice-category").text().length; index++) {
                                        if ($(".notice-category").text().eq(index) == "공지") {
                                            $(".notice-category").text().eq(index).css("background-color", "rgb(51, 151, 255)");
                                        } else if ($(".notice-category").text().eq(index) == "이벤트") {
                                            $(".notice-category").text().eq(index).css("background-color", "rgb(160, 130, 250)");
                                        }
                                    }
                                });
                            </script>
                </body>

                </html>