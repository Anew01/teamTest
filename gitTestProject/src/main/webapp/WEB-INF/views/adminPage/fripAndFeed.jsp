<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html lang="ko" dir="ltr">

    <head>
        <title>프립/피드 관리</title>
        <link rel="stylesheet" href="/css/adminPage/fripAndFeed.css">
    </head>

    <body>
        <%@ include file="/WEB-INF/views/adminPage/adminPageHeader.jsp" %>
            <div class="main-container">
                <div class="main-content">
                    <div class="main-header">
                        <h1>프립/피드 관리</h1>
                    </div>
                    <div class="card">
                        <div class="main-header">
                            <h1>프립 관리</h1>
                        </div>
                        <div>
                            <table class="table">
                                <tr class="tr-2">
                                    <th>선택</th>
                                    <th>번호</th>
                                    <th>작성자</th>
                                    <th>제목</th>
                                    <th>주소</th>
                                    <th>난이도</th>
                                    <th>가격</th>
                                    <th>등록 수락</th>
                                    <th>삭제</th>
                                </tr>
                                <tr>
                                    <td><input type="checkbox" class="chk"></td>
                                    <td>
                                        1
                                    </td>
                                    <td>
                                        alstjq
                                    </td>
                                    <td>
                                        여행가기
                                    </td>
                                    <td>
                                        서울시 구로수 16069호
                                    </td>
                                    <td>
                                        어려움
                                    </td>
                                    <td>36000</td>
                                    <td><button class="btc bc33 btn fripAccept">등록 수락</button></td>
                                    <td><button class="btc bc33 btn  fripDelete">삭제</button></td>
                                </tr>

                                <tr>
                                    <th colspan="9">
                                        <button class="select-btn checkedChangeLevel">선택프립등록수락</button>
                                        <button class="select-btn checkedWithdrawal">선택프립삭제</button>
                                    </th>
                                </tr>
                            </table>
                            <div id="pageNavi">

                            </div>
                        </div>
                    </div>
                    <div class="card">
                        <div class="main-header">
                            <h1>피드 관리</h1>
                        </div>
                        <div>
                            <table class="table">
                                <tr class="tr-2">
                                    <th>선택</th>
                                    <th>번호</th>
                                    <th>프립</th>
                                    <th>작성자</th>
                                    <th>작성일자</th>
                                    <th>삭제</th>
                                </tr>
                                <tr>
                                    <td><input type="checkbox" class="chk"></td>
                                    <td>
                                        1
                                    </td>
                                    <td>
                                        여행가기
                                    </td>
                                    <td>
                                        심민섭
                                    </td>
                                    <td>
                                        2022-3-12
                                    </td>
                                    <td><button class="btc bc33 btn  withdrawal">삭제</button></td>
                                </tr>

                                <tr>
                                    <th colspan="9">
                                        <button class="select-btn checkedWithdrawal">선택피드삭제</button>
                                    </th>
                                </tr>
                            </table>
                            <div id="pageNavi">

                            </div>
                        </div>
                    </div>
                    <div class="card">
                        <p>㈜프렌트립 | 사업자 등록번호 : 261-81-04385|통신판매업신고번호 : 2016-서울성동-01088
                            대표 : 임수열|개인정보 관리 책임자 : 양사열|서울시 성동구 왕십리로 115 헤이그라운드 서울숲점 G703
                            ㈜프렌트립은 통신판매중개자로서 거래당사자가 아니며, 호스트가 등록한 상품정보 및 거래에 대해 ㈜프렌트립은 일체의 책임을 지지 않습니다.
                        </p>
                    </div>
                </div>
            </div>
            <script src="/js/adminPage/sidebar.js"></script>
    </body>

    </html>