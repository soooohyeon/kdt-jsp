<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- css, img, js 등의 파일을 이클립스 기준으로 경로를 잡는게 아닌 우리가 만든 파일도 웹상에 같이 올라가기 때문에 url 경로로 잡아야함 -->
<!-- 경로를 루트경로(최상위경로)로 잡았을때 루트 경로 변경시 파일마다 수정 해야함
	해서 jstl에서 제공하는 ${pageContext.request.contextPath}를 사용하여 루트 경로 설정해줘야함 -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/member/login.css">
</head>
<body>
	<main>
		<form action="" method="post">
			<div class="id">
				id : <input type="text" name="memberId">
			</div>
			
			<div class="password">
				password : <input type="password" name="memberPassword">
			</div>
	         <div class="btn">
	            <button>로그인</button>
	         </div>
		</form>
	</main>
</body>
</html>