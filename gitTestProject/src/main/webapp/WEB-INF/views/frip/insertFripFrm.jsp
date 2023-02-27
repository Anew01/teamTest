<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/js/jquery-3.6.3.min.js"></script>
<script src="/js/summernote-lite.js"></script>
<script src="/js/summernote-ko-KR.js"></script>
<link rel="stylesheet" href="/css/summernote/summernote-lite.css">
</head>
<body>
	<div class="page-content">
		<div class="page-title">스프립 등록</div>
		<form action="insertFrip.do" method="post" enctype="multipart/form-data">
			<div>
				<label for="fripTitle">스프립 제목</label>
				<input type="text" name="fripTitle" id="fripTitle">
				<button type="button">중복체크</button>
			</div>
			<div>
				<label for="fripFiles">스프립 프로필 사진</label>
				<input type="file" multiple="multiple" accept=".jpg,.png,.jpeg" name="fripFiles" id="fripFiles" onChange="uploadFiles(this)">
			</div>		
			<div id="FilesView"></div>
			<div>
				<label for="fripAddr">스프립 주소</label>
				<input type="text" name="fripAddr" id="fripAddr">
			</div>
			<div>
				<label for="fripLevel">난이도</label>
				<input type="radio" name="fripLevel" id="easy" value="easy">
				<label for="easy">쉬움</label>
				<input type="radio" name="fripLevel" id="medium" value="medium">
				<label for="medium">보통</label>
				<input type="radio" name="fripLevel" id="hard" value="hard">
				<label for="hard">어려움</label>
			</div>
			<div>
				<label for="fripPrice">스프립 가격</label>
				<input type="text" name="fripPrice" id="fripPrice">
			</div>
			<div>
				<label for="fripContent">스프립 내용</label>
				<textarea id="summernote" name="editordata"></textarea>
			</div>
			<button type="submit">등록하기</button>
		</form>
	</div>
	<script>
		function uploadFiles(fs){
			if(fs.files.length != 0 && fs.files[0] != 0){
				for(let i=0;i<fs.files.length;i++){
					const reader = new FileReader();
					reader.readAsDataURL(fs.files[i]);
					reader.onload = function(e){
						const img = $("<img>").attr("src", e.target.result);
						$("#FilesView").append(img)
					}
				}
			} else {
				$("#FilesView").attr("src","");
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
	</script>
</body>
</html>