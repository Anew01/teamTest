<%@page import="kr.or.iei.frip.vo.Frip"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	Frip f = (Frip)request.getAttribute("f");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/fripPage/viewMyFrip.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<div class="page-content">
		<%@include file="/WEB-INF/views/frip/fripSideBar.jsp" %>
		<div class="content">
			<div class="frip-detail">
				<div class="detail-title"><%= f.getFripTitle() %></div>
				<div class="slide-box">
	  				<div id="carousel" class="carousel slide" data-bs-ride="true" style="width : 200px;">
						<div class="carousel-indicators">
						    <% for(int j=0;j<f.getFilePath().size();j++) { %>
						    	<% if(j == 0) { %>
								    <button type="button" data-bs-target="#carousel" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
						    	<% } else { %>
								    <button type="button" data-bs-target="#carousel" data-bs-slide-to="<%= j %>" aria-label="Slide <%= j + 1%>"></button>
						    	<% } %>
						    <% } %>
					  	</div>
						<div class="carousel-inner">
							<% if(f.getFilePath().size() > 0 && f.getFilePath().get(0) != null) { %>
								<% for(int j=0;j<f.getFilePath().size();j++) { %>
									<% if(j == 0) { %>
										<div class="carousel-item active" onclick="viewFrip(<%= f.getFripNo() %>)">
									    	<img src="/upload/photo/<%= f.getFilePath().get(j) %>" class="d-block w-100" alt="...">
									    </div>
									<% } else { %>
									   	<div class="carousel-item" onclick="viewFrip(<%= f.getFripNo() %>)">
									    	<img src="/upload/photo/<%= f.getFilePath().get(j) %>" class="d-block w-100" alt="...">
									    </div>
									<% } %>
								<% } %>
							<% } else { %>
								<div class="carousel-item active">
									<img src="/upload/photo/noImg.gif" class="d-block w-100" alt="...">
								</div>
							<% } %>
						</div>
						<button class="carousel-control-prev" type="button" data-bs-target="#carousel" data-bs-slide="prev">
						    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
						    <span class="visually-hidden">Previous</span>
						</button>
						<button class="carousel-control-next" type="button" data-bs-target="#carousel" data-bs-slide="next">
						    <span class="carousel-control-next-icon" aria-hidden="true"></span>
						    <span class="visually-hidden">Next</span>
						</button>
					</div>
				</div>
				<div class="detail">
					<div>
						<span>주소</span>
						<span><%= f.getFripAddr() %></span>
					</div>
					<div>
						<span>난이도</span>
						<span><%= f.getFripLevel() %></span>
					</div>
					<div>
						<span>1인당 금액</span>
						<span><%= f.getFripPrice() %></span>
					</div>
					<div>
						<span>프립 신청결과</span>
						<span><%= f.getFripAuth() %></span>
					</div>
				</div>
				<div class="detail-btn-wrap">
					<a href="/joinFrip.do?fripNo=<%=f.getFripNo()%>">
						<button class="btn" style="background-color : #FEBE8C; color : white;">바로가기</button>
					</a>
					<a href="/updateFripFrm.do?fripNo=<%=f.getFripNo()%>">
						<button class="btn" style="background-color : #FEBE8C; color : white;">수정하기</button>
					</a>
					<a href="viewMyFripFeed.do?fripNo=<%=f.getFripNo()%>">
						<button class="btn" style="background-color : #FEBE8C; color : white;	">피드보기</button>
					</a>
				</div>
			</div>
			<div class="frip-right-wrap">
				<div class="frip-income-wrap">
					<div class="income-title">총 수입금</div>
					<div>
						<span>스프립에 참가한 총 인원수</span>
						<span>0명</span>
					</div>
					<div>
						<span>총 수입금</span>
						<span><%= f.getFripIncome() %>원</span>
					</div>
				</div>
				<div class="frip-inquiry-feed-wrap">
					<div class="inquiry-wrap">
						<div class="inquiry-title">
							<span>문의글</span>
							<a href="#">
								<button class="btn btn-link">더보기</button>
							</a>
						</div>
						<div class="inquiry-content">
							<div>Text - Double click to edit</div>
							<div>Text - Double click to edit</div>
						</div>
					</div>
					<div class="feed-wrap">
						<div class="feed-title">
							<span>내 평점</span>
							<a href="#">
								<button class="btn btn-link">더보기</button>	
							</a>
						</div>
						<div class="feed-content">
							<div>
								<% for(int i=0;i<Double.parseDouble(f.getAvgRating());i++) {%>
									<img src="/mainContentImg/star.png" style="width: 15px;">
								<% } %>
							</div>
							<div class="feed-rating-number"><%= f.getAvgRating() %></div>
						</div>
					</div>
				</div>
			</div>
			<div class="frip-date-wrap">
				<div class="date-title">스프립 날짜 설정</div>
				<div class="date-input-warp">
					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<label class="input-group-text" for="startDate">스프립 시작날짜</label>
						</div>
						<input type="hidden" name="fripNo" value="<%= f.getFripNo() %>">
						<input type="date" class="form-control" name="startDate" id="startDate" required>
					</div>
					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<label class="input-group-text" for="endDate">스프립 마감날짜</label>
						</div>
						<input type="date" class="form-control" name="endDate" id="endDate" required>
					</div>
					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<label class="input-group-text" for="maxCount">스프립 인원</label>
						</div>
						<input type="text" class="form-control" name="maxCount" id="maxCount" required>
					</div>
					<div class="submit-btn-warpper">
						<button type="submit" id="insertBtn" class="btn btn-lg btn-block" style="width : 100%; background-color : #FEBE8C; color : white;">등록하기</button>
					</div>
				</div>
				<div class="date-result-wrap">
					<div class="date-result-print"></div>
					<div class="date-result"></div>
				</div>
			</div>
			<div class="frip-date-search-wrap">
				<div class="date-search-title">날짜 조회</div>
				<div class="date-search-content">
					<div class="input-group mb-3" style="width : 80%;">
						<input class="form-control" type="text" id="datepicker1" name="startDate"> 
						<div class="input-group-text">~</div>
						<input class="form-control" type="text" id="datepicker2" name="endDate">
						<button class="btn" style="background-color : #FEBE8C; color : white;" id="searchDateBtn" type="button">조회하기</button>
					</div>
					<div class="date-tbl">
						<table class="table">
							<thead>
						    	<tr class="table">
					      			<th scope="col">No</th>
								    <th scope="col">날짜</th>
								    <th scope="col">참여인원</th>
									<th scope="col">총인원</th>
						    	</tr>
							</thead>
						  	<tbody>
							   
							 </tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
	<script>
		$.datepicker.setDefaults({
		    dateFormat: 'yy-mm-dd',
		    prevText: '이전 달',
		    nextText: '다음 달',
		    monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
		    monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
		    dayNames: ['일', '월', '화', '수', '목', '금', '토'],
		    dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
		    dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
		    showMonthAfterYear: true,
		    yearSuffix: '년'
		 });
	
		 $(function() {
		 	$("#datepicker1, #datepicker2").datepicker();
		 });
		  
		 $("#insertBtn").on("click", function(){
			const fripNo = $("[name=fripNo]").val();
			const startDate = $("#startDate").val();
			const endDate = $("#endDate").val();
			const maxCount = $("#maxCount").val();
			const date1 = new Date(startDate);
			const date2 = new Date(endDate);
			if(startDate == "" || endDate == "" || maxCount == "" ){
				$("[name=fripNo]").val("");
				$("#startDate").val("");
				$("#endDate").val("");
				$("#maxCount").val("");
				$(".date-result-print").empty();
				$(".date-result-print").append("입력을 다 해주세요").css("color", "red");
				return;
			} else if(date2 < date1){
				const span = $("<span>");
				span.css("color","red").text("시작날짜는 마지막날짜보다 전이여야합니다");
				$(".date-result-print").append(span);
				return;
			}
			
		  	$.ajax({
				url : "insertJoinableDate.do",
				type : "post",
				data : {startDate : startDate, endDate : endDate, fripNo : fripNo, maxCount : maxCount},
				dataType : "json",
				success : function(data){
					$("[name=fripNo]").val("");
					$("#startDate").val("");
					$("#endDate").val("");
					$("#maxCount").val("");
					$(".date-result-print").empty();
					if(data == "null"){
						$(".date-result-print").append("중복되는 날짜 입니다").css("color", "red");
					} else {
						const div = $("<div>");
						const countDiv = $("<div>");
						$(".date-result-print").append("날짜 등록 완료!").css("color", "green");
						div.addClass("date-result-title");
						countDiv.addClass("date-result-count");
						countDiv.append("등록할 수 있는 최대 인원 : "+data.maxCount);
						div.append("등록된 날짜 : "+data.startDate +" ~ "+data.endDate);
						console.log(data);
						$(".date-result").append(div).append(countDiv);
					}
					
				},
				error : function(){
				}
			  });
		  });
		 
		 $("#searchDateBtn").on("click", function(){
			 const startDate = $("#datepicker1").val();
			 const endDate =$("#datepicker2").val();
			 const fripNo = $("[name=fripNo]").val();
			 
			 const date1 = new Date(startDate);
			 const date2 = new Date(endDate);
			 if(date2 < date1) {
			 	const span = $("<span>");
				span.css("color","red").css("margin-left","20px").text("시작날짜는 마지막날짜보다 전이여야합니다");
				$("#searchDateBtn").after(span);
				return;
			 }
			 $.ajax({
				 url : "selectJoinableDate.do",
					type : "post",
					data : {startDate : startDate, endDate, endDate, fripNo : fripNo},
					dataType : "json",
					success : function(list){
						$("tr.result").remove();
						for(let i=0;i<list.length;i++){
							const tr = $("<tr>");
							tr.addClass("result");
							const td1 = $("<td>");
							td1.text(list[i].joinFripNo);
							const td2 = $("<td>");
							td2.text(list[i].joinDate);
							const td3 = $("<td>");
							if(list[i].useCnt == null){
								td3.text("0");							
							} else {
								td3.text(list[i].useCnt);
							}
							const td4 = $("<td>");
							td4.text(list[i].maxCnt);
							tr.append(td1).append(td2).append(td3).append(td4);
							$("tr.table-success").after(tr);
						}
					},
					error : function(){
						
					}
			 })
		 })
	</script>
</body>
</html>