<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="kr.or.iei.feed.vo.ViewFripFeedData"%>
<%@page import="kr.or.iei.feed.vo.Feed"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kr.or.iei.frip.vo.Frip"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%
Frip f = (Frip) request.getAttribute("f");
int fripNo = (int) request.getAttribute("fripNo");
ArrayList<Member> mlist = (ArrayList<Member>)request.getAttribute("mlist");
ArrayList<ViewFripFeedData> fList = (ArrayList<ViewFripFeedData>)request.getAttribute("fList");
ArrayList<Frip> list = (ArrayList<Frip>)request.getAttribute("list");
ArrayList<Member> mList = (ArrayList<Member>)request.getAttribute("mList");
Member m = (Member)request.getAttribute("m");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>상세페이지</title>
<link rel="stylesheet" href="/css/joinFrip/detailpage.css">
<link rel="stylesheet"
   href="https://fonts.googleapis.com/css2?family=Material+Symbols+Rounded:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<link rel="stylesheet"
   href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
 <!--카카오 지도 API-->
 <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=47b529e9eac0ea1c6c378c29238f4160&libraries=services"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/gijgo@1.9.14/css/gijgo.min.css">
</head>
<body>

   <%@ include file="/WEB-INF/views/common/header.jsp"%>
   <%--지도주소용 변수 --%>
   <input type="hidden" name="addr" id="addr" value="<%=f.getFripAddr()%>">
   <input type="hidden" name="maxCnt"
      value=<%=f.getJoinableDates().get(0).getMaxCount()%>>
   <input type="hidden" id="strDate"
      value=<%=f.getJoinableDates().get(0).getStartDate()%>>
   <input type="hidden" id="endDate"
      value=<%=f.getJoinableDates().get(0).getEndDate()%>>
      
      <!-- 모달!! -->
      <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">호스트에게 문의사항을 적어주세요.</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <form action="/sendRequestToHost.do" method="post">
          <div class="mb-3">
            <%--<label for="recipient-name" class="col-form-label">호스트 이메일:</label> --%>
            <label for="recipient-name" class="col-form-label">호스트 이메일:</label>
            <input type="text" class="form-control" id="hostmail" value="<%=f.getFripWriter() %>" name="hostmail">
            <%if(loginMember != null){ %>
            <input type="hidden" class="form-control" id="recipient-name" value="<%=loginMember.getMemberId()%>">
           <%} %>
          </div>
          <div class="mb-3">
            <label for="message-text" class="col-form-label">호스트에게 보낼 메세지를 적어주세요</label>
            <textarea class="form-control" id="message-text" name="messageText"></textarea>
             <% if(loginMember!=null){ %>
            <input type="hidden" id="guestmail" name="guestmail" value="<%=loginMember.getMemberId()%>">
            <%} %>
            <input type="hidden" id="fripNo" name="fripNo" value=<%=fripNo%>>
          </div>
      	  <div class="modal-footer">
        	<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
        	<button type="submit" class="btn btn-primary">보내기</button>
       	  </div>
        </form>
      </div>
    </div>
  </div>
</div>
	<!-- 모달 끝 -->
      
      
      
   <div class="wrap">
      <div class="content">
         <div class="button">
            <button class="category"><%=f.getFripCategory() %></button>
         </div>
      </div>
      <div class="content">
         <div class="title"><%=f.getFripTitle() %></div>
         <div class="show-rating">
            <span class="material-symbols-rounded">star</span><span class="rating"><%=f.getAvgRating() %></span><span class="addr"> <%=f.getFripAddr() %></span>
         </div>
         <div class="photo"> <!-- 대표 이미지 3장씩 -->
        	<%if(f.getFilePath().size() >= 3) {%>
        		<%for(int i=0; i<3; i++){ %>
            		<img src="/upload/photo/<%=f.getFilePath().get(i)%>">
            	<%} %>
            	<%}else if(f.getFilePath().size() == 2){%>
		           	<img src="/upload/photo/<%=f.getFilePath().get(1)%>"> 
		           	<img src="/upload/photo/<%=f.getFilePath().get(0)%>">
		           	<img src="/upload/photo/no-photo.png">
            	<%}else if(f.getFilePath().size() == 1){%>
	            	<img src="/upload/photo/no-photo.png">
	            	<img src="/upload/photo/<%=f.getFilePath().get(0)%>">
	            	<img src="/upload/photo/no-photo.png">
            	<%}else if(f.getFilePath().size() < 1){%>
	            	<img src="/upload/photo/noImg.gif">
	            	<img src="/upload/photo/noImg.gif">
	            	<img src="/upload/photo/noImg.gif">
            	<%} %>
         </div>
      </div>
   <div class="contents-bundle">
      <div class="contents-left">
         <div class="content">
            <div class="title">
            <%=m.getMemberName()%>님이 진행하는 Sprip입니다.
            </div>
         </div>
         <div class="content">
            <div class="small-title"><%=f.getFripTitle() %></div>
            <div class="explain"><%=f.getFripContent() %>✔여기 내용을 넣어주세요</div>
         </div>
         <div class="content">
            <div class="small-title">
              	 호스트 <span><%=f.getFripWriter() %></span>님 
            </div>
            <p>후기 별점
               ★<span class="rating"><%=f.getAvgRating() %></span>
            </p>
            <div class="explain"></div>
            <div>
            <%if(loginMember != null){ %>
            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="<%=loginMember.getMemberId()%>" style="background-color: #85C88A; border : none;">호스트에게 연락</button>
            <%} %>
            </div>
         </div>
      </div>
      <div class="contents-right">
         <div class="attend-box">
            <div class="small-title"> 최저가 ₩<span><%=f.getFripPrice() %></span>/인 </div>
            <form action="/payment.do" method="get">
               <div class="attend-info">
                  <div class="select-box left">
                     <!-- <p>날짜 <input type="text" id="datepicker"> </p>  -->
                     <p class="calendar">
                        날짜 <input type="text" id="datePicker" name="date">
                     </p>
                  </div>
                  <div class="check">
                     <button type="button" id="seemore-button"
                        onclick="selectCntAjax()">가능한 참여자 수 조회</button>
                  </div>
                  <div class="select-area">
                     <!--여기는 날짜, 인원으로 ajax로 조회한 그 날짜의 인원, 시간 목록이 뜨게한다.-->
                  </div>
               </div>
               <div class="attend-info">
                  <div class="select-box right">
                     <div class="guest-number">인원</div>
                     <select class="attend-number" id="select" name="attendNumber">
                        <option>날짜 설정 후 선택 해주세요</option>
                     </select>
                  </div>
                  <div class="check">
                     <button type="submit" id="seemore-button" onclick="func1()">예약하기</button>
                  </div>
                  <div class="select-area">
                     <!--여기는 날짜, 인원으로 ajax로 조회한 그 날짜의 인원, 시간 목록이 뜨게한다.-->
                  </div>
               </div>
               <input type="hidden" id="fripNo" name="fripNo" value=<%=fripNo%>>
            </form>
         </div>
      </div>
	</div>
	<div class="content-feed">
   		<div class="content-wrap">
      		<div class="small-title">피드 목록</div>
      		<div class="feed-wrap">
      			<% for(ViewFripFeedData data : fList) { %>
      				<div class="feed-box">
      					<div class="feed-writer-info">
      						<div class="img-box">
      							<% if(data.getMemProfilepath() != null) { %>
	      							<img src="upload/member/<%= data.getMemProfilepath()%>">
      							<% } else { %>
      								<img src="upload/member/no-profile.png">
      							<% } %>
      						</div>
      						<div class="writer-info">
      							<div><%= data.getF().getFeedWriter() %></div>
      							<%  Date date = new Date();
      					       		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
      					        	String dateStr = format.format(date); %>
      							<div><%= dateStr %></div>
      						</div>
      					</div>
      					<div class="feed-content-wrap">
      						<div class="feed-img-box">
      							<% if(data.getF().getFilepath() != null) { %>
      								<img src="/upload/feed/<%=data.getF().getFilepath()%>">
      							<% } else { %>
      							<% } %>
      						</div>
      						<div class="feed-content"><%= data.getF().getFeedContent() %></div>
      					</div>
      				</div>
      			<% } %>
      		</div>
      		<button class="btn btn-outline-secondary btn-lg" id="moreFeedBtn" data-bs-toggle="modal" data-bs-target="#feedModal">피드 <%= fList.size() %>개 모두보기</button>
    	</div>
   	</div>
   	<div class="content-visit">
      	<div class="small-title">방문 장소</div>
      	<div id="map" style="width:100%; height: 500px;"></div>
   	</div>
   	<!-- 피드 모달 -->
    <div class="modal fade" id="feedModal" tabindex="-1" role="dialog" aria-labelledby="feedModal" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable modal-xl" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close">
        </button>
      </div>
      <div class="modal-body">
      	<div class="feed-modal-wrap">
      			<% for(ViewFripFeedData data : fList) { %>
      				<div class="feed-box">
      					<div class="feed-writer-info">
      						<div class="img-box">
      							<% if(data.getMemProfilepath() != null) { %>
	      							<img src="upload/member/<%= data.getMemProfilepath()%>">
      							<% } else { %>
      								<img src="upload/member/no-profile.png">
      							<% } %>
      						</div>
      						<div class="writer-info">
      							<div><%= data.getF().getFeedWriter() %></div>
      							<%  Date date = new Date();
      					       		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
      					        	String dateStr = format.format(date); %>
      							<div><%= dateStr %></div>
      						</div>
      					</div>
      					<div class="feed-content-wrap">
      						<div class="feed-img-box">
      							<% if(data.getF().getFilepath() != null) { %>
      								<img src="/upload/feed/<%=data.getF().getFilepath()%>">
      							<% } else { %>
      							<% } %>
      						</div>
      						<div class="feed-content"><%= data.getF().getFeedContent() %></div>
      					</div>
      				</div>
      			<% } %>
      		</div>
      	</div>
      <div class="modal-footer">
      </div>
    </div>
  </div>
</div>
	<!-- 피드 모달 끝 -->
   	</div>


   <script src="https://cdn.jsdelivr.net/npm/gijgo@1.9.14/js/gijgo.min.js"></script>
   <script src="/js/joinFrip/detailpage.js"></script>
   
   <script>
      $(document).ready(function() {
         var strDate = getFormatDate(new Date($('#strDate').val()));
         var endDate = getFormatDate(new Date($('#endDate').val()));
         $('#datePicker').datepicker({
               disableDates : function(date) {
               var dateValue = getFormatDate(date);
               if (dateValue >= strDate && dateValue <= endDate){
                  return true;
               }
               return false;
            }
         });
      });
      function getFormatDate(date) {
         var year = date.getFullYear(); //yyyy
         var month = (1 + date.getMonth()); //M
         var day = (date.getDate());
         month = month >= 10 ? month : '0' + month;
         day = day >= 10 ? day : '0' + day; //day 두자리로 저장
         return year + month + day;
      }
      function func1() {
         const Dvalue = $("#datePicker").val();
         //var selectedDate = $('#datePicker').datepicker('getDate');
         alert(Dvalue);
      }
      function selectCntAjax() {
         $.ajax({
            type : "GET",
            url : "selectFripCnt.do",
            data : {
               "date" : $("#datePicker").val(),
               "fripNo" : $("#fripNo").val()
            },
            success : function(data) {
               const maxCnt = data.maxCnt;
               const useCnt = data.useCnt;
               var text;
               $("#select").empty();
               $("#select").append("<option>참여숫자</option>");
               for (let i = 1; i <= maxCnt; i++) {
                  //if(max-use)
                  if (i > (maxCnt - useCnt)) {
                     text = i + "명[만료]";
                     $("#select").append("<option value="+0+">" + text+ "</option>")
                  } else {
                     text = i + "명";
                     $("#select").append("<option value="+i+">" + text+ "</option>")
                  }
               }
            },
            error : function() {
            }
         });
      }
      //카카오 지도 API
  	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };  

// 지도를 생성합니다    
var map = new kakao.maps.Map(mapContainer, mapOption); 

// 주소-좌표 변환 객체를 생성합니다
var geocoder = new kakao.maps.services.Geocoder();
// 주소로 좌표를 검색합니다
geocoder.addressSearch('<%=f.getFripAddr()%>', function(result, status) {


    // 정상적으로 검색이 완료됐으면 
     if (status === kakao.maps.services.Status.OK) {

        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

        // 결과값으로 받은 위치를 마커로 표시합니다
        var marker = new kakao.maps.Marker({
            map: map,
            position: coords
        });

        // 인포윈도우로 장소에 대한 설명을 표시합니다
        var infowindow = new kakao.maps.InfoWindow({
            content: '<div style="width:150px;text-align:center;padding:6px 0;"><%=f.getFripTitle()%></div>'
        });
        infowindow.open(map, marker);

        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
        map.setCenter(coords);
    } 
});    

//모달
	const exampleModal = document.getElementById('exampleModal')
	exampleModal.addEventListener('show.bs.modal', event => {
  // Button that triggered the modal
  const button = event.relatedTarget
  // Extract info from data-bs-* attributes
	const recipient = button.getAttribute(<%=f.getFripWriter()%>);
  // If necessary, you could initiate an AJAX request here
  // and then do the updating in a callback.
  //
  // Update the modal's content.
  const modalTitle = exampleModal.querySelector('.modal-title');
  const modalBodyInput = exampleModal.querySelector('.modal-body input')

  modalTitle.textContent = `New message to ${recipient}`
  modalBodyInput.value = recipient
})

//피드 모달

//메일 ajax
	let mailCode;
    		
    		$(".btn btn-primary").on("click", function() {
    			const email = $("#hostmail").val();
    		

    			$.ajax({
    				url : "/sendRequestToHost.do",
    				data : {
    					email : email
    				},
    				type : "post",
    				success : function(data) {
    					if (data == "null") {
    						alert("이메일 주소를 확인해주세요.");
    					} else {
    						mailCode = data;
    						
    					}

    				},
    				error : function() {
    					console.log("에러발생");
    				}
    			});

    		});



   </script>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>
</body>
</html>