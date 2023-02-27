<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- <%@ include file= %> -->
	<!-- 포트원 라이브러리 추가 iamport.payment.js -->
	<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
	<div class="page-content">
		<div class="page-title">결제모듈</div>
		<input type="text" id="pay">
		<button id="payBtn" class="btn bc1">결제하기</button>
	</div>
	<script>
		$("#payBtn").on("click", function(){
			const price = $("#pay").val();
			const d = new Date();
			const date = d.getFullYear()+""+(d.getMonth()+1)+""+d.getDate()+""+d.getHours()+""+d.getMinutes()+""+d.getSeconds();
			
			IMP.init("imp65187362");
			
			IMP.request_pay({
				pg : "html5_inicis",
				pay_method : "card",
				merchant_uid : "상품번호_"+date, //상점에서 관리하는 주문식별번호
				name : "결제 테스트", //결제이름
				amount : price, //결제금액
				buyer_email : "9kooding@gmail.com",
				buyer_name: "구매자",
				buyer_tel : "010-9999-9999",
				buyer_addr: "뉴욕 맨해튼",
				buyer_postcode : "12345"
			}, function(rsp){ //결제 결과는 rsp로 응답이 돌아온다.
				if(rsp.success){
					alert("결제성공");
					//결제관련 정보를 DB insert 하는 작업이 필요 
				}else{
					alert("결제실패");
				}
			});
			
				
		});
	</script>
	<!-- <%@ include file= %> -->
	

</body>
</html>