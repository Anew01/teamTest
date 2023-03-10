<%@page import="kr.or.iei.member.vo.Member"%>
<%@page import="kr.or.iei.frip.vo.Frip"%>
<%@page import="kr.or.iei.feed.vo.Feed"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    Frip frip = (Frip)request.getAttribute("f");
    Member feedMember = (Member)session.getAttribute("m");
    String memberId = request.getParameter("memberId");
    Feed feed = (Feed)request.getAttribute("feed");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/summernote/summernote-lite.css">
<link rel="stylesheet" href="/css/fripPage/insertFripFrm.css">
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>
	<script src="/js/summernote-lite.js"></script>
	<script src="/js/summernote-ko-KR.js"></script>
	<div class="padding" style="padding-top : 200px;"></div>
	<div class="page-content">
		<form action="insertFeed.do" method="get">
		<div class="hiddenInfo">
			<input type="hidden" name="memberId" value="<%=feedMember.getMemberId()%>">
			<input type="hidden" name="fripTitle" value="<%=frip.getFripTitle()%>">
			<input type="hidden" name="fripNo" value="<%=frip.getFripNo() %>">
			<input type="hidden" name="feedNo" value="<%=feed.getFeedNo() %>">
		</div>
		<div class="feedWriter">
			<span>작성자 : </span><%=feedMember.getMemberId() %>
		</div>
		<div class="choiceFripTitle">
			<%=frip.getFripTitle() %><span> > 스프립에 대한 피드작성</span>
		</div>
		<div class="choiceFripImg">
			<input type="file" value="test">
		</div>
		<div class="rating">
			<div>
                <label for="rating1">★</label>
                <input type="radio" name="rating" value="1" id="rating1">
			</div>
			<div>
                <label for="rating2">★★</label>
                <input type="radio" name="rating" value="2" id="rating2">
			</div>
			<div>
                <label for="rating3">★★★</label>
                <input type="radio" name="rating" value="3" id="rating3">
			</div>
			<div>
                <label for="rating4">★★★★</label>
                <input type="radio" name="rating" value="4" id="rating4">
			</div>
			<div>
                <label for="rating5">★★★★★</label>
                <input type="radio" name="rating" value="5" id="rating5">
			</div>
		</div>
				<textarea id="summernote" name="editordata" required></textarea>
				<button type="submit">피드작성</button>
			</form>
	</div>
<script>
	$('#summernote').summernote({
		  height: 100,                 // 에디터 높이
		  minHeight: null,             // 최소 높이
		  maxHeight: null,             // 최대 높이
		  focus: true,                  // 에디터 로딩후 포커스를 맞출지 여부
		  lang: "ko-KR",					// 한글 설정
		  placeholder: '최대 2048자까지 쓸 수 있습니다'	//placeholder 설정
	});
</script>
</body>
</html>
