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
                                <span class="allNotice">전체</span>
                                <span class="">공지</span>
                                <span class="">이벤트</span>
                                <span class="">자주 묻는 질문</span>
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
                                    $(".notice-content").toggleClass("active");
                                });            
                            </script>
                </body>

                </html>