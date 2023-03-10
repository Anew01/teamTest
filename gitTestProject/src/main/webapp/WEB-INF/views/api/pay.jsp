<%@page import="kr.or.iei.frip.vo.Frip"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	Frip f = (Frip)request.getAttribute("f");
    	String date = (String)request.getAttribute("date");
    	int attendNumber = (int)request.getAttribute("attendNumber");
    	int memberNo = (int)request.getAttribute("memberNo");
    	String strNewDtFormat = (String)request.getAttribute("strNewDtFormat");
    %>
<!DOCTYPE html>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/payment/paymentpage.css">
 <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Rounded:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
</head>
<body>
   <%@ include file="/WEB-INF/views/common/header.jsp"%>
	<div class="wrap">
        <div class="top">
            <span class="material-symbols-rounded">arrow_back_ios_new</span><h1>확인 및 결제</h1>
        </div>
        <div class="contents-bundle">
            <div class="contents-left">
                <div class="content">
                    <h2><%=f.getFripTitle() %></h2>
                    <div class="info">
                        <div class="calendar-info">
                            <div class="small-title">날짜</div> 
                            <%=strNewDtFormat %>
                        </div>
                        <div class="guest-number">
                            <div class="small-title">참여자</div>
                            <input type="hidden" id="attendNumber" value="<%= attendNumber%>">
                            <input type="hidden" id="fripNo" value="<%= f.getFripNo() %>">
                            <input type="hidden" id="memberNo" value="<%= memberNo%>">
                            <%=attendNumber %>명
                        </div>
                    </div>
                </div>
                <div class="content">
                    <h2>결제</h2>
               		 <div class="pay-content">
                	<div class="pay-amount">결제금액(KRW)</div>
                	<div id="pay"><%=f.getFripPrice() * attendNumber%></div>
                </div>
                    <button id="payBtn">확인 및 결제</button>
                </div>
            </div>
            <div class="contents-right">
                <div class="attend-box">
                    <div class="attend-info">
                        <div class="addr"><%=f.getFripAddr() %></div>
                        <div class="small-title"><%=f.getFripTitle() %></div>
                    </div>
                        <div class="attend-info">
                            <div class="title">요금 세부정보 </div>
                            <div class="pricebox"><%=f.getFripPrice() %> 원/인당</div>
                            <div class="totalprice">총 합계 (KRW)</div>
                            <div class="pricebox"><%=f.getFripPrice() * attendNumber%> 원</div>
                        </div>
                        <div class="attend-info">
                            <div class="title">환불 정책</div>
                            <p>환불이 불가능한 예약입니다. </p>
                        </div>
                </div>
            </div>
        </div>
    </div>
	<script>
		$("#payBtn").on("click", function(){
			const price = $("#pay").text();
			const d = new Date();
			const date = d.getFullYear()+""+(d.getMonth()+1)+""+d.getDate()+""+d.getHours()+""+d.getMinutes()+""+d.getSeconds();
			const attendNumber = $("#attendNumber").val();
			const memberNo = $("#memberNo").val();
			const fripNo = $("#fripNo").val();
			
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
					$.ajax({
			            type : "POST",
			            url : "insertpayment.do",
			            data : {
			               date : date,
			               price : price,
			               memberNo : payer,
			               fripNo : fripNo,
			               memberNo : memberNo
			            },
			            dataType : "json",
			            success : function(data) {
			            	alert("결제성공");
			            },
			            error : function() {
			            }
			         });
					//결제관련 정보를 DB insert 하는 작업이 필요 
				}else{
					alert("결제실패");
				}
			});
		});
		
		$(document).ready(function() {
			  $('.material-symbols-rounded').on('click', function() {
			    window.location.href = 'joinFrip.do?fripNo='+<%=f.getFripNo()%>;
			  });
			});
	</script>
	<%@ include file="/WEB-INF/views/common/footer.jsp"%>
</body>
</html>