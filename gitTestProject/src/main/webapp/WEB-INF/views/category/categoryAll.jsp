<%@page import="kr.or.iei.frip.vo.FripJoinableDate"%>
<%@page import="kr.or.iei.frip.vo.Frip"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    ArrayList<Frip> list = (ArrayList<Frip>)request.getAttribute("list");
    ArrayList<String> fripFiles = (ArrayList<String>)request.getAttribute("fripFiles");
    ArrayList<FripJoinableDate> joinableDates = (ArrayList<FripJoinableDate>)request.getAttribute("joinableDates");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<%for(int i=0; i<list.size(); i++){ %>
	<%Frip f = list.get(i); %>
	<%=f.getFilePath() %>
	
	<%for(int j=0; j<1; j++){ %>
	<%String s = f.getFilePath().get(j); %>
		<table>
			<tr>
				<th>
					<img src="/upload/photo/<%=s %>">
				</th>
				<th>
					
				</th>
			</tr>
		</table>
	<%} %>
	
	<%} %>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>