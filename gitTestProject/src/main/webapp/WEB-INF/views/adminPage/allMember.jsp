<%@page import="kr.or.iei.member.vo.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html lang="ko" dir="ltr">
<head>
	<title>전체화원 관리</title>
	<link rel="stylesheet" href="/css/adminPage/allMember.css">
</head>
<body>
		<%@ include file = "/WEB-INF/views/adminPage/adminPageHeader.jsp" %>
        <div class="main-container">
            <div class="main-content">
                <div class="main-header">
                    <h1>전체 회원 관리</h1>
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
                            <%for(Member member: list) {%>    
                            	 <tr>
	                                <td><input type="checkbox" class="chk"></td>
	                                <td><%=member.getMemberNo() %></td>
	                                <td><%=member.getMemberId() %></td>
	                                <td><%=member.getMemberName() %></td>
	                                <td><%=member.getMemberPhone() %></td>
	                                <td>
	                                <%if(member.getMemberLevel() == 1) {%>
	                                	<select class="input">
	                                        <option value="1" selected>운영자</option>
	                                        <option value="2">호스트</option>
	                                        <option value="3">회원</option>
	                                    </select>
	                                <%} else if(member.getMemberLevel() == 2) {%>
	                                	<select class="input">
	                                        <option value="1">운영자</option>
	                                        <option value="2" selected>호스트</option>
	                                        <option value="3">회원</option>
	                                    </select>
	                                <%} else if(member.getMemberLevel() == 3) {%>
	                                	<select class="input">
	                                        <option value="1" selected>운영자</option>
	                                        <option value="2">호스트</option>
	                                        <option value="3" selected>회원</option>
	                                    </select>
	                                <%} %>                                    
	                                </td>
	                                <td><%=member.getEnrollDate() %></td>
	                                <td><button class="btc bc33 bs4 chageLevel">회원등급변경</button></td>
	                                <td><button class="btc bc33 bs4 withdrawal">탈퇴</button></td>
	                            </tr>
                            <%} %>                                             
                        </table>
                        <div class="page_wrap">
                            <div class="page_nation">
                                <a class="arrow pprev" href="#">
                                    < </a>
                                        <a class="arrow prev" href="#">
                                            < </a>
                                                <a href="#" class="active">1</a>
                                                <a href="#">2</a>
                                                <a href="#">3</a>
                                                <a href="#">4</a>
                                                <a href="#">5</a>
                                                <a href="#">6</a>
                                                <a href="#">7</a>
                                                <a href="#">8</a>
                                                <a href="#">9</a>
                                                <a href="#">10</a>
                                                <a class="arrow next" href="#">></a>
                                                <a class="arrow nnext" href="#">></a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="card">
                    <button class="select-btn checkedChangeLevel">선택회원등급변경</button>
                    <button class="select-btn checkedWithdrawal">선택회원탈퇴</button>
                </div>
                <div class="card">
                    <p>㈜프렌트립 | 사업자 등록번호 : 261-81-04385|통신판매업신고번호 : 2016-서울성동-01088
                        대표 : 임수열|개인정보 관리 책임자 : 양사열|서울시 성동구 왕십리로 115 헤이그라운드 서울숲점 G703
                        ㈜프렌트립은 통신판매중개자로서 거래당사자가 아니며, 호스트가 등록한 상품정보 및 거래에 대해 ㈜프렌트립은 일체의 책임을 지지 않습니다.</p>
                </div>
            </div>
        </div>
    </div>
    <script>
	    $(".chageLevel").on("click", function () {
	        const memberNo = $(this).parent().parent().children().eq(1).text(); // 회원 번호	       
	        const memberLevel = $(this).parent().parent().children().eq(5).children().val(); // 회원 등급       
	      
	        location.href = "/changeLevel.do?memberNo=" + memberNo + "&memberLevel=" + memberLevel;
	    });
    </script>
    <!-- sidebar.js -->
    <script src="/js/adminPage/sidebar.js"></script>
</body>
</html>