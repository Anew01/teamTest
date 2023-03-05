<%@page import="kr.or.iei.member.vo.Member"%>
<%@page import="kr.or.iei.frip.vo.Frip"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%
    	Member loginMember = (Member)session.getAttribute("m");
    %>
	<!--폰트-->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <!--로고용 lobster폰트 링크-->
    <link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
    <!--전체 기본 폰트 나눔고딕 링크-->
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@700&display=swap" rel="stylesheet">
    <!--아이콘 링크-->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    <!--jQuery-->
    <script src="/js/jquery-3.6.3.min.js"></script>
    <!--bootstrap-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    <!--기본css-->
    <link rel="stylesheet" href="/css/mokupCss/mockup.css">
    <header>
    <div class="header">
        <div class="header-content-top">
            <div class="header-logo"><a href="/selectAllFripByCategory.do?categoryName=all" class="homeBtn"><span class="logo-text">Sprip</span></a></div>
            <div class="header-searchBar">
                <div class="input-group mb-3">
                    <input type="text" class="form-control" placeholder="Search" aria-label="Recipient's username" aria-describedby="button-addon2">
                    <button class="btn btn-outline-secondary" type="button" id="button-addon2">입력</button>
                </div>
            </div>
            <div class="header-button">
                <div class="btn-group btn-group-sm" role="group" aria-label="Small button group">
                	<form action="/feedList.do" method="post">
                    <button type="submit" class="btn btn-outline-dark">피드</button>
                    </form>
                    <button type="button" class="btn btn-outline-dark">Middle</button>
        <% if (loginMember==null){ %>
        <a href="/loginFrm.do">로그인</a>
        <%}else{ %>
        <%-- 
        <a href="/myInfo.do?memberId=<%=member.getMemberId() %>">마이페이지</a>
        --%>
        <a href="/myInfo.do?memberId=<%=loginMember.getMemberId() %>">마이페이지</a>
        <%} %>
                  </div>
                </div>
            </div>
        </div>
        <div class="header-content-bottom">
            <div class="category-bar">
                <ul class="category-list">
                    <li><a href="/selectAllFripByCategory.do?categoryName=all" id="allBtn"><img src="/categoryImg/ALL.png" ><div class="img-text"><span>ALL</span></div></a></li>
                    <li><a href="/selectAllFripByCategory.do?categoryName=아웃도어"><img src="/categoryImg/아웃도어.jpg" ><div class="img-text"><span>아웃도어</span></div></a></li>
                    <li><a href="/selectAllFripByCategory.do?categoryName=피트니스"><img src="/categoryImg/피트니스.png" ><div class="img-text"><span>피트니스</span></div></a></li>
                    <li><a href="/selectAllFripByCategory.do?categoryName=DIY"><img src="/categoryImg/DIY.png" ><div class="img-text"><span>공예DIY</span></div></a></li>
                    <li><a href="/selectAllFripByCategory.do?categoryName=스포츠"><img src="/categoryImg/스포츠1.png" ><div class="img-text"><span>스포츠</span></div></a></li>
                    <li><a href="/selectAllFripByCategory.do?categoryName=요리"><img src="/categoryImg/요리.png" ><div class="img-text"><span>요리</span></div></a></li>
                    <li><a href="/selectAllFripByCategory.do?categoryName=온라인"><img src="/categoryImg/온라인.png" ><div class="img-text"><span>온라인</span></div></a></li>
                    <li><a href="/selectAllFripByCategory.do?categoryName=자기계발"><img src="/categoryImg/자기계발.png" ><div class="img-text"><span>자기계발</span></div></a></li>
                    <li><a href="/selectAllFripByCategory.do?categoryName=뷰티"><img src="/categoryImg/뷰티.png" ><div class="img-text"><span>뷰티</span></div></a></li>
                    <li><a href="/selectAllFripByCategory.do?categoryName=모임"><img src="/categoryImg/모임.png" ><div class="img-text"><span>모임</span></div></a></li>
                    <li><a href="/selectAllFripByCategory.do?categoryName=국내여행"><img src="/categoryImg/국내여행.png" ><div class="img-text"><span>국내여행</span></div></a></li>
                    <li><a href="/selectAllFripByCategory.do?categoryName=해외여행"><img src="/categoryImg/해외여행.png" ><div class="img-text"><span>해외여행</span></div></a></li>
                </ul>
            </div>
        </div>        
    </div>
    </header>