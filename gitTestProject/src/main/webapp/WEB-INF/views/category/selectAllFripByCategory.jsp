<%-- <%@page import="kr.or.iei.frip.vo.FripJoinableDate"%> --%>
<%@page import="kr.or.iei.frip.vo.FripJoinableDate"%>
<%@page import="kr.or.iei.frip.vo.Frip"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    ArrayList<Frip> list = (ArrayList<Frip>)request.getAttribute("list");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="/css/mokupCss/Frip.css">
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
    <div class="album py-5 bg-light">
        <div class="container">
          <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
          <%for(Frip f : list){ %>
			<form action="/joinFrip.do?fripNo=<%=f.getFripNo()%>" method="post"> 
			<% if(loginMember != null) { %>
					<input type="hidden" name="loginMemNo" value="<%= loginMember.getMemberNo() %>">         
   				<% } else { %>
   					<input type="hidden" name="loginMemNo" value=0>         
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
                    <small class="text-muted" style="line-height:20px;"><img src="/mainImage/star.png" style="width : 20px; height : 20px; margin-right : 5px; vertical-align: middle; font-weight: 900; "><%=f.getAvgRating() %></small>
                  </div>
                  </div>
              </div>
            </div>
            </form>
            <%} %>
            </div>
            </div>
            </div>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>