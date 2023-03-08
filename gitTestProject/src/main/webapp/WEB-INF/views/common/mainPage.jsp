<%@page import="kr.or.iei.frip.vo.Frip"%>
<%@page import="java.util.ArrayList"%>
<%
    	ArrayList<Frip> list = (ArrayList<Frip>)request.getAttribute("list");
    	ArrayList<Frip> rList = (ArrayList<Frip>)request.getAttribute("rList");
    	
    %>
<!doctype html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <style>
    	.carousel-item img{
    		width: 1000px;
    		height: 500px;
    	}
    	.fuck{
    		width : 80%;
    		margin : 0 auto;
    		height : 375px;
    		margin-top : 30px;
    	}
    </style>
  </head>
  
  <body>
  <%@include file="/WEB-INF/views/common/header.jsp" %>
  <div class="fuck"></div>
  <%--
  <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="true">
  <div class="carousel-indicators">
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
  </div>
  <div class="carousel-inner" style="width:1000px; margin: 0 auto;">
    <div class="carousel-item active">
      <img src="/upload/photo/3d273f6b-33f3-4aa4-9276-952a2488daca.jpg" class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="/upload/photo/3d273f6b-33f3-4aa4-9276-952a2488daca.jpg" class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="/upload/photo/3d273f6b-33f3-4aa4-9276-952a2488daca.jpg" class="d-block w-100" alt="...">
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
     --%>
    <%@include file="/WEB-INF/views/common/footer.jsp" %>
  </body>
</html>