<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script> <!--https://postcode.map.daum.net/guide 여기서 가지고온다  -->
 <script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=5ugpda8kcw&submodules=geocoder"></script> <!-- 네이버 cloud -->
</head>
<body>
	<!-- <%@ include file= %> -->
	<div class="page-content">
		<div class="page-title">지도 API</div>
		<h2>1. 다음 주소찾기 API</h2>
		<div class="address-wrap">
			<input type="text" name="postcode"	id="postcode" class="input-form"readonly>
			<button class="btn bc1" onclick="searchAddr();">주소찾기</button>
			<input type="text" name="address" id="address" class="input-form" readonly>
			<input type="text" name="detailAddress" id="detailAddress" class="input-form">
		</div>
		<hr>
		<h3>2. 네이버지도</h3>
		<div id="map" style="width:100%; height: 500px;"></div>
		<button onclick="loadMap();" class="btn bc1">조회한 곳으로 지도 이동</button>
	</div>
	<script>
		const map = new naver.maps.Map("map",{
			center: new naver.maps.LatLng(37.533837,126.896836), //처음 지도 중앙위치 
			zoom: 17, //배율 배수
			zoomControl: true,
			zoomControlOptions :{ //+-컨트롤러 
				position : naver.maps.Position.TOP_RIGHT, //우측상단
				style: naver.maps.ZoomControlStyle.SMALL //작은 사인으로
			}
		});
		
		//마커 만들어주기!
		const marker = new naver.maps.Marker({ //위치표시
			position : new naver.maps.LatLng(37.533837,126.896836), 
			map : map
		});
		
		let contentString = [
			"<div class='iw_inner'>", //iw_inner는 주소에 말풍선처럼 생기는 네이버에서 만든 css이름!
			"	<h3>KH정보교육원</h3>",
			"	<p>서울시 여등포구 선유2로 57 이레빌딩 19F A강의장</p>",
			"</div>"
		].join("");
		let infoWindow = new naver.maps.InfoWindow();
		
		//marker에 클릭이벤트 추가 
		naver.maps.Event.addListener(marker,"click",function(e){
			infoWindow = new naver.maps.InfoWindow({
				content: contentString
			});
			//생성된 infoWindow를 map의 marker위치에 생성
			infoWindow.open(map,marker);
		});
		
		//map에 클릭이벤트 추가
		naver.maps.Event.addListener(map,"click",function(e){
			marker.setPosition(e.coord);//클릭한 위치로 마커 이동
			map.setCenter(e.coord); //클릭한 위치로 지도 중심 이동
			if(infoWindow.getMap()){ //정보창이 지도위에 올라가있으면 
				infoWindow.close(); //정보창 닫는다
			}
			//위경도를 통해서 해당위치의 주소를 알아내기(reverseGeocode)
			naver.maps.Service.reverseGeocode({
				location : new naver.maps.LatLng(e.coord.lat(), e.coord.lng())
			}, function(status, response){
				if(status !=naver.maps.Service.Status.OK){ //요청결과가 OK가 아니면(정상결과가 아니면)
					return alert("주소를 찾을 수 없습니다.");
				}
				console.log(response);
				const address = response.result.items[1].address;
				contentString = [
					"<div class='iw_inner'>",  //iw_inner는 주소에 말풍선처럼 생기는 네이버에서 만든 css이름!
					" <p>"+address+"</p>",
					"</div>"
				].join("");
			});
		});
		
		function searchAddr(){
			 new daum.Postcode({
			        oncomplete: function(data) {
			        	console.log(data);
			        	$("#postcode").val(data.zonecode);
			        	$("#address").val(data.address);
			        	$("#detailAddress").focus();
			            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
			            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
			        }
			    }).open();
		}
		
		//우편번호 찾아서 주소 채워넣으면 지도에 표시되는 연결 
		function loadMap(){
			const addr = $("#address").val();
			naver.maps.Service.geocode({ //geocode는 주소를 주면 위경도를 준다.
				address: addr,
			},function(status, response){
				if(status===naver.maps.Service.Status.ERROR){ //js에서 값, 타입까지 일치하는지 볼때는 = 세개 
					return alert("조회 에러");
				}
				console.log(response);
				const lng = response.result.items[1].point.x; //경도
				const lat = response.result.items[1].point.y; //위도
				//위경도 객체
				const latlng = new naver.maps.LatLng(lat, lng);
				map.setCenter(latlng);
				marker.setPosition(latlng);
				const address = response.result.items[1].address;
				contentString = [
					"<div class='iw_inner'>",  //iw_inner는 주소에 말풍선처럼 생기는 네이버에서 만든 css이름!
					" <p>"+address+"</p>",
					"</div>"
				].join("");
			});
		}
		
		
	</script>
	<!-- <%@ include file= %> -->

</body>
</html>