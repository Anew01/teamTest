<%@page import="java.util.ArrayList" %>
    <%@page import="kr.or.iei.notice.vo.Notice" %>
        <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
            <% ArrayList<Notice> list = (ArrayList<Notice>)request.getAttribute("list");
                    String pageNavi = (String)request.getAttribute("pageNavi");
                    int start = (int)request.getAttribute("start");
                    %>
                    <!DOCTYPE html>
                    <html lang="ko" dir="ltr">

                    <head>
                        <title>공지사항 목록</title>
                        <link rel="stylesheet" href="/css/adminPage/noticeList.css">
                    </head>

                    <body>
                        <%@ include file="/WEB-INF/views/adminPage/adminPageHeader.jsp" %>
                            <div class="main-container">
                                <div class="main-content">
                                    <div class="main-header">
                                        <h1>공지사항 목록</h1>
                                    </div>
                                    <div class="card">
                                        <div>
                                            <table class="table tbl-hover notice-tbl">
                                                <tr class="tr-1">
                                                    <th>번호</th>
                                                    <th>제목</th>
                                                    <th>작성자</th>
                                                    <th>작성일</th>
                                                    <th>수정</th>
                                                    <th>삭제</th>
                                                </tr>
                                                <%for(int i=0; i<list.size(); i++){ %>
                                                    <%Notice notice=list.get(i); %>
                                                        <tr class="tr-2">
                                                            <td>
                                                                <%=i+start %>
                                                            </td>
                                                            <td>
                                                                <a href="#" class="notice-content-view">
                                                                    <%=notice.getNoticeTitle() %>
                                                                </a>
                                                            </td>
                                                            <td>
                                                                <%=notice.getNoticeWriter() %>
                                                            </td>
                                                            <td>
                                                                <%=notice.getEnrollDate() %>
                                                            </td>
                                                            <td>
                                                                <button type="button" class="btn upadte-btn">수정</button>
                                                            </td>
                                                            <td>
                                                                <button type="button" class="btn delete-btn">삭제</button>
                                                            </td>
                                                            <td class="notice-No"><%=notice.getNoticeNo() %></td>
                                                        </tr>
                                                        <tr class="notice-content">
                                                            <td colspan="5">
                                                                <%=notice.getNoticeContent() %>
                                                            </td>
                                                        </tr>
                                                        <%} %>
                                            </table>
                                            <div id="pageNavi">
                                                <%=pageNavi %>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            </div>
                            <script>
                                $(".notice-content-view").on("click", function () {
                                    $(this).parent().parent().next().css("display", "table-cell");
                                });

                                $(".upadte-btn").on("click", function () {
                                    const noticeNo = $(this).parent().parent().children().eq(6).text();

                                    location.href = "/updateNoticeFrm.do?noticeNo=" + noticeNo;
                                });

                                $(".delete-btn").on("click", function () {
                                    const noticeNo = $(this).parent().parent().children().eq(6).text();

                                    location.href = "/deleteNotice.do?noticeNo=" + noticeNo;
                                });
                            </script>
                            <script src="/js/adminPage/sidebar.js"></script>
                    </body>

                    </html>