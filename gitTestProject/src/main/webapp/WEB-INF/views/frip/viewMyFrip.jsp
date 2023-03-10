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
						<span>??????</span>
						<span><%= f.getFripAddr() %></span>
					</div>
					<div>
						<span>?????????</span>
						<span><%= f.getFripLevel() %></span>
					</div>
					<div>
						<span>1?????? ??????</span>
						<span><%= f.getFripPrice() %></span>
					</div>
					<div>
						<span>?????? ????????????</span>
						<span><%= f.getFripAuth() %></span>
					</div>
				</div>
				<div class="detail-btn-wrap">
					<a href="/joinFrip.do?fripNo=<%=f.getFripNo()%>">
						<button class="btn" style="background-color : #FEBE8C; color : white;">????????????</button>
					</a>
					<a href="/updateFripFrm.do?fripNo=<%=f.getFripNo()%>">
						<button class="btn" style="background-color : #FEBE8C; color : white;">????????????</button>
					</a>
					<a href="viewMyFripFeed.do?fripNo=<%=f.getFripNo()%>">
						<button class="btn" style="background-color : #FEBE8C; color : white;	">????????????</button>
					</a>
				</div>
			</div>
			<div class="frip-right-wrap">
				<div class="frip-income-wrap">
					<div class="income-title">??? ?????????</div>
					<div>
						<span>???????????? ????????? ??? ?????????</span>
						<span>0???</span>
					</div>
					<div>
						<span>??? ?????????</span>
						<span><%= f.getFripIncome() %>???</span>
					</div>
				</div>
				<div class="frip-inquiry-feed-wrap">
					<div class="inquiry-wrap">
						<div class="inquiry-title">
							<span>?????????</span>
							<a href="/inquiryBox.do?fripNo=<%=f.getFripNo()%>">
								<button class="btn btn-link">?????????</button>
							</a>
						</div>
						<div class="inquiry-content">
							<div>Text - Double click to edit</div>
							<div>Text - Double click to edit</div>
						</div>
					</div>
					<div class="feed-wrap">
						<div class="feed-title">
							<span>??? ??????</span>
							<a href="#">
								<button class="btn btn-link">?????????</button>	
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
				<div class="date-title">????????? ?????? ??????</div>
				<div class="date-input-warp">
					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<label class="input-group-text" for="startDate">????????? ????????????</label>
						</div>
						<input type="hidden" id="fripNo" name="fripNo" value="<%= f.getFripNo() %>">
						<input type="date" class="form-control" name="startDate" id="startDate" required>
					</div>
					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<label class="input-group-text" for="endDate">????????? ????????????</label>
						</div>
						<input type="date" class="form-control" name="endDate" id="endDate" required>
					</div>
					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<label class="input-group-text" for="maxCount">????????? ??????</label>
						</div>
						<input type="text" class="form-control" name="maxCount" id="maxCount" required>
					</div>
					<div class="submit-btn-warpper">
						<button type="submit" id="insertBtn" class="btn btn-lg btn-block" style="width : 100%; background-color : #FEBE8C; color : white;">????????????</button>
					</div>
				</div>
				<div class="date-result-wrap">
					<div class="date-result-print"></div>
					<div class="date-result"></div>
				</div>
			</div>
			<div class="frip-date-search-wrap">
				<div class="date-search-title">?????? ??????</div>
				<div class="date-search-content">
					<div class="input-group mb-3" style="width : 80%;">
						<input class="form-control" type="text" id="datepicker1" name="startDate"> 
						<div class="input-group-text">~</div>
						<input class="form-control" type="text" id="datepicker2" name="endDate">
						<button class="btn" style="background-color : #FEBE8C; color : white;" id="searchDateBtn" type="button">????????????</button>
					</div>
					<div class="date-tbl">
						<table class="table">
							<thead>
						    	<tr class="table">
					      			<th scope="col">No</th>
								    <th scope="col">??????</th>
								    <th scope="col">????????????</th>
									<th scope="col">?????????</th>
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
		    prevText: '?????? ???',
		    nextText: '?????? ???',
		    monthNames: ['1???', '2???', '3???', '4???', '5???', '6???', '7???', '8???', '9???', '10???', '11???', '12???'],
		    monthNamesShort: ['1???', '2???', '3???', '4???', '5???', '6???', '7???', '8???', '9???', '10???', '11???', '12???'],
		    dayNames: ['???', '???', '???', '???', '???', '???', '???'],
		    dayNamesShort: ['???', '???', '???', '???', '???', '???', '???'],
		    dayNamesMin: ['???', '???', '???', '???', '???', '???', '???'],
		    showMonthAfterYear: true,
		    yearSuffix: '???'
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
				$(".date-result-print").append("????????? ??? ????????????").css("color", "red");
				return;
			} else if(date2 < date1){
				const span = $("<span>");
				span.css("color","red").text("??????????????? ????????????????????? ?????????????????????");
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
						$(".date-result-print").append("???????????? ?????? ?????????").css("color", "red");
					} else {
						const div = $("<div>");
						const countDiv = $("<div>");
						$(".date-result-print").append("?????? ?????? ??????!").css("color", "green");
						div.addClass("date-result-title");
						countDiv.addClass("date-result-count");
						countDiv.append("????????? ??? ?????? ?????? ?????? : "+data.maxCount);
						div.append("????????? ?????? : "+data.startDate +" ~ "+data.endDate);
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
			 const fripNo = $("#fripNo").val();
			 
			 const date1 = new Date(startDate);
			 const date2 = new Date(endDate);
			 if(date2 < date1) {
			 	const span = $("<span>");
				span.css("color","red").css("margin-left","20px").text("??????????????? ????????????????????? ?????????????????????");
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
						if(list.length > 0){
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
								$(".table").children().eq(1).append(tr);
							}
						} else {
							const tr = $("<tr>");
							tr.addClass("result");
							const td1 = $("<td>");
							td1.text("0");
							const td2 = $("<td>");
							td2.text("?????? ?????? ??????");
							const td3 = $("<td>");
							td3.text("?????? ?????? ??????");							
							const td4 = $("<td>");
							td4.text("?????? ?????? ??????");
							tr.append(td1).append(td2).append(td3).append(td4);
							$(".table").children().eq(1).append(tr);
						}
					},
					error : function(){
						
					}
			 })
		 })
	</script>
</body>
</html>