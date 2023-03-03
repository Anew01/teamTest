<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/member/join.css">
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp"%>
	<div class="content-wrap">
	  <div class="join-wrap">
        <div class="join-header">
            <h1>회원가입</h1>
        </div>
        <hr>
        <div class="join-content">
            <form action="join.html" method="post" autocomplete="off">
                <div class="inputs-wrap">
                    <div class="join-input-wrap">
                        <div>
                            <label for="id">이메일 <sup>*</sup></label>
                        </div>
                        <div>
                            <input type="text" name="id" id="id"  placeholder="이메일을 입력해주세요." onfocus="this.placeholder=''" onblur="this.placeholder='이메일을 입력해주세요.'" required> 
                            <button type="button" class="auth-btn">인증요청</button>
                        </div>
                        <div>
                            <input type="text" name="id-auth" id="id-auth" placeholder="인증번호를 입력해주세요." onfocus="this.placeholder=''" onblur="this.placeholder='인증번호를 입력해주세요.'" required> <!--길이 제외 나머지 디자인은 한번에 지정-->
                            <button type="button" class="chk-btn">확인</button>
                        </div>
                    </div>
                    <div class="join-input-wrap">
                        <div>
                            <label for="pw">비밀번호 <sup>*</sup></label>
                        </div>
                        <div>
                            <input type="text" name="pw" id="pw" placeholder="비밀번호를 입력해주세요." onfocus="this.placeholder=''" onblur="this.placeholder='비밀번호를 입력해주세요.'" required>
                        </div>
                    </div>
                    <div class="join-input-wrap">
                        <div>
                            <label for="pwre">비밀번호 확인 <sup>*</sup></label>
                        </div>
                        <div>
                            <input type="text" name="pwre" id="pwre" placeholder="비밀번호를 입력해주세요." onfocus="this.placeholder=''" onblur="this.placeholder='비밀번호를 입력해주세요.'" required>
                        </div>
                    </div>
                    <div class="join-input-wrap">
                        <div>
                            <label for="name">이름 <sup>*</sup></label>
                        </div>
                        <div>
                            <input type="text" name="name" id="name" placeholder="이름을 입력해주세요." onfocus="this.placeholder=''" onblur="this.placeholder='이름을 입력해주세요.'" required>
                        </div>
                    </div>
                    <div class="join-input-wrap">
                        <div>
                            <label for="name">전화번호</label>
                        </div>
                        <div>
                            <input type="text" name="name" id="name" class="long-input">
                        </div>
                    </div>
                    <div class="join-input-wrap">
                        <div>
                            <label>성별</label>
                        </div>
                        <div>
                            <input type="radio" name="gender" id="m" value="m">
                            <label for="m">남자</label>
                            <input type="radio" name="gender" id="f" value="f">
                            <label for="f">여자</label>
                        </div>
                    </div>
                    <div class="join-input-wrap">
                        <div>
                            <label for="id">주소</label>
                        </div>
                        <div>
                            <input type="text" name="addr" id="addr" > 
                            <button type="button" class="addr-btn">주소검색</button>
                        </div>
                        <div>
                            <input type="text" name="addr-detal" id="addr-detail" placeholder="상세주소를 입력해주세요." onfocus="this.placeholder=''" onblur="this.placeholder='상세주소를 입력해주세요.'" > 
                           
                        </div>
                    </div>
                    <h3 class="title">이용약관 확인 및 동의</h3>
                    <div>
                        <input type="checkbox" id="allAgreement">
                        <label for="allAgreement">이용약관 전체체크</label>
                    </div>
                    <div class="agreebox">
                        <div>
                            <input type="checkbox" id="privacyAgreement" class="agreeCheck">
                            <label for="privacyAgreement">개인정보 수집 및 이용에 동의 <span class="fc-blue">(필수)</span></label>
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
                            <label for="optionalAgreement">개인정보 수집 및 이용에 동의 <span class="fc-blue">(선택)</span></label>
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
                    <input type="submit" value="회원가입">
                </div>
            </form>
        </div>
    </div>
	</div>
	<%@ include file="/WEB-INF/views/common/footer.jsp"%>
</body>
</html>