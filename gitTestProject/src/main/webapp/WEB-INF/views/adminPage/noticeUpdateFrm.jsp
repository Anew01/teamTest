<%@page import="kr.or.iei.notice.vo.Notice" %>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
        <% Notice notice=(Notice)request.getAttribute("notice"); %>
            <!DOCTYPE html>
            <html lang="ko" dir="ltr">

            <head>
                <title>공지사항 수정</title>

                <link rel="stylesheet" href="/css/adminPage/noticeWrite.css">
            </head>

            <body>
                <%@ include file="/WEB-INF/views/adminPage/adminPageHeader.jsp" %>
                    <!-- 섬머 노트 -->
                    <script src="/js/summernote-lite.js"></script>
                    <script src="/js/summernote-ko-KR.js"></script>
                    <link rel="stylesheet" href="/css/summernote/summernote-lite.css">
                    <div class="main-container">
                        <div class="main-content">
                            <div class="main-header">
                                <h1>공지사항 수정</h1>
                            </div>
                            <div class="card">
                                <form action="/noticeUpdate.do" method="post">
                                    <table class="tbl" id="noticeWrite">
                                        <tr class="tr1">
                                            <th class="td-3">
                                                제목
                                            </th>
                                            <td colspan="3">
                                                <input type="text" name="noticeTitle" class="input-form"
                                                    value="<%=notice.getNoticeTitle() %>">
                                                <input type="hidden" name="noticeNo" value="<%=notice.getNoticeNo() %>">
                                            </td>
                                        </tr>
                                        <tr class="tr1">
                                            <th class="td-3">작성자</th>
                                            <td>
                                                <%=notice.getNoticeWriter() %>
                                                    <input type="hidden" name="noticeWriter"
                                                        value="<%=notice.getNoticeWriter() %>">
                                            </td>
                                            <th class="td-3">분류</th>
                                            <td>
                                                <select name="noticeCategory" id="noticeCategory">
                                                    <%if(notice.getNoticeCategory().equals("공지")) { %>
                                                        <option value="공지" selected>공지</option>
                                                        <option value="이벤트">이벤트</option>
                                                        <%} else if(notice.getNoticeCategory().equals("이벤트")){%>
                                                            <option value="공지">공지</option>
                                                            <option value="이벤트" selected>이벤트</option>
                                                            <%} %>
                                                </select>
                                            </td>
                                        </tr>
                                        <tr class="tr-1">
                                            <td colspan="4" style="text-align : left;">
                                                <textarea id="noticeContent" name="noticeContent"
                                                    class="input-form"><%=notice.getNoticeContent() %></textarea>
                                            </td>
                                        </tr>
                                        <tr class="tr-1">
                                            <td colspan="4">
                                                <button type="submit" class="noitceComplete">공지사항 수정</button>
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
                    <script>
                        $("#noticeContent").summernote({
                            height: 400,
                            lang: "ko-KR",
                            callbacks: {
                                onImageUpload: function (files) {
                                    uploadImage(files[0], this);
                                }
                            }
                        });
                        function uploadImage(file, editor) {
                            //ajax를 통해서 서버에 이미지를 업로드
                            //업로드된 이미지의 경로를 받아오는 역할
                            //받아온 이후 -> editor에 이미지 경로를 전달해서 화면에 표현
                            const form = new FormData();//<form method="post" enctype="multipart어쩌고" 의 역할
                            /*
                            <form>
                                <input type="file" name="file">
                            </form>
                            아래 form.append("file",file);와 위의 코드가 동일
                            */
                            form.append("file", file);
                            $.ajax({
                                url: "/uploadImage.do",
                                type: "post",
                                data: form,
                                processData: false,
                                contentType: false,
                                success: function (data) {
                                    console.log(data);
                                    $(editor).summernote("insertImage", data);
                                }
                            });
                            //processData : 전송하는 데이터를 기본적으로 문자열로 전송하게 세팅
                            //->파일전송을 위해서 기본값인 문자열전송을 제거(ajax는 전송시 기본타입이 문자열이기에 문자열을 없애기 위함)
                            //contentType : enctype="application/x-www-form-urlencoded;charset=UTF-8"
                            //->파일전송을 위해서 enctype기본값을 제거
                            //*ajax로 파일업로드시 반드시 적용해야할 코드
                        }
                    </script>
                    <script src="/js/adminPage/sidebar.js"></script>
            </body>

            </html>