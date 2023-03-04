<%@page import="java.util.ArrayList"%>
<%@page import="kr.or.iei.frip.vo.Frip"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	<% 	
	Frip f = (Frip) request.getAttribute("f");
	ArrayList<Frip> list = (ArrayList<Frip>)request.getAttribute("list");
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

</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp"%>
	<div class="modal-wrap hidden">
		<div class="modal" id="jsModal">
			<div class="text-area">
				<textarea name="message-to-host" id="message-to-host"
					placeholder="호스트에게 필요한 메세지를 적어주세요."></textarea>
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
				<button class="category">category</button>
			</div>
		</div>
		<div class="content">
			<div class="title">활동명</div>
			<div class="show-rating">
				<span class="material-symbols-rounded">star</span><span> 평점</span class="rating"><span
					class="ratingcount"> (평점준사람수)</span><span class="addr"> 주소</span>
				</p>
			</div>
				<div class="photo">
                <a href="#">
                    <img src="/05_Semi_pj/IMG/한강.png">
                    <img src="/05_Semi_pj/IMG/한강2.png">
                    <img src="IMG/한강3.png">
                </a>
            </div>
			</div>
		</div>
		<div class="contents-bundle">
			<div class="contents-left">
				<div class="content">
					<div class="title">
						호스트 : <span>hostname</span>님
					</div>
				</div>
				<div class="content">
					<div class="small-title">프로그램</div>
					<div class="explain">전문 조향사와 함께 특별한 나만의 향을 직접 만드는 원데이 클래스
						입니다. 80여 가지의 조합향료와 30여 가지의 천연향료 그리고 30여 가지의 합성향료 이용하여 세상에 하나뿐인 향수를
						만들 수 있는 클래스이며 사용되는 향료에 대한 간단한 설명과 함께 진행됩니다. ✔ 프랑스산 최상급 향료들을 재료로
						사용합니다. ✔ 피부에 안전한 재료들을 사용하여 가장 아름다운 향을 만들 수 있도록 전문조향사가 함께 합니다. ✔
						200여종의 다양한 향에서 내가 원하는 향을 선택할 수 있습니다. ✔ 전문조향사가 도와주기 때문에 어렵지 않게 원하는
						향을 선택하고 만드실 수 있습니다. ✔ 현 아카데미 운영 경험을 바탕으로 더욱 체계적인 수업이 이루어집니다. 수업은
						약1시간 30분정도 소요되며, 예약제로 운영되니 이용에 참고해 주세요. 공간은 최대 15명까지 수용 가능하니 따로 문의
						주세요! 공방 위치는 홍대입구역 7번 출구 도보 4분, 신촌역 8번 출구 도보 11분으로 대중교통 접근성이 좋은 위치에
						있습니다.</div>
				</div>
				<div class="content">
					<div class="small-title">
						호스트 <span>hostname</span>님 소개
					</div>
					<p>
						★<span class="rating">별점평점</span><span class="ratingcount">(평점준사람수)</span>
					</p>
					<div class="explain">사람들에게 행복감을 선사할 수 있는 향기를 만들고 싶어, 조향 공부에
						매진하며 10년간 조향사로 일하고 있습니다. 지나간 세월의 어느 날을 기억해보려 최대한 그때와 똑같은 분위기, 그날의
						미소까지도 떠올리게 하는 향수를 만드는 사람들도 있고 지금 이 순간의 행복을 위해 향수를 만드는 사람들도 있습니다.
						비푸머스를 운영하며 향을 사랑하는 분들이 마음껏 향을 맡고 느끼고 배울 수 있는 환경이 될 수 있도록 늘 노력하고
						있습니다. ✔ 고려대 바이오향료공학 석사 ✔ 프랑스 gip 국제과정 수료 ✔ 기업 향기 마케팅 컨설팅 진행 ✔
						셀러브리티 향수 출시 ✔ 관공서, 백화점, 기업 등 퍼퓸클래스 진행</div>
					<div>
						<button class="contact-host" id="jsBtn">호스트에게 연락</button>

					</div>
				</div>
			</div>
			<div class="contents-right">
				<div class="attend-box">
					<div class="small-title">
						최저가 ₩<span>price</span>/인
					</div>
					<form action="#" method="get">
						<div class="attend-info">
							<div class="select-box left">
								<!-- <p>날짜 <input type="text" id="datepicker"> </p>  -->
								<p class="calendar">
									날짜 <input type="text" id="gijgo" readonly>
								</p>
							</div>
							<div class="select-box right">
								<div class="guest-number">인원</div>
								<select class="attend-number">
									<option value>참여자 수</option>
									<option value="1">1명</option>
									<option value="2">2명</option>
									<option value="3">3명</option>
									<option value="4">4명</option>
									<option value="5">5명</option>
									<option value="6">6명</option>
									<option value="7">7명</option>
									<option value="8">8명</option>
									<option value="9">9명</option>
									<option value="10">10명</option>
								</select>
							</div>
							<div class="check">
								<button type="button" id="seemore-button"
									onclick="func1(<%= f.getFripNo()%>);">조회하기</button>
							</div>
							<div class="select-area">
								<!--여기는 날짜, 인원으로 ajax로 조회한 그 날짜의 인원, 시간 목록이 뜨게한다.-->
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		<div class="content">
			<div class="small-title">방문장소</div>
			<div class="map">
				<img src="/05_Semi_pj/IMG/네이버맵.jpg">
			</div>
		</div>
		<script src="https://unpkg.com/gijgo@1.9.14/js/gijgo.min.js"></script>
		<link href="https://unpkg.com/gijgo@1.9.14/css/gijgo.min.css"
			rel="stylesheet" />
		<script src="/js/joinFrip/detailpage.js"></script>
		
</body>
</html>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>
</body>
</html>