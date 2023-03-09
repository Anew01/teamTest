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
					<form id="commentFrm" action="/insertFeedComment.do" method="post">
						<div class="input-group">
							<input type="hidden" name="feedWriter" value="user01">
							<input type="hidden" name="fripNo" value="<%= list.get(0).getF().getFripNo() %>">
							<input type="hidden" name="fdNo">
							<textarea class="form-control" name="feedContent" aria-label="With textarea" style="resize: none;"></textarea>
							<button type="submit" class="btn btn-outline-secondary">댓글등록</button>
						</div>
					</form>
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
								<input type="hidden" name="fbNo" value="<%= data.getF().getFeedNo() %>">
								<button class="btn btn-secondary" type="button" onclick="inserFrm(this)">댓글달기</button>
							</div>
						</div>
						<% for(ViewFripFeedData commentData : list) { %>
							<% if(commentData.getF().getFdNo() != 0 && commentData.getF().getFdNo() == data.getF().getFeedNo()) { %>
								<img src="/upload/photo/arrow.svg" style="width: 60px; margin-left: 20px;"></img>
								<div class="feed-comment-box">
									<div class="writer-info">
										<div class="img-wrap">
											<%if(commentData.getMemProfilepath() != null) { %>
												<img src="/upload/member/<%=commentData.getMemProfilepath()%>">
											<% } else {%>
												<img src="/upload/member/no-profile.png">
											<% } %>
										</div>
										<div class="writer-id-wrap">
											<span id="writer-id"><%= commentData.getF().getFeedWriter() %></span>
										</div>								
									</div>
									<div class="feed-content">
										<div class="content-wrap">
											<%= commentData.getF().getFeedContent() %>
										</div>
										<button class="btn btn-primary updateFeedCommentBtn" type="button">댓글수정</button>
										<button class="btn btn-danger deleteFeedCommentBtn" type="button">댓글삭제</button>
									</div>
								</div>
							<% } %>
						<% } %>
					<% } %>
				<% } %>
			</div>
		</div>
	</div>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
	<script>
		function inserFrm(obj){
			const form = $("#commentFrm").clone().css("display","block");
			const fbNo = $(obj).prev().val();
			form.find("input[name=fdNo]").val(fbNo);
			$(obj).parents(".feed-box").after(form);		
			$(obj).text("댓글취소");
			$(obj).attr("onclick","cancelFrm(this)")
		}
		
		function cancelFrm(obj){
			$(obj).parents(".feed-box").next().remove();
			$(obj).text("댓글등록");
			$(obj).attr("onclick","inserFrm(this)");
		}
	</script>
</body>
</html>