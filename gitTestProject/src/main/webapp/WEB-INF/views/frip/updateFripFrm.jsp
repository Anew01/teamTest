<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	Frip f = (Frip)request.getAttribute("f");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/summernote/summernote-lite.css">
<link rel="stylesheet" href="/css/fripPage/updateFripFrm.css">
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<script src="/js/summernote-lite.js"></script>
	<script src="/js/summernote-ko-KR.js"></script>
	<div class="page-content">
		<%@include file="/WEB-INF/views/frip/fripSideBar.jsp" %>
		<div class="form-content" style="width: 700px;">
			<div class="page-title"><h2>스프립 수정</h2></div>
			<form action="updateFrip.do" method="post" enctype="multipart/form-data">
				<input type="hidden" id="fripNo" name="fripNo" value="<%=f.getFripNo()%>">
				<input type="hidden" id="delFilepath" name="delFilepath">
				<div class="input-group mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text">스프립 제목</span>
					</div>
					<input type="text" class="form-control" name="fripTitle" id="fripTitle" value="<%=f.getFripTitle()%>" required>
				</div>
				<div class="input-group">
					<div class="input-group-prepend">
						<span class="input-group-text">스프립 프로필 사진</span>
					</div>
					<input type="file" class="form-control" multiple="multiple" accept=".jpg,.png,.jpeg" name="fripFiles" 
						id="fripFiles" onChange="uploadFiles(this)">
				</div>
				<div class="input-group">
					<div class="input-group-prepend">
						<span class="input-group-text">스프립 주소</span>
					</div>
					<input type="text" class="form-control" name="fripAddr" id="fripAddr" value="<%=f.getFripAddr()%>" readonly required>
					<div class="input-group-append">
						<button type="button" class="btn btn-outline-secondary" id="findAddrBtn">주소찾기</button>
					</div>
				</div>
				<input type="hidden" value="">
				<div class="input-group mb-3">
					<div class="input-group-prepend">
						<label class="input-group-text" for="fripAddrDetail">스프립 상세주소</label>
					</div>
					<input type="text" class="form-control" name="fripAddrDetail" id="fripAddrDetail" value="<%=f.getFripAddrDetail() %>" required>
				</div>
				<div class="input-group mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text">난이도</span>
					</div>
					<div class="input-group-text">
						<% if(f.getFripLevel() != null && f.getFripLevel().equals("EASY")) { %>
							<input type="radio" name="fripLevel" id="easy" value="EASY" checked>
						<% } else { %>
							<input type="radio" name="fripLevel" id="easy" value="EASY">
						<% } %>
					</div>
					<label for="easy" class="form-control">
						<span>쉬움</span>
					</label>
					<div class="input-group-text">
						<% if(f.getFripLevel() != null && f.getFripLevel().equals("MEDIUM")) { %>
							<input type="radio" name="fripLevel" id="medium" value="MEDIUM" checked>
						<% } else { %>
						<input type="radio" name="fripLevel" id="medium" value="MEDIUM">
						<% } %>
					</div>
					<label for="medium" class="form-control">
						<span>보통</span>
					</label>
					<div class="input-group-text">
						<% if(f.getFripLevel() != null && f.getFripLevel().equals("HARD")) { %>
							<input type="radio"  name="fripLevel" id="hard" value="HARD" checked>
						<% } else { %>
							<input type="radio"  name="fripLevel" id="hard" value="HARD">
						<% } %>
					</div>
					<label for="hard" class="form-control">
						<span>어려움</span>
					</label>
				</div>
				<div class="input-group mb-3">
					<div class="input-group-prepend">
						<label class="input-group-text" for="fripCategory">스프립 카테고리</label>
					</div>
					<input type="hidden" id="oldCategory" value="<%=f.getFripCategory() %>">
					<select class="form-control" name="fripCategory" style="width : max-content;" id="fripCategory" required>
					    <option selected>카테고리...</option>
					    <option value="아웃도어">아웃도어</option>
					    <option value="피트니스">피트니스</option>
					    <option value="공예DIY ">공예DIY</option>
					    <option value="스포츠">스포츠</option>
					    <option value="요리">요리</option>
					    <option value="온라인">온라인</option>
					    <option value="자기계발">자기계발</option>
					    <option value="뷰티">뷰티</option>
					    <option value="모임">모임</option>
					    <option value="국내여행">국내여행</option>
					    <option value="해외여행">해외여행</option>
  					</select>
				</div>
				<div class="input-group mb-3">
					<div class="input-group-prepend">
						<label class="input-group-text" for="fripPrice">스프립 가격</label>
					</div>
					<input type="text" class="form-control" name="fripPrice" id="fripPrice" value="<%= f.getFripPrice() %>" required>
				</div>
				<div class="form-group">
					<label for="fripContent">스프립 내용</label>
					<textarea id="summernote" name="editordata" required><%= f.getFripContent() %></textarea>
				</div>
				<div class="submit-btn-warpper">
					<button type="submit" class="btn btn-primary btn-lg btn-block" style="width : 100%;">수정하기</button>
				</div>
			</form>
		</div>
		<div class="slide-page">
			<div class="slide-wrapper">
				<div class="slide-title"><h4>이미지 미리보기</h4></div>
				<div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="true">
			  		<div class="carousel-inner">
			  			<% if(f.getFilePath().size() > 0) { %>
				  			<% for(int i=0;i<f.getFilePath().size();i++) { %>
								<% if(i == 0){ %>
									<div class="carousel-item active">
										<img src="/upload/photo/<%=f.getFilePath().get(i)%>">
										<button class="btn btn-danger" id="deleteBtn-<%=i%>" style="width : 100%" onclick="deleteExistImg('<%=f.getFilePath().get(i)%>')">삭제</button> 
									</div>
								<% } else { %>
									<div class="carousel-item">
										<img src="/upload/photo/<%=f.getFilePath().get(i)%>">
										<button class="btn btn-danger" id="deleteBtn-<%=i%>" style="width : 100%" onclick="deleteExistImg('<%=f.getFilePath().get(i)%>')">삭제</button> 
									</div>
								<% } %>
							<% } %>
			  			<% } %>
			  		</div>
					<button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
						<span class="carousel-control-prev-icon" aria-hidden="true"></span>
						<span class="visually-hidden">Previous</span>
					</button>
					<button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
						<span class="carousel-control-next-icon" aria-hidden="true"></span>
						<span class="visually-hidden">Next</span>
					</button>
				</div>
			</div>
		</div>
	</div>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
	<script>
		function uploadFiles(fs){
			if(fs.files.length != 0 && fs.files[0] != 0){
				for(let i=0;i<fs.files.length;i++){
					const reader = new FileReader();
					reader.readAsDataURL(fs.files[i]);
					reader.onload = function(e){
						const div = $("<div>").addClass("carousel-item");
						const button = $("<button>").addClass("btn btn-danger");
						button.attr("onclick","deleteNewImg("+i+")");
						button.addClass("delNewImgBtn")
						button.css("width","100%");
						button.append("삭제");
						if($(".carousel-inner").children().length == 0){
							if(i == 0){
								div.addClass("active");
							}							
						}
						const img = $("<img>").attr("src", e.target.result);
						div.append(img);
						div.append(button);
						$(".carousel-inner").append(div);
					}
				}
			} else {
				const div = $("<div>").addClass("carousel-item");
				div.addClass("active");
				const img = $("<img>").attr("src", "");
				$(".carousel-inner").append(img);
			}
		}
		$('#summernote').summernote({
			  height: 300,                 // 에디터 높이
			  minHeight: null,             // 최소 높이
			  maxHeight: null,             // 최대 높이
			  focus: true,                  // 에디터 로딩후 포커스를 맞출지 여부
			  lang: "ko-KR",					// 한글 설정
			  placeholder: '최대 2048자까지 쓸 수 있습니다'	//placeholder 설정
	          
		});
		$("#findAddrBtn").on("click",function(){	
			new daum.Postcode({
		        oncomplete: function(data) {
		        	$("#fripAddr").val(data.address)
		        }
		    }).open();
		})
		
		$(function(){
			const category = $("#oldCategory").val();
			const options = $("#fripCategory").children();
			options.each(function(i, option){
				if($(option).val() == category) {
					$(option).prop("selected", true);
				} 
			})
		})
		
		const list = new Array();
		function deleteExistImg(obj){
			//slide에서 img삭제
			deleteImgFromSlide();
			
			list.push(obj);
			const delInput = $("#delFilepath");
			delInput.val(list);
		}
		
		function deleteNewImg(fileNum){
			
			deleteImgFromSlide();
				
			const dataTransfer = new DataTransfer();
		    
		    let files = $('#fripFiles')[0].files;	//사용자가 입력한 파일을 변수에 할당
		    
		    let fileArray = Array.from(files);	//변수에 할당된 파일을 배열로 변환(FileList -> Array)
		    
		    fileArray.splice(fileNum, 1);	//해당하는 index의 파일을 배열에서 제거
		   	fileArray.forEach(file => { dataTransfer.items.add(file); });		    	
		    //남은 배열을 dataTransfer로 처리(Array -> FileList)
		    
		    $('#fripFiles')[0].files = dataTransfer.files;	//제거 처리된 FileList를 돌려줌
		    
			const delBtns = $(".delNewImgBtn");
		    delBtns.each(function(i ,  btn){
		    	$(btn).attr("onclick","deleteNewImg("+i+")");			    	
		    });
		    
		}
		
		function deleteImgFromSlide(){
			const $carousel = $('#carouselExampleIndicators');
			const currentIndex = $('div.active').index();
			var ActiveElement = $carousel.find('.carousel-item.active');
			ActiveElement.remove();
			var NextElement = $carousel.find('.carousel-item').first();
			NextElement.addClass('active');
		}
	</script>
</body>
</html>