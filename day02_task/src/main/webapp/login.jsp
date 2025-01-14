<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<h1>로그인</h1>
	<form action="resultServlet2" method="post">
		<!-- ID 입력 -->
		<label for="userId">ID : </label>
		<input type="text" id="userId" name="userId" required><br>
		<!-- PW 입력 -->
		<label for="userPw">PW : </label>
		<input type="password" id="userPw" name="userPw" required><br>
		
		<!-- 로그인 버튼 -->
		<button>Login</button>
	</form>
</body>
</html>