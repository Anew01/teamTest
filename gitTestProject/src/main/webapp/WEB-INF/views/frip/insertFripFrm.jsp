<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/WEB-INF/js/jquery-3.6.3.min.js"></script>
</head>
<body>
	<div class="page-content">
		<div class="page-title">스프립 등록</div>
		<form action="InsertFrip.do" method="post" enctype="multipart/form-data">
			<div>
				<label for="fripTitle">스프립 제목</label>
				<input type="text" name="fripTitle" id="fripTitle">
				<button type="button">중복체크</button>
			</div>
			<div>
				<label for="fripFiles">스프립 프로필 사진</label>
				<input type="file" multiple="multiple" accept=".jpg,.png,.jpeg" name="fripFiles" id="fripFiles" onChange="uploadFiles(this)">
			</div>		
			<div id="FilesView"></div>
		</form>
	</div>
	<script>
		
	</script>
</body>
</html>