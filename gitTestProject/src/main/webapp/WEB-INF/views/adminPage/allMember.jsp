<%@page import="kr.or.iei.member.vo.Member" %>
    <%@page import="java.util.ArrayList" %>
        <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
            <% ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("list");
                    String pageNavi = (String)request.getAttribute("pageNavi");
                    int start = (int)request.getAttribute("start");
                    %>
                    <!DOCTYPE html>
                    <html lang="ko" dir="ltr">

                    <head>
                        <title>전체화원 관리</title>
                        <link rel="stylesheet" href="/css/adminPage/allMember.css">
                    </head>

                    <body>
                        <%@ include file="/WEB-INF/views/adminPage/adminPageHeader.jsp" %>
                            <div class="main-container">
                                <div class="main-content">
                                    <div class="card">
                                        <div class="main-header">
                                            <h1>전체 회원 관리</h1>
                                        </div>
                                        <div class="search">
                                            <div class="search-padding">
                                                <label for="searchId" style="font-size: 0.9rem;">검색:</label>
                                                <input type="text" name="searchId" id="searchId"
                                                    placeholder="아이디를 입력해주세요"
                                                    onkeyup="if(window.event.keyCode==13){inputEnter();}">
                                                <button class="submit" type="submit">검색</button>
                                                <button class="reset" type="reset">초기화</button>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="card">
                                        <div>
                                            <table class="table">
                                                <tr class="tr-2">
                                                    <th>선택</th>
                                                    <th>번호</th>
                                                    <th>아이디</th>
                                                    <th>이름</th>
                                                    <th>전화번호</th>
                                                    <th>역할</th>
                                                    <th>가입일</th>
                                                    <th>등급 변경</th>
                                                    <th>탈퇴</th>
                                                </tr>
                                                <%for(int i=0; i < list.size(); i++) {%>
                                                    <%Member member=list.get(i); %>
                                                        <%if(!member.getMemberId().equals(loginMember.getMemberId()))
                                                            {%>
                                                            <tr>
                                                                <td><input type="checkbox" class="chk"></td>
                                                                <td>
                                                                    <%=i+start%>
                                                                </td>
                                                                <td>
                                                                    <%=member.getMemberId() %>
                                                                </td>
                                                                <td>
                                                                    <%=member.getMemberName() %>
                                                                </td>
                                                                <td>
                                                                    <%=member.getMemberPhone() %>
                                                                </td>
                                                                <td>
                                                                    <%if(member.getMemberLevel()==1) {%>
                                                                        <select class="input">
                                                                            <option value="1" selected>운영자</option>
                                                                            <option value="2">호스트</option>
                                                                            <option value="3">회원</option>
                                                                            <option value="4">탈퇴 회원</option>
                                                                        </select>
                                                                        <%} else if(member.getMemberLevel()==2) {%>
                                                                            <select class="input">
                                                                                <option value="1">운영자</option>
                                                                                <option value="2" selected>호스트</option>
                                                                                <option value="3">회원</option>
                                                                                <option value="4">탈퇴 회원</option>
                                                                            </select>
                                                                            <%} else if(member.getMemberLevel()==3) {%>
                                                                                <select class="input">
                                                                                    <option value="1">운영자</option>
                                                                                    <option value="2">호스트</option>
                                                                                    <option value="3" selected>회원
                                                                                    </option>
                                                                                    <option value="4">탈퇴 회원</option>
                                                                                </select>
                                                                                <%} else if(member.getMemberLevel()==4)
                                                                                    {%>
                                                                                    <select class="input">
                                                                                        <option value="1">운영자</option>
                                                                                        <option value="2">호스트</option>
                                                                                        <option value="3">회원</option>
                                                                                        <option value="4" selected>탈퇴 회원
                                                                                        </option>
                                                                                    </select>
                                                                                    <%} %>
                                                                </td>
                                                                <td>
                                                                    <%=member.getEnrollDate() %>
                                                                </td>
                                                                <td><button
                                                                        class="btc bc33 btn chageLevel">회원등급변경</button>
                                                                </td>
                                                                <td><button class="btc bc33 btn  withdrawal">탈퇴</button>
                                                                </td>
                                                            </tr>
                                                            <%} %>
                                                                <%} %>
                                                                    <tr>
                                                                        <th colspan="9">
                                                                            <button
                                                                                class="select-btn checkedChangeLevel">선택회원등급변경</button>
                                                                            <button
                                                                                class="select-btn checkedWithdrawal">선택회원탈퇴</button>
                                                                        </th>
                                                                    </tr>
                                            </table>
                                            <div id="pageNavi">
                                                <%=pageNavi %>
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
                            </div>
                            <script>
                                $(".chageLevel").on("click", function () {
                                    const memberId = $(this).parent().parent().children().eq(2).text(); // 회원 아이디   
                                    const memberLevel = $(this).parent().parent().children().eq(5).children().val(); // 회원 등급       

                                    location.href = "/changeLevel.do?memberId=" + memberId + "&memberLevel=" + memberLevel;
                                });

                                $(".withdrawal").on("click", function () {
                                    const memberId = $(this).parent().parent().children().eq(2).text(); // 회원 아이디          

                                    location.href = "/withdrawal.do?memberId=" + memberId;
                                });

                                $(".checkedChangeLevel").on("click", function () {
                                    const check = $(".chk:checked");

                                    if (check.length == 0) {
                                        alert("선택된 회원이 없습니다.");
                                        return;
                                    }

                                    // 체크된 회원번호와, 등급 저장(배열)
                                    const Id = new Array();
                                    const level = new Array();

                                    check.each(function (index, item) {
                                        const memberId = $(item).parent().parent().children().eq(2).text();

                                        Id.push(memberId);

                                        const memberLevel = $(item).parent().parent().find("select").val();

                                        level.push(memberLevel);
                                    });

                                    location.href = "/checkedChangeLevel.do?id=" + Id.join("/") + "&level=" + level.join("/");
                                });

                                $(".checkedWithdrawal").on("click", function () {
                                    const check = $(".chk:checked");

                                    if (check.length == 0) {
                                        alert("선택된 회원이 없습니다.");
                                        return;
                                    }

                                    // 체크된 회원번호와, 등급 저장(배열)
                                    const Id = new Array();

                                    check.each(function (index, item) {
                                        const memberId = $(item).parent().parent().children().eq(2).text();

                                        Id.push(memberId);
                                    });

                                    location.href = "/checkedWithdrawal.do?id=" + Id.join("/");
                                });

                                $(".submit").on("click", function () {
                                    const searchId = $(this).prev().val();

                                    location.href = "/memberSearch.do?reqPage=1&searchId=" + searchId;
                                });

                                function inputEnter() {
                                    const searchId = $("#searchId").val();

                                    location.href = "/memberSearch.do?reqPage=1&searchId=" + searchId;
                                }
                            </script>
                            <!-- sidebar.js -->
                            <script src="/js/adminPage/sidebar.js"></script>
                    </body>

                    </html>