<%@page import="kr.or.iei.feed.vo.ViewFripFeedData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	ArrayList<ViewFripFeedData> list = (ArrayList<ViewFripFeedData>)request.getAttribute("list");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/feedPage/myFeedList.css">
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<div class="page-content">
		<%@include file="/WEB-INF/views/frip/fripSideBar.jsp" %>
		<div class="content">
			<div class="feed-wrap">
				<% if(list.size() > 0) { %>
					<% for(ViewFripFeedData data : list) { %>
						<div class="feed-box">
							<div class="writer-info">
								<div class="img-wrap">
									<%if(data.getMemProfilepath() != null) { %>
										<img src="/upload/member/<%=data.getMemProfilepath()%>">
									<% } else {%>
										<img src="/upload/member/no-profile.png">
									<% } %>
								</div>
								<div class="writer-id-wrap">
									<span id="writer-id"><%= data.getF().getFeedWriter() %></span>
								</div>								
							</div>
							<div class="feed-content">
								<div class="content-wrap">
									<%= data.getF().getFeedContent() %>
								</div>
								<button class="btn btn-primary" type="button" id="feedCommentBtn">댓글달기</button>
							</div>
						</div>
						<% if(data.getF().getFdNo() != 0) { %>
						<div class="feed-comment-wrap">
							<div class="writer-info">
								<div class="img-wrap">
									<%if(data.getMemProfilepath() != null) { %>
										<img src="/upload/member/<%=data.getMemProfilepath()%>">
									<% } else {%>
										<img src="/upload/member/no-profile.png">
									<% } %>
								</div>
								<div class="writer-id-wrap">
									<span id="writer-id"><%= data.getF().getFeedWriter() %></span>
								</div>								
							</div>
							<div class="comment-content">
								<div class="content-wrap">
									<%= data.getF().getFeedContent() %>
								</div>
							</div>
						</div>
						<% } %>
					<% } %>
				<% } %>
			</div>
		</div>
	</div>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
	<script>
		$("#feedCommentBtn").on("click", function(){
			const div = $("<div>");
			const form = $("<form>");
			form.attr("action","/insertFeed.do")
			div.addClass("write-feed-comment-wrap");
			const textArea = $("<textarea>");
			div.append(textArea);
			$(this).parents(".feed-box").append(div);
		})
	</script>
</body>
</html>