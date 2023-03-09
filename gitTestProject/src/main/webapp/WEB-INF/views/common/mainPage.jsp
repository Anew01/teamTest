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
    <link rel="stylesheet" href="/css/main/main.css">
    
</head>
<body>
    <%@include file="/WEB-INF/views/common/header.jsp" %>
    <div>
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
    <div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
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
            <div class="col">
              <div class="card shadow-sm">
              	<%if(f.getFilePath().size() != 0){ %>
              		<%for(int i=0; i<1; i++){ %>
					<svg class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Image" preserveAspectRatio="xMidYMid meet" focusable="false">
					<title>Image</title>
					<image href="/upload/photo/<%=f.getFilePath().get(0)%>" width="100%" height="100%" preserveAspectRatio="xMidYMid meet" />
					</svg>
                	<%} %>
               	<%} else { %>
               		<svg class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder:" preserveAspectRatio="xMidYMid slice" focusable="false">
  					<title>Placeholder</title>
  					<image href="/upload/photo/no-photo.png" width="100%" height="100%" preserveAspectRatio="xMidYMid slice" />
 					<text x="50%" y="50%" fill="#eceeef" dy=".3em"></text>
					</svg>
              	<%} %>
                <div class="card-body">
                  <p class="card-text"><%=f.getFripTitle() %></p>
                  <p class="card-text"><%=f.getFripWriter() %></p>
                  <div class="d-flex justify-content-between align-items-center">
                    <div class="btn-group">
                      <button type="submit" class="btn btn-sm btn-outline-secondary">참여</button>
                    </div>
                    <small class="text-muted">★<%=f.getAvgRating() %></small>
                  </div>
                </div>
              </div>
            </div>
            </form>
            <%} %>
            
            <!--신작-->
          </div>
          <div>
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
            <div class="col">
              <div class="card shadow-sm">
              	<%if(nf.getFilePath().size() != 0){ %>
              		<%for(int i=0; i<1; i++){ %>
					<svg class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Image" preserveAspectRatio="xMidYMid meet" focusable="false">
					<title>Image</title>
					<image href="/upload/photo/<%=nf.getFilePath().get(0)%>" width="100%" height="100%" preserveAspectRatio="xMidYMid meet" />
					</svg>
                	<%} %>
               	<%} else { %>
               		<svg class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder:" preserveAspectRatio="xMidYMid slice" focusable="false">
  					<title>Placeholder</title>
  					<image href="/upload/photo/no-photo.png" width="100%" height="100%" preserveAspectRatio="xMidYMid slice" />
 					<text x="50%" y="50%" fill="#eceeef" dy=".3em"></text>
					</svg>
              	<%} %>
                <div class="card-body">
                  <p class="card-text"><%=nf.getFripTitle() %></p>
                  <p class="card-text"><%=nf.getFripWriter() %></p>
                  <div class="d-flex justify-content-between align-items-center">
                    <div class="btn-group">
                      <button type="submit" class="btn btn-sm btn-outline-secondary">참여</button>
                    </div>
                    <small class="text-muted">★<%=nf.getAvgRating() %></small>
                  </div>
                </div>
              </div>
            </div>
            </form>
            <%} %>
   <%@include file="/WEB-INF/views/common/footer.jsp" %>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>