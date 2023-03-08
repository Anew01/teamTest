<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/member/find-pw-frm.css">
</head>
<body>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<div class="page-content">
<div class="join-wrap">
        <div class="join-header">
            <span>비밀번호 찾기</span>
        </div>
        <hr>
        <div class="join-content">
            <form action="/findPw.do" method="post" autocomplete="off">
                <div class="inputs-wrap">
                    <div class="join-input-wrap">
                        <div>
                            <input type="email" name="memberId" id="memberId" placeholder="이메일을 입력해주세요." onfocus="this.placeholder=''"
									onblur="this.placeholder='이메일을 입력해주세요.'" required> 
                        </div>
                        <span>재설정하려는 비밀번호의 아이디(이메일)을 입력해주세요.</span>
                    </div>
                <div class="join-btn-wrap">
                    <input type="submit" value="이메일 발송">
                </div>
            </form>
        </div>
    </div>
    <script>
        $("input[type=text]").on("focus",function(){
            $(this).val('');
        });
        
   
    	<%-- 이메일 인증하기 --%>
    	
    		let mailCode;
    		
    		$("input[type=submit]").on("click", function() {
    			const email = $("#memberId").val();
    		

    			$.ajax({
    				url : "/sendMailPw.do",
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
        
        
        
    </script>
</div>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>