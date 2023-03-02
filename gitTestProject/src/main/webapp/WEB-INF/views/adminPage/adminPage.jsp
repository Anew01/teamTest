<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko" dir="ltr">
<head>
<meta charset="UTF-8">
<title>adminPage</title>

 	<link rel="stylesheet" href="/css/adminPage/sidebar.css">
 	<link rel="stylesheet" href="/css/adminPage/profile.css">
    <!-- 폰트 어썸 -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css"
        integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
    <!-- jquery -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" charset="utf-8"></script>
    <!-- 구글 폰트 -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Lobster&family=Nanum+Gothic&display=swap" rel="stylesheet">
</head>
<body>
	 <div class="wrapper">
        <div class="header">
            <div class="header-menu">
                <div class="title"><span>Sprip</span> Admin</div>
                <div class="sidebar-btn">
                    <i class="fas fa-bars"></i>
                </div>
                <ul>
                    <li><a href="#"><i class="fa-solid fa-user"></i></a></li>
                    <li><a href="#"><i class="fa-solid fa-right-from-bracket"></i></a></li>
                </ul>
            </div>
        </div>
        <div class="sidebar">
            <div class="sidebar-menu">
                <center class="profile">
                    <img src="/upload/admin/user.png" alt="">
                    <p>관리자 1</p>
                </center>
                <li class="item">
                    <a href="/adminPage.do" class="menu-btn">
                        <i class="fa-solid fa-user"></i><span>프로필 관리</span>
                    </a>
                </li>
                  <li class="item" id="profile">
                    <a href="/allMember.do" class="menu-btn">
                        <i class="fa-solid fa-users"></i><span>전체회원 관리
                    </a>
                </li>
                 <li class="item" id="messages">
                    <a href="#messages" class="menu-btn">
                        <i class="fa-brands fa-flipboard"></i>
                        <span>프립/피드 관리</span>
                    </a>
                </li>
                 <li class="item" id="settings">
                    <a href="#settings" class="menu-btn">
                        <i class="fa-solid fa-bell"></i><span>공지사항 관리 <i
                                class="fas fa-chevron-down drop-down"></i></span>
                    </a>
                    <div class="sub-menu">
                        <a href="#"><i class="fa-solid fa-pen-nib"></i><span>공지사항 작성</span></a>
                        <a href="#"><i class="fa-solid fa-list"></i><span>공지사항 목록</span></a>
                    </div>
                </li>
                <li class="item">
                    <a href="#" class="menu-btn">
                        <i class="fa-solid fa-question"></i><span>문의 관리</span>
                    </a>
                </li>
                <li class="item">
                    <a href="#" class="menu-btn">
                        <i class="fa-solid fa-tags"></i><span>쿠폰 관리</span>
                    </a>
                </li>
            </div>
        </div>
         <div class="main-container">
            <div class="main-content">
                <div class="main-header">
                    <h1>프로필 관리</h1>
                </div>
                <div class="card">
                    <div>
                        <table class="profile-table">
                            <tr>
                                <img src="./user.png" class="profile-image">
                                <th><label for="" class="adminLabel">아이디</label></th>
                                <td><input type="text" name="name" class="adminInput" value="alstq" readonly></td>
                            </tr>
                            <tr>
                                <th>프로필 사진</th>
                                <td><input type="text"></td>
                            </tr>
                            <tr>
                                <th>프로필 사진</th>
                                <td><input type="text"></td>
                            </tr>
                            <tr>
                                <th>프로필 사진</th>
                                <td><input type="text"></td>
                            </tr>
                            <tr>
                                <th>프로필 사진</th>
                                <td><input type="text"></td>
                            </tr>
                            <tr>
                                <th>프로필 사진</th>
                                <td><input type="text"></td>
                            </tr>
                        </table>
                    </div>
                </div>
                <div class="card">
                    <p>㈜프렌트립 | 사업자 등록번호 : 261-81-04385|통신판매업신고번호 : 2016-서울성동-01088
                        대표 : 임수열|개인정보 관리 책임자 : 양사열|서울시 성동구 왕십리로 115 헤이그라운드 서울숲점 G703
                        ㈜프렌트립은 통신판매중개자로서 거래당사자가 아니며, 호스트가 등록한 상품정보 및 거래에 대해 ㈜프렌트립은 일체의 책임을 지지 않습니다.</p>
                </div>
            </div>
        </div>
    </div>
    <!-- sidebar.js -->
    <script src="/js/adminPage/sidebar.js"></script>
</body>
</html>