<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!doctype html>
    <html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        
         <script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
    	 <link rel="stylesheet" href="/css/adminPage/accrodionmenu.css">
    	 
        <title>Bootstrap Example</title>
    </head>

    <body>

      <div class="menu">
        <ul class="main-menu">
            <li><a href="#">프로필 관리</a></li>
            <li><a href=" #">전체회원관리</a></li>
            <li><a href="">프립/피드관리</a></li>
            <li>
                <a href="#">FrontEnd</a>
                <ul class="sub-menu">
                    <li><a href="#">HTML5</a></li>
                    <li><a href="#">CSS3</a></li>
                    <li><a href="#">JavaScript</a></li>
                    <li>
                        <a href="#">jQuery</a>
                        <ul class="sub-menu">
                            <li><a href="#">객체탐색</a></li>
                            <li><a href="#">객체조작</a></li>
                            <li><a href="#">이벤트</a></li>
                            <li><a href="#">효과</a></li>
                        </ul>
                    </li>
                </ul>
            </li>
            <li><a href="#">Server</a></li>
            <li>
                <a href="#">Framework</a>
                <ul class="sub-menu">
                    <li><a href="#">Mybatis</a></li>
                    <li><a href="#">Spring</a></li>
                </ul>
            </li>
        </ul>
    </div>
    <script src="/js/adminPage/accrodionmenu.js"></script>
    </body>

    </html>