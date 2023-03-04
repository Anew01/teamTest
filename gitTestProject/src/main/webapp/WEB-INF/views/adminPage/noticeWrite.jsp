<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html lang="ko" dir="ltr">

    <head>
        <title>공지사항 작성</title>
        <link rel="stylesheet" href="/css/adminPage/noticeWrite.css">
    </head>

    <body>
        <%@ include file="/WEB-INF/views/adminPage/adminPageHeader.jsp" %>
            <div class="main-container">
                <div class="main-content">
                    <div class="main-header">
                        <h1>프로필 관리</h1>
                    </div>
                    <div class="card">
                        <form action="/noticeWrite.do" method="post" enctype="multipart/form-data">
                            <table class="tbl" id="noticewrite">
                                <tr class="tr-1">
                                    <th class="td-3">제목</th>
                                    <td colspan="3">
                                        <input type="text" name="noticeTitle" class="input-form">
                                    </td>
                                </tr>
                                <tr class="tr-1">
                                    <th class="td-3">적성자</th>
                                    <td>
                                        <input type="hidden" name="noticeWriter">
                                    </td>
                                    <th class="td3">첨부파일</th>
                                    <td><input type="file" name="upfile"></td>
                                </tr>
                                <tr class="tr-1">
                                    <td colspan="4">
                                        <textarea name="noticeContent" class="input-form"></textarea>
                                    </td>
                                </tr>
                                <tr class="tr-1">
                                    <td colspan="4">
                                        <button type="submit" class="btn bc1 bs4">작성하기</button>
                                    </td>
                                </tr>
                            </table>
                        </form>
                    </div>
                    <div class="card">
                        <p>㈜프렌트립 | 사업자 등록번호 : 261-81-04385|통신판매업신고번호 : 2016-서울성동-01088
                            대표 : 임수열|개인정보 관리 책임자 : 양사열|서울시 성동구 왕십리로 115 헤이그라운드 서울숲점 G703
                            ㈜프렌트립은 통신판매중개자로서 거래당사자가 아니며, 호스트가 등록한 상품정보 및 거래에 대해 ㈜프렌트립은 일체의 책임을 지지 않습니다.</p>
                    </div>
                </div>
            </div>
            <script src="/js/adminPage/sidebar.js"></script>
    </body>

    </html>