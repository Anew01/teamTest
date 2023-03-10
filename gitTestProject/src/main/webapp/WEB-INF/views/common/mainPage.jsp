<%@page import="kr.or.iei.frip.vo.FripJoinableDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	ArrayList<Frip> list = (ArrayList<Frip>)request.getAttribute("rList");
    	ArrayList<Frip> nList = (ArrayList<Frip>)request.getAttribute("nList");
    %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
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
    <link rel="canonical" href="https://getbootstrap.com/docs/5.2/examples/carousel/"><!--앨범-->
    <!--기본css-->
    <!-- <link rel="stylesheet" href="/css/main/main.css"> -->
    <link rel="stylesheet" href="/css/mokup/mokup.css">
    <style>
    .carousel {
    position: relative;
}

.carousel.pointer-event {
    touch-action: pan-y;
}

.carousel-inner {
    position: relative;
    width: 100%;
    overflow: hidden;
}

.carousel-inner::after {
    display: block;
    clear: both;
    content: "";
}

.carousel-item {
    position: relative;
    display: none;
    float: left;
    width: 100%;
    margin-right: -100%;
    -webkit-backface-visibility: hidden;
    backface-visibility: hidden;
    transition: transform 0.6s ease-in-out;
}

@media (prefers-reduced-motion: reduce) {
    .carousel-item {
        transition: none;
    }
}

.carousel-item.active,
.carousel-item-next,
.carousel-item-prev {
    display: block;
}

.carousel-item-next:not(.carousel-item-start),
.active.carousel-item-end {
    transform: translateX(100%);
}

.carousel-item-prev:not(.carousel-item-end),
.active.carousel-item-start {
    transform: translateX(-100%);
}

.carousel-fade .carousel-item {
    opacity: 0;
    transition-property: opacity;
    transform: none;
}

.carousel-fade .carousel-item.active,
.carousel-fade .carousel-item-next.carousel-item-start,
.carousel-fade .carousel-item-prev.carousel-item-end {
    z-index: 1;
    opacity: 1;
}

.carousel-fade .active.carousel-item-start,
.carousel-fade .active.carousel-item-end {
    z-index: 0;
    opacity: 0;
    transition: opacity 0s 0.6s;
}

@media (prefers-reduced-motion: reduce) {

    .carousel-fade .active.carousel-item-start,
    .carousel-fade .active.carousel-item-end {
        transition: none;
    }
}

.carousel-control-prev,
.carousel-control-next {
    position: absolute;
    top: 0;
    bottom: 0;
    z-index: 1;
    display: flex;
    align-items: center;
    justify-content: center;
    width: 15%;
    padding: 0;
    color: #fff;
    text-align: center;
    background: none;
    border: 0;
    opacity: 0.5;
    transition: opacity 0.15s ease;
}

@media (prefers-reduced-motion: reduce) {

    .carousel-control-prev,
    .carousel-control-next {
        transition: none;
    }
}

.carousel-control-prev:hover,
.carousel-control-prev:focus,
.carousel-control-next:hover,
.carousel-control-next:focus {
    color: red;
    text-decoration: none;
    outline: 0;
    opacity: 0.9;
}

.carousel-control-prev {
    left: 100px !important;
}

.carousel-control-next {
    right: 100px !important;
}

.carousel-control-prev-icon,
.carousel-control-next-icon {
    display: inline-block;
    width: 2rem;
    height: 2rem;
    background-repeat: no-repeat;
    background-position: 50%;
    background-size: 100% 100%;
}

/* rtl:options: {
    "autoRename": true,
    "stringMap":[ {
      "name"    : "prev-next",
      "search"  : "prev",
      "replace" : "next"
    } ]
  } */

.carousel-indicators {
    position: absolute;
    right: 0;
    bottom: 0;
    left: 0;
    z-index: 2;
    display: flex;
    justify-content: center;
    padding: 0;
    margin-right: 15%;
    margin-bottom: 1rem;
    margin-left: 15%;
    list-style: none;
}

.carousel-indicators [data-bs-target] {
    box-sizing: content-box;
    flex: 0 1 auto;
    width: 30px;
    height: 3px;
    padding: 0;
    margin-right: 3px;
    margin-left: 3px;
    text-indent: -999px;
    cursor: pointer;
    background-color: #fff;
    background-clip: padding-box;
    border: 0;
    border-top: 10px solid transparent;
    border-bottom: 10px solid transparent;
    opacity: 0.5;
    transition: opacity 0.6s ease;
}

@media (prefers-reduced-motion: reduce) {
    .carousel-indicators [data-bs-target] {
        transition: none;
    }
}

.carousel-indicators .active {
    opacity: 1;
}

.carousel-caption {
    position: absolute;
    right: 15%;
    bottom: 1.25rem;
    left: 15%;
    padding-top: 1.25rem;
    padding-bottom: 1.25rem;
    color: #fff;
    text-align: center;
}

.carousel-dark .carousel-control-prev-icon,
.carousel-dark .carousel-control-next-icon {
    filter: invert(1) grayscale(100);
}

.carousel-dark .carousel-indicators [data-bs-target] {
    background-color: #000;
}

.carousel-dark .carousel-caption {
    color: #000;
}

.visually-hidden,
.visually-hidden-focusable:not(:focus):not(:focus-within) {
    position: absolute !important;
    width: 1px !important;
    height: 1px !important;
    padding: 0 !important;
    margin: -1px !important;
    overflow: hidden !important;
    clip: rect(0, 0, 0, 0) !important;
    white-space: nowrap !important;
    border: 0 !important;
}

.carousel-inner{
    width: 70% !important;
    height: 500px;
    margin: 0 auto;
    z-index : 0;
}
.w-100 {
    width: 100% !important;
    height: 500px;
}
.carousel-control-prev-icon { 
    background-image: url("data:image/svg+xml;charset=utf8,%3Csvg xmlns='http://www.w3.org/2000/svg' fill='%23000' viewBox='0 0 8 8'%3E%3Cpath d='M5.25 0l-4 4 4 4 1.5-1.5-2.5-2.5 2.5-2.5-1.5-1.5z'/%3E%3C/svg%3E"); 
 }
 .carousel-control-next-icon {
    background-image: url("data:image/svg+xml;charset=utf8,%3Csvg xmlns='http://www.w3.org/2000/svg' fill='%23000' viewBox='0 0 8 8'%3E%3Cpath d='M2.75 0l-1.5 1.5 2.5 2.5-2.5 2.5 1.5 1.5 4-4-4-4z'/%3E%3C/svg%3E"); 
 }

/*캐러셀 종료*/
    </style>
</head>
<body>
    <%@include file="/WEB-INF/views/common/header.jsp" %>
    <div class="all-wrap">
      <section class="py-5 text-center container">
        <div class="row py-lg-5">
          <div class="col-lg-6 col-md-8 mx-auto">
            <h1 class="fw-light">EVENT</h1>
            <p class="lead text-muted">이벤트 문구
            </p>
          </div>
        </div>
      </section>
    <!--캐러셀시작-->
    <div id="carouselExampleControls" class="carousel carousel-dark slide" data-bs-ride="carousel">
      <div class="carousel-inner">
        <div class="carousel-item active">
          <img src="/mainImage/bom.png" class="d-block w-100" alt="...">
        </div>
        <div class="carousel-item">
          <img src="/mainImage/san.png" class="d-block w-100" alt="...">
        </div>
        <div class="carousel-item">
          <img src="/mainImage/fuck.png" class="d-block w-100" alt="...">
        </div>
      </div>
      <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="false"></span>
        <span class="visually-hidden">Previous</span>
      </button>
      <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
      </button>
    </div>
    <!--캐러셀종료-->
    <!--BEST-->
      <section class="py-5 text-center container">
        <div class="row py-lg-5">
          <div class="col-lg-6 col-md-8 mx-auto">
            <h1 class="fw-light">BEST SPRIP</h1>
            <p class="lead text-muted">3월의 BEST SPRIP
            </p>
          </div>
        </div>
      </section>
      <!--앨범카드-->
     <div class="album py-5 bg-light">
        <div class="container">
          <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
          <%for(Frip f : list){ %>
   			<form action="/joinFrip.do?fripNo=<%=f.getFripNo()%>" method="post"> 
   			<% if(loginMember != null  && loginMember.getMemberNo() != 0) { %>
					<input type="hidden" name="loginMemNo" value="<%= loginMember.getMemberNo() %>">         
   				<% } else { %>
   					<input type="hidden" name="loginMemNo" value="0">         
   				<% } %> 
            <div class="col">
              <div class="card shadow-sm">
              	<%if(f.getFilePath().size() != 0){ %>
              		<%for(int i=0; i<1; i++){ %>
					<svg class="bd-placeholder-img card-img-top" width="100%" height="300" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Image" preserveAspectRatio="none" focusable="false">
					<title>Image</title>
					<image href="/upload/photo/<%=f.getFilePath().get(0)%>" width="100%" height="100%" preserveAspectRatio="none" />
					<text x="50%" y="%" fill="#eeef" dy=".3em"></text>
					</svg>
                	<%} %>
               	<%} else { %>
               		<svg class="bd-placeholder-img card-img-top" width="100%" height="300" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Image" preserveAspectRatio="none" focusable="false">
					<title>Image</title>
					<image href="/mainImage/springImg.png" width="100%" height="100%" preserveAspectRatio="none" />
					<text x="50%" y="%" fill="#eeef" dy=".3em"></text>
					</svg>
              	<%} %>
                <div class="card-body" style="height : 13rem;">
                  <div class="card-text"><h5><%=f.getFripTitle() %></h5></div>
                  <span class="card-text"><h6>장르 : <%=f.getFripCategory() %></h6></span>
                  <span class="card-text"><h6>장소 : <%=f.getFripAddr() %></h6></span>
                  <span class="card-text"><h6>호스트 : <%=f.getFripWriter() %></h6></span>
                  <%for(int q=0; q<1; q++){ %>
               	<%FripJoinableDate fjd = f.getJoinableDates().get(q); %>
            	<span class="card-text"><h6>기간 : <%=fjd.getStartDate() %> ~ <%=fjd.getEndDate() %></h6></span>
            	<span class="card-text"><h6>가격 : <%=f.getFripPrice() %>원/1인</h6></span>
            	<%} %>
                </div>
                  <div class=card-footer>
                  <div class="d-flex justify-content-between align-items-center">
                    <div class="btn-group">
                      <button type="submit" class="btn btn-m btn-outline-secondary">참여</button>
                    </div>
					<%if(f.getAvgRating() != null){ %>
                    <small class="text-muted" style="line-height:20px;"><img src="/mainImage/star.png" style="width : 20px; height : 20px; margin-right : 5px; vertical-align: middle; font-weight: 900; "><%=f.getAvgRating() %></small>
                    <%} else { %>
                    <small class="text-muted" style="line-height:20px;"><img src="/mainImage/star.png" style="width : 20px; height : 20px; margin-right : 5px; vertical-align: middle; font-weight: 900; ">0.0</small>
                    <%} %>
                  </div>
                  </div>
              </div>
            </div>
            </form>
            <%} %>
            </div>
            </div>
            </div>
            
            <!--신작-->
          
            <section class="py-5 text-center container">
              <div class="row py-lg-5">
                <div class="col-lg-6 col-md-8 mx-auto">
                  <h1 class="fw-light">NEW SPRIP</h1>
                  <p class="lead text-muted">새로올라온 스프립을 만나보세요
                  </p>
                                </div>
              </div>
            </section>
            <!--앨범카드-->
            <div class="album py-5 bg-light">
        <div class="container">
          <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
          <%for(Frip nf : nList){ %>
			<form action="/joinFrip.do?fripNo=<%=nf.getFripNo()%>" method="post"> 
			<% if(loginMember != null  && loginMember.getMemberNo() != 0) { %>
					<input type="hidden" name="loginMemNo" value="<%= loginMember.getMemberNo() %>">         
   				<% } else { %>
   					<input type="hidden" name="loginMemNo" value="0">         
   				<% } %>          
            <div class="col">
              <div class="card shadow-sm">
              	<%if(nf.getFilePath().size() != 0){ %>
              		<%for(int i=0; i<1; i++){ %>
					<svg class="bd-placeholder-img card-img-top" width="100%" height="300" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Image" preserveAspectRatio="none" focusable="false">
					<title>Image</title>
					<image href="/upload/photo/<%=nf.getFilePath().get(0)%>" width="100%" height="100%" preserveAspectRatio="none" />
					<text x="50%" y="%" fill="#eeef" dy=".3em"></text>
					</svg>
                	<%} %>
               	<%} else { %>
               		<svg class="bd-placeholder-img card-img-top" width="100%" height="300" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Image" preserveAspectRatio="none" focusable="false">
					<title>Image</title>
					<image href="/mainImage/springImg.png" width="100%" height="100%" preserveAspectRatio="none" />
					<text x="50%" y="%" fill="#eeef" dy=".3em"></text>
					</svg>
              	<%} %>
                <div class="card-body" style="height : 13rem;">
                  <div class="card-text"><h5><%=nf.getFripTitle() %></h5></div>
                  <span class="card-text"><h6>장르 : <%=nf.getFripCategory() %></h6></span>
                  <span class="card-text"><h6>장소 : <%=nf.getFripAddr() %></h6></span>
                  <span class="card-text"><h6>호스트 : <%=nf.getFripWriter() %></h6></span>
                  <%for(int q=0; q<1; q++){ %>
               	<%FripJoinableDate fjd = nf.getJoinableDates().get(q); %>
            	<span class="card-text"><h6>기간 : <%=fjd.getStartDate() %> ~ <%=fjd.getEndDate() %></h6></span>
            	<span class="card-text"><h6>가격 : <%=nf.getFripPrice() %>원/1인</h6></span>
            	<%} %>
                </div>
                  <div class=card-footer>
                  <div class="d-flex justify-content-between align-items-center">
                    <div class="btn-group">
                      <button type="submit" class="btn btn-m btn-outline-secondary">참여</button>
                    </div>
                    <%if(nf.getAvgRating() != null){ %>
                    <small class="text-muted" style="line-height:20px;"><img src="/mainImage/star.png" style="width : 20px; height : 20px; margin-right : 5px; vertical-align: middle; font-weight: 900; "><%=nf.getAvgRating() %></small>
                    <%} else { %>
                    <small class="text-muted" style="line-height:20px;"><img src="/mainImage/star.png" style="width : 20px; height : 20px; margin-right : 5px; vertical-align: middle; font-weight: 900; ">0.0</small>
                    <%} %>
                  </div>
                  </div>
              </div>
            </div>
            </form>
            <%} %>
            </div>
            </div>
            </div>
            </div>
   <%@include file="/WEB-INF/views/common/footer.jsp" %>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>