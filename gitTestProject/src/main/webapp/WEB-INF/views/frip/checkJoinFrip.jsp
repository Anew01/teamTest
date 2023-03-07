<%@page import="java.util.ArrayList"%>
<%@page import="kr.or.iei.frip.vo.Frip"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%
Frip f = (Frip) request.getAttribute("f");
int fripNo = (int) request.getAttribute("fripNo");
ArrayList<Member> mlist = (ArrayList<Member>)request.getAttribute("mlist");
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
<!-- <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script> -->
<!--카카오 지도 API-->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=47b529e9eac0ea1c6c378c29238f4160"></script>
    

<style>
	.photo img:first-child{
    border-top-left-radius: 100px;
    border-bottom-left-radius: 100px;
	}
	.photo img:last-child{
    border-top-right-radius: 100px;
    border-bottom-right-radius: 100px;
	}
	
</style>
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
   <div class="modal-wrap hidden">
      <div class="modal" id="jsModal">
         <div class="text-area">
            <textarea name="message-to-host" id="message-to-host"placeholder="호스트에게 필요한 메세지를 적어주세요."></textarea>
         </div>
         <div class="modal-button">
            <button class="modal__closeBtn" id="jsCloseBtn">X</button>
            <button class="send-to-host" id="send-to-host">보내기</button>
         </div>
      </div>
   </div>
   <div class="wrap">
      <div class="content">
         <div class="button">
            <button class="category"><%=f.getFripCategory() %></button>
         </div>
      </div>
      <div class="content">
         <div class="title"><%=f.getFripTitle() %></div>
         <div class="show-rating">
            <span class="material-symbols-rounded">star</span><span><%=f.getAvgRating() %></span class="rating"><span class="addr"> <%=f.getFripAddr() %></span>
            </p>
         </div>
         <div class="photo">
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
   </div>
   <div class="contents-bundle">
      <div class="contents-left">
         <div class="content">
            <div class="title">
            <%=f.getFripWriter() %>
            </div>
         </div>
         <div class="content">
            <div class="small-title"><%=f.getFripTitle() %></div>
            <div class="explain"><%=f.getFripContent() %>전문 조향사와 함께 특별한 나만의 향을 직접 만드는 원데이 클래스 입니다.
               80여 가지의 조합향료와 30여 가지의 천연향료 그리고 30여 가지의 합성향료 이용하여 세상에 하나뿐인 향수를 만들 수
               있는 클래스이며 사용되는 향료에 대한 간단한 설명과 함께 진행됩니다. ✔ 프랑스산 최상급 향료들을 재료로 사용합니다. ✔
               피부에 안전한 재료들을 사용하여 가장 아름다운 향을 만들 수 있도록 전문조향사가 함께 합니다. ✔ 200여종의 다양한
               향에서 내가 원하는 향을 선택할 수 있습니다. ✔ 전문조향사가 도와주기 때문에 어렵지 않게 원하는 향을 선택하고 만드실
               수 있습니다. ✔ 현 아카데미 운영 경험을 바탕으로 더욱 체계적인 수업이 이루어집니다. 수업은 약1시간 30분정도
               소요되며, 예약제로 운영되니 이용에 참고해 주세요. 공간은 최대 15명까지 수용 가능하니 따로 문의 주세요! 공방 위치는
               홍대입구역 7번 출구 도보 4분, 신촌역 8번 출구 도보 11분으로 대중교통 접근성이 좋은 위치에 있습니다.</div>
         </div>
         <div class="content">
            <div class="small-title">
               호스트 <span><%=f.getFripWriter() %></span>님 소개
            </div>
            <p>
               ★<span class="rating"></span>
            </p>
            <div class="explain">사람들에게 행복감을 선사할 수 있는 향기를 만들고 싶어, 조향 공부에
               매진하며 10년간 조향사로 일하고 있습니다. 지나간 세월의 어느 날을 기억해보려 최대한 그때와 똑같은 분위기, 그날의
               미소까지도 떠올리게 하는 향수를 만드는 사람들도 있고 지금 이 순간의 행복을 위해 향수를 만드는 사람들도 있습니다.
               비푸머스를 운영하며 향을 사랑하는 분들이 마음껏 향을 맡고 느끼고 배울 수 있는 환경이 될 수 있도록 늘 노력하고
               있습니다. ✔ 고려대 바이오향료공학 석사 ✔ 프랑스 gip 국제과정 수료 ✔ 기업 향기 마케팅 컨설팅 진행 ✔ 셀러브리티
               향수 출시 ✔ 관공서, 백화점, 기업 등 퍼퓸클래스 진행</div>
            <div>
               <button class="contact-host" id="jsBtn" onclick="init()">호스트에게
                  연락</button>
            </div>
         </div>
      </div>
      <div class="contents-right">
         <div class="attend-box">
            <div class="small-title">
               최저가 ₩<span><%=f.getFripPrice() %></span>/인
            </div>
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
   <div class="content">
      <div class="small-title">방문 장소</div>
      <div id="map" style="width:100%; height: 500px;"></div>
	</div>
   </div>
   <!-- 여기부터 피드를 위한 코드작성 충돌방지 용 주석 -->
   <a href="/insertFeedFrm.do?fripNo=<%=f.getFripNo()%>&feedWriter=<%=loginMember.getMemberId()%>">피드작성</a>
   <script src="https://cdn.jsdelivr.net/npm/gijgo@1.9.14/js/gijgo.min.js"></script>
   <link
      href="https://cdn.jsdelivr.net/npm/gijgo@1.9.14/css/gijgo.min.css"
      rel="stylesheet" />
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

geocoder.addressSearch('서울 영등포구 선유동2로 57', function(result, status) {

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
            content: '<div style="width:150px;text-align:center;padding:6px 0;">우리회사</div>'
        });
        infowindow.open(map, marker);

        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
        map.setCenter(coords);
    } 
});    
   </script>
   
<%@ include file="/WEB-INF/views/common/footer.jsp"%>
</body>
</html>