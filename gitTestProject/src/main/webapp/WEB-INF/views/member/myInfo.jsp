
<%@page import="kr.or.iei.member.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
Member member = (Member) request.getAttribute("m");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/member/myinfo.css">
<link rel="stylesheet" href="/css/summernote/summernote-lite.css">
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp"%>
	<div class="page-content">
		<div class="join-wrap">
			<div class="join-header">
				<h1>내 정보</h1>
			</div>
			<hr>
			<div class="join-content">
				<form action="/updateMyInfo.do" method="post" class="profile-form" enctype="multipart/form-data">
					<div class="inputs-wrap">
						<div class="join-input-wrap">
							<div class="profile-image-wrap">
							<input type="hidden" name="status" value="stay">
							
							
							<button type="button" class="delFile"><img src="/upload/member/삭제.png" id="delProfile"></button>
							<%if(member.getMemberProfile() != null) { %>
								<img src="/upload/member/<%=member.getMemberProfile() %>" class="profile-img" width="100px">
								<label for="upProfile">
                                        <img src="/upload/member/camera.png" id="camera">
                                    </label>
                                    <input type="file" name="upProfile" id="upProfile" class="input-form"
                                        accept=".jpg,.png,.jpeg" onchange="loadImg(this);">
                                        <input type="hidden" name="oldProfile" value="<%=member.getMemberProfile() %>">
                                        <%}else{ %>
                                        
                                        <img src="/upload/member/no-profile.png" class="profile-img" width="100px">
									<label for="upProfile">
                                        <img src="/upload/member/camera.png" id="camera">
                                    </label>
                                    <input type="file" name="upProfile" id="upProfile" class="input-form"
                                        accept=".jpg,.png,.jpeg" onchange="loadImg(this);">
                                        <%} %>
							</div>
						</div>
						<div class="join-input-wrap">
							<div>
								<label for="memberId">이메일</label>
							</div>
							<div>
								<input type="text" name="memberId" id="memberId"
									value="<%=member.getMemberId()%>" readonly>

							</div>
						</div>
						<div class="join-input-wrap">
							<div>
								<label for="memberPw">비밀번호</label>
							</div>
							<div>
								<input type="password" name="memberPw" id="memberPw"
									value="<%=member.getMemberPw()%>">
							</div>
						</div>
						<div class="join-input-wrap">
							<div>
								<label for="pwre">비밀번호 확인</label>
							</div>
							<div>
								<input type="password" name="pwre" id="pwre">
							</div>
						</div>
						<div class="join-input-wrap">
							<div>
								<label for="memberName">이름</label>
							</div>
							<div>
								<input type="text" name="memberName" id="memberName"
									value="<%=member.getMemberName()%>">
							</div>
						</div>
						<div class="join-input-wrap">
							<div>
								<label for="memberPhone">전화번호</label>
							</div>
							<div>
								<input type="text" name="memberPhone" id="memberPhone"
									value="<%=member.getMemberPhone()%>">
							</div>
						</div>
						<div class="join-input-wrap">
							<div>
								<label for="memberAddr">주소</label>
							</div>
							<div>
								<input type="text" name="memberAddr" id="memberAddr"
									value="<%=member.getMemberAddr()%>" readonly>
								<button type="button" class="addr-btn" onclick="searchAddr();">주소검색</button>
							</div>
							<div>
								<input type="text" name="memberAddrDetail" id="memberAddrDetail"
								value="<%=member.getMemberAddrDetail()%>">

							</div>
						</div>
					</div>
					<div class="join-btn-wrap">
						<input type="submit" value="수정하기"> <a
							href="/updateDeleteMember.do?memberId="<%=loginMember.getMemberId()%>">
							<input type="button" value="탈퇴하기" id="deleteMemberBtn"
							onclick="return func1();">
						</a>
					</div>
				</form>
			</div>
		</div>
		<script>
		
	
			function func1() {
				var result = confirm("회원탈퇴를 진행하시겠습니까?");
				if(result == false){
					return false;
				}
			}

			function searchAddr() {
				new daum.Postcode({
					oncomplete : function(data) {
						$("#memberAddr").val(data.address);
					}
				}).open();
			}
			
			function loadImg(f){
				//첨부파일이 여러개일 수 있어서 항상 배열로 처리
				console.log(f.files);
				//파일갯수가 0개가 아니고 && 첫번째 파일이 정상파일이면
				if(f.files.length != 0 && f.files[0] !=0){
					const reader = new FileReader(); //파일정보를 얻어올 수 있는 객체
					//선택한 파일 정보를 읽어옴
					reader.readAsDataURL(f.files[0]);
					//파일리더가 정보를 다 읽어오면 동작할 함수
					reader.onload = function(e){
						$(".profile-img").attr("src",e.target.result);
					}
				}else{
					$(".profile-img").attr("src","");
				}
				
			}
			
			$("button.delFile").on("click",function(){
    			$("[name=status]").val("delete");
    			$(".profile-img").attr("src","/upload/member/no-profile.png");
    		});	
		</script>
	</div>
	<%@ include file="/WEB-INF/views/common/footer.jsp"%>
</body>
</html>