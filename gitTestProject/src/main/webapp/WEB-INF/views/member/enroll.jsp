<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/member/enroll.css">
<link rel="stylesheet" href="/css/summernote/summernote-lite.css">

<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp"%>
	<div class="page-content">
		<div class="join-wrap">
			<div class="join-header">
				<h1>회원가입</h1>
			</div>
			<hr>
			<div class="join-content">
				<form action="/enroll.do" method="post" autocomplete="off">
					<div class="inputs-wrap">
						<div class="join-input-wrap">
							<div>
								<label for="memberId">이메일 <sup>*</sup></label>
							</div>
							<div>
								<input type="text" name="memberId" id="memberId"
									placeholder="이메일을 입력해주세요." onfocus="this.placeholder=''"
									onblur="this.placeholder='이메일을 입력해주세요.'" required>
								<button type="button" class="auth-btn" id="auth-btn">인증요청</button>
							</div>
							<div>
								<input type="text" name="id-auth" id="id-auth"
									placeholder="인증번호를 입력해주세요." onfocus="this.placeholder=''"
									onblur="this.placeholder='인증번호를 입력해주세요.'" required>
								<button type="button" class="chk-btn">확인</button>
								<span id="timeZone"></span> <span id="authMsg"></span>
							</div>
						</div>
						<div class="join-input-wrap">
							<div>
								<label for="memberPw">비밀번호 <sup>*</sup></label>
							</div>
							<div>
								<input type="password" name="memberPw" id="memberPw"
									placeholder="비밀번호를 입력해주세요." onfocus="this.placeholder=''"
									onblur="this.placeholder='비밀번호를 입력해주세요.'" required>
							</div>
						</div>
						<div class="join-input-wrap">
							<div>
								<label for="pwre">비밀번호 확인 <sup>*</sup></label>
							</div>
							<div>
								<input type="password" name="pwre" id="pwre"
									placeholder="비밀번호를 입력해주세요." onfocus="this.placeholder=''"
									onblur="this.placeholder='비밀번호를 입력해주세요.'" required>
							</div>
						</div>
						<div class="join-input-wrap">
							<div>
								<label for="memberName">이름 <sup>*</sup></label>
							</div>
							<div>
								<input type="text" name="memberName" id="memberName"
									placeholder="이름을 입력해주세요." onfocus="this.placeholder=''"
									onblur="this.placeholder='이름을 입력해주세요.'" required>
							</div>
						</div>
						<div class="join-input-wrap">
							<div>
								<label for="memberPhone">전화번호</label>
							</div>
							<div>
								<input type="text" name="memberPhone" id="memberPhone"
									class="long-input">
							</div>
						</div>
						<!-- 
                    <div class="join-input-wrap">
                        <div>
                            <label>성별</label>
                        </div>
                        <div>
                            <input type="radio" name="memberGender" id="m" value="m">
                            <label for="m">남자</label>
                            <input type="radio" name="memberGender" id="f" value="f">
                            <label for="f">여자</label>
                        </div>
                    </div>
                     -->
						<div class="join-input-wrap">
							<div>
								<label for="memberAddr">주소</label>
							</div>
							<div>
								<input type="text" name="memberAddr" id="memberAddr" readonly>
								<button type="button" class="addr-btn" onclick="searchAddr();">주소검색</button>
							</div>
							<div>
								<input type="text" name="memberAddrDetail" id="memberAddrDetail"
									placeholder="상세주소를 입력해주세요." onfocus="this.placeholder=''"
									onblur="this.placeholder='상세주소를 입력해주세요.'">

							</div>
						</div>
						<h3 class="title">이용약관 확인 및 동의</h3>
						<div>
							<input type="checkbox" id="allAgreement"> <label
								for="allAgreement">이용약관 전체체크</label>
						</div>
						<div class="agreebox">
							<div>
								<input type="checkbox" id="privacyAgreement" class="agreeCheck">
								<label for="privacyAgreement">개인정보 수집 및 이용에 동의 <span
									class="fc-blue">(필수)</span></label>
								<div class="agreeContent">
									<ul>
										<li>수집항목 : 이름, 휴대전화번호, 생년월일, 비밀번호</li>
										<li>수집·이용목적 : 회원제 서비스 제공</li>
										<li>보유 및 이용기간 : 회원탈퇴 시 까지</li>
									</ul>
								</div>
							</div>
						</div>
						<div class="agreebox">
							<div>
								<input type="checkbox" id="optionalAgreement" class="agreeCheck">
								<label for="optionalAgreement">개인정보 수집 및 이용에 동의 <span
									class="fc-blue">(선택)</span></label>
								<div class="agreeContent">
									<ul>
										<li>수집항목 : 이름, 휴대전화번호, 생년월일, 비밀번호</li>
										<li>수집·이용목적 : 회원제 서비스 제공</li>
										<li>보유 및 이용기간 : 회원탈퇴 시 까지</li>
									</ul>
								</div>
							</div>
						</div>
					</div>
					<div class="join-btn-wrap">
						<input type="submit" value="회원가입" onsubmit="checkAuth();">
					</div>
				</form>
			</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/views/common/footer.jsp"%>
	<script>
		function searchAddr() {
			new daum.Postcode({
				oncomplete : function(data) {
					$("#memberAddr").val(data.address);
				}
			}).open();
		}
	<%-- 이메일 인증하기 --%>
		let mailCode;
		$("#auth-btn").on("click", function() {
			const email = $("#memberId").val();
			$("#timeZone").html("");
			$("#authMsg").text("");
			$("#id-auth").val("");

			$.ajax({
				url : "/sendMail.do",
				data : {
					email : email
				},
				type : "post",
				success : function(data) {
					if (data == "null") {
						alert("이메일 주소를 확인해주세요.");
					} else {
						mailCode = data;
	<%-- $("#auth").slideDown(); --%>
		authTime();
					}

				},
				error : function() {
					console.log("에러발생");
				}
			});

		});

		let intervalId;
		function authTime() {
			$("#timeZone").html(
					"<span id='min'>3</span> : <span id='sec'>00</span>");
			intervalId = window.setInterval(function() {
				timeCount();
			}, 1000);
		}
		function timeCount() {
			const min = $("#min").text();
			const sec = $("#sec").text();
			if (sec == "00") {
				if (min != "0") {
					const newMin = Number(min) - 1;
					$("#min").text(newMin);
					$("#sec").text(59);
				} else {
					window.clearInterval(intervalId);
					mailCode = null;
					$("#authMsg").text("인증시간 만료");
					$("#authMsg").css("color", "red");
				}
			} else {
				const newSec = Number(sec) - 1;
				if (newSec < 10) {
					$("#sec").text("0" + newSec);
				} else {
					$("#sec").text(newSec);

				}
			}

		}

		$(".chk-btn").on("click", function() {
			if (mailCode == null) {
				$("#authMsg").text("인증시간 만료");
				$("#authMsg").css("color", "red");
			} else {
				const authCode = $("#id-auth").val();

				if (authCode == mailCode) {
					$("#authCode").prop("readonly", true);
					$("#memberId").prop("readonly", true);
					$("#authMsg").text("인증완료");
					$("#authMsg").css("color", "blue");
					window.clearInterval(intervalId);

				} else {
					$("#authMsg").text("인증실패");
					$("#authMsg").css("color", "red");
				}
			}
		});

		function checkAuth() {
			if ($("#authMsg").text("인증완료")) {
				return true;
			} else {
				return false;
			}

		};
	</script>

</body>
</html>