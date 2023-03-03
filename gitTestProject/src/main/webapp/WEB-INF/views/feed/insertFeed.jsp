<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<div class="page-content">
		<div class="page-title"><h1>피드 작성하기</h1></div>
			<table>
				<tr>
					<th>썸네일 등록</th>
					<td><input type="file" name="imageFile" accept=".jpg,.png,.jpeg,.gif" onchange="loadImg(this);"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td colspan="3"><input type="file" name="imageFile" accept=".jpg,.png,.jpeg,.gif" onchange="loadImg(this);"></td>
				</tr>
			</table>
	</div>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>
