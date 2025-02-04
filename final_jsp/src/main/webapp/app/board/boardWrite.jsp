<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>글쓰기</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/boardWrite.css" />
</head>
<body>
	<jsp:include page="/header.jsp" />
	<div class="container">
		<!-- 작성완료 경로 처리하기 -->
		<form id="write-form"
			action="${pageContext.request.contextPath}/board/boardWriteOk.bo"
			method="post" enctype="multipart/form-data">
			<h1>글쓰기</h1>
			<div class="form-group">
				<label for="title">제목</label> <input type="text" id="title"
					name="boardTitle" required />
			</div>
			<div class="form-group">
				<label for="author">작성자</label>
				<!-- 작성자 서버 연결시 로그인한 회원 아이디로 수정하기 -->
				<!-- <div class="writer">홍길동</div> -->
				<div class="writer">
					<c:out value="${memberId}" />
				</div>
			</div>
			<div class="form-group">
				<label for="content">내용</label>
				<textarea id="content" name="boardContent" required></textarea>
			</div>
			<!-- 			<div class="form-group">
				<label for="file">파일 첨부</label> <input type="file" id="file"
					name="boardFile" />
			</div> -->
			<div class="form-group">
				<label for="file">파일 첨부</label>

				<div class="image-upload-wrap">
					<input type="file" id="file" name="boardFile" />
<!-- 						accept=".jpg, .jpeg, .png" multiple /> -->
					<div class="image-upload-box">
						<div class="upload-text">
							<div class="upload-icon">
								<svg viewBox="0 0 48 48">
						<path fill-rule="evenodd" clip-rule="evenodd"
										d="M25.9087 8.12155L36.4566 18.3158C37.2603 18.7156 38.2648 18.6156 38.968 18.3158C39.6712 17.5163 39.6712 16.4169 38.968 15.7173L25.3059 2.5247C24.6027 1.8251 23.4977 1.8251 22.7945 2.5247L9.03196 15.8172C8.32877 16.5168 8.32877 17.6162 9.03196 18.3158C9.73516 19.0154 10.9406 19.0154 11.6438 18.3158L22.2922 8.12155V28.4111C22.2922 29.4106 23.0959 30.2091 24.1005 30.2091C25.105 30.2091 25.9087 29.4106 25.9087 28.4111V8.12155ZM5.61644 29.4104C5.61644 28.4109 4.81279 27.6104 3.80822 27.6104C2.80365 27.6104 2 28.5099 2 29.5093V44.202C2 45.2015 2.80365 46 3.80822 46H44.1918C45.1963 46 46 45.2015 46 44.202V29.5093C46 28.5099 45.1963 27.7113 44.1918 27.7113C43.1872 27.7113 42.3836 28.5099 42.3836 29.5093V42.3021H5.61644V29.4104Z"></path></svg>
							</div>
							<div class="upload-count">
								<!-- 이미지 업로드(<span class="cnt">0</span>/5) -->
								이미지 업로드(<span class="cnt">0</span>/1)
							</div>
						</div>
						<div class="upload-text"><!-- 최대 5개까지 업로드 가능 -->최대 1개 업로드 가능</div>
						<div class="upload-text">파일 형식 : jpg, png</div>
						<div class="upload-text">※ 이미지를 등록하면 즉시 반영됩니다.</div>
					</div>
				</div>
				<div class="img-controller-box">
					<ul class="file-list">

					</ul>
				</div>
			</div>
			<div class="btn-group">
				<button type="submit" class="submit-btn">작성 완료</button>
				<!-- 취소 버튼 js로 처리하기 -->
				<button type="button" class="cancle-btn">취소</button>
			</div>
		</form>
	</div>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script
		src="${pagetContext.request.contextPath}/assets/js/boardWrite.js"></script>
</body>
</html>
