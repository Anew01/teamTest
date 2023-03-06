<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html lang="ko" dir="ltr">

    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="/css/adminPage/sidebar.css">
        <!-- 폰트 어썸 -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css"
            integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ=="
            crossorigin="anonymous" referrerpolicy="no-referrer" />
        <!-- jquery -->
        <!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" charset="utf-8"></script> -->
        <script src="https://code.jquery.com/jquery-3.6.3.js"></script>
        <!-- 구글 폰트 -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Lobster&family=Nanum+Gothic&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

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
                        <a href="/allMember.do?reqPage=1" class="menu-btn">
                            <i class="fa-solid fa-users"></i><span>전체회원 관리
                        </a>
                    </li>
                    <li class="item" id="messages">
                        <a href="/firpAndFeed.do?fripReqPage=1&feedReqPage=1" class="menu-btn">
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
                            <a href="/noticeWriteFrm.do"><i class="fa-solid fa-pen-nib"></i><span>공지사항 작성</span></a>
                            <a href="/noticeList.do?reqPage=1"><i class="fa-solid fa-list"></i><span>공지사항 목록</span></a>
                        </div>
                    </li>
                    <li class="item">
                        <a href="/inqury.do" class="menu-btn">
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
    </body>

    </html>