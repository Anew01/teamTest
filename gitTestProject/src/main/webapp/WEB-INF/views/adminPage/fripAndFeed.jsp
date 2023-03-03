<%@page import="kr.or.iei.feed.vo.Feed" %>
    <%@page import="kr.or.iei.frip.vo.Frip" %>
        <%@page import="java.util.ArrayList" %>
            <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
                <% ArrayList<Frip> frips = (ArrayList<Frip>)request.getAttribute("frips");
                        String fripPageNavi = (String)request.getAttribute("fripPageNavi");
                        int fripStart = (int)request.getAttribute("fripStart");

                        ArrayList<Feed> feeds = (ArrayList<Feed>)request.getAttribute("feeds");
                                String feedPageNavi = (String)request.getAttribute("feedPageNavi");
                                int feedStart = (int)request.getAttribute("feedStart");
                                %>
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
                                                            <tr class="tr-1">
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
                                                            <%for(int i=0; i < frips.size(); i++) {%>
                                                                <%Frip frip=frips.get(i);%>
                                                                    <tr>
                                                                        <td><input type="checkbox" class="chk fripChk">
                                                                        </td>
                                                                        <td>
                                                                            <%=i+fripStart%>
                                                                        </td>
                                                                        <td>
                                                                            <%=frip.getFripWriter() %>
                                                                        </td>
                                                                        <td class="frip-no">
                                                                            <%=frip.getFripNo() %>
                                                                        </td>
                                                                        <td>
                                                                            <%=frip.getFripTitle() %>
                                                                        </td>
                                                                        <td>
                                                                            <%=frip.getFripAddr() %>
                                                                        </td>
                                                                        <td>
                                                                            <%=frip.getFripLevel() %>
                                                                        </td>
                                                                        <td>
                                                                            <%=frip.getFripPrice() %>
                                                                        </td>
                                                                        <td><button
                                                                                class="btc bc33 btn chageLevel fripAccept">등록
                                                                                수락</button></td>
                                                                        <td><button
                                                                                class="btc bc33 btn withdrawal  fripDelete">삭제</button>
                                                                        </td>
                                                                    </tr>
                                                                    <%} %>
                                                                        <tr>
                                                                            <th colspan="9">
                                                                                <button
                                                                                    class="select-btn checkedChangeLevel checkedfripAccept">선택프립등록수락</button>
                                                                                <button
                                                                                    class="select-btn checkedWithdrawal checkedfripDelete">선택프립삭제</button>
                                                                            </th>
                                                                        </tr>
                                                        </table>
                                                        <div id="pageNavi">
                                                            <%=fripPageNavi %>
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
                                                            <%for(int i=0; i < feeds.size(); i++) {%>
                                                                <%Feed feed=feeds.get(i);%>
                                                                    <tr>
                                                                        <td><input type="checkbox" class="chk feedChk">
                                                                        </td>
                                                                        <td>
                                                                            <%=i+feedStart %>
                                                                        </td>
                                                                        <td class="feed-no">
                                                                            <%=feed.getFeedNo() %>
                                                                        </td>
                                                                        <td>
                                                                            <%=feed.getFripNo() %>
                                                                        </td>
                                                                        <td>
                                                                            <%=feed.getFripNo() %>
                                                                        </td>
                                                                        <td>
                                                                            <%=feed.getWriteDate() %>
                                                                        </td>
                                                                        <td><button
                                                                                class="btc bc33 btn withdrawal feedDelete">삭제</button>
                                                                        </td>
                                                                    </tr>
                                                                    <%} %>
                                                                        <tr>
                                                                            <th colspan="9">
                                                                                <button
                                                                                    class="select-btn checkedWithdrawal checkedfeedDelete">선택피드삭제</button>
                                                                            </th>
                                                                        </tr>
                                                        </table>
                                                        <div id="pageNavi">
                                                            <%=feedPageNavi %>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="card">
                                                    <p>㈜프렌트립 | 사업자 등록번호 : 261-81-04385|통신판매업신고번호 : 2016-서울성동-01088
                                                        대표 : 임수열|개인정보 관리 책임자 : 양사열|서울시 성동구 왕십리로 115 헤이그라운드 서울숲점 G703
                                                        ㈜프렌트립은 통신판매중개자로서 거래당사자가 아니며, 호스트가 등록한 상품정보 및 거래에 대해 ㈜프렌트립은 일체의
                                                        책임을 지지 않습니다.
                                                    </p>
                                                </div>
                                            </div>
                                        </div>
                                        <script>
                                            $(".fripAccept").on("click", function () {
                                                const fripNo = $(this).parent().parent().children().eq(3).text(); // 프립 번호  

                                                location.href = "/fripAccept.do?fripNo=" + fripNo;
                                            });

                                            $(".fripDelete").on("click", function () {
                                                const fripNo = $(this).parent().parent().children().eq(3).text(); // 프립 번호       

                                                location.href = "/fripDelete.do?fripNo=" + fripNo;
                                            });

                                            $(".feedDelete").on("click", function () {
                                                const feedNo = $(this).parent().parent().children().eq(2).text(); // 피드 번호       

                                                location.href = "/feedDelete.do?feedNo=" + feedNo;
                                            });

                                            $(".checkedfripAccept").on("click", function () {
                                                const check = $(".fripChk:checked");

                                                if (check.length == 0) {
                                                    alert("선택된 회원이 없습니다.");
                                                    return;
                                                }

                                                const fripNos = new Array();

                                                check.each(function (index, item) {
                                                    const fripNo = $(item).parent().parent().children().eq(3).text();

                                                    fripNos.push(fripNo);
                                                });

                                                location.href = "/checkedfripAccept.do?fripNos=" + fripNos.join("/");
                                            });

                                            $(".checkedfripDelete").on("click", function () {
                                                const check = $(".fripChk:checked");

                                                if (check.length == 0) {
                                                    alert("선택된 회원이 없습니다.");
                                                    return;
                                                }

                                                const fripNos = new Array();

                                                check.each(function (index, item) {
                                                    const fripNo = $(item).parent().parent().children().eq(3).text();

                                                    fripNos.push(fripNo);
                                                });

                                                location.href = "/checkedfripDelete.do?fripNos" + fripNos.join("/");
                                            });

                                            $(".checkedfeedDelete").on("click", function () {
                                                const check = $(".feedChk:checked");

                                                if (check.length == 0) {
                                                    alert("선택된 회원이 없습니다.");
                                                    return;
                                                }

                                                const feedNos = new Array();

                                                check.each(function (index, item) {
                                                    const feedNo = $(item).parent().parent().children().eq(2).text();

                                                    feedNos.push(feedNo);
                                                });

                                                location.href = "/checkedfeedDelete.do?feedNos" + feedNos.join("/");
                                            });
                                        </script>
                                        <script src="/js/adminPage/sidebar.js"></script>
                                </body>

                                </html>