<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
                                <tr class="tr-2">
                                    <th style="width:10%">번호</th>
                                    <th style="width:45%">제목</th>
                                    <th style="width:15%">작성자</th>
                                    <th style="width:20%">작성일</th>
                                </tr>
                                <tr class="tr-1">
                                    <td>
                                        1
                                    </td>
                                    <td>
                                        <a href="/noticeView.do?noticeNo=1">
                                            제목
                                        </a>
                                    </td>
                                    <td>
                                        작성자
                                    </td>
                                    <td>
                                        2022-21-21
                                    </td>                                
                                </tr>
                            </table>
                            <div id="pageNavi">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            </div>
            <script src="/js/adminPage/sidebar.js"></script>
    </body>

    </html>