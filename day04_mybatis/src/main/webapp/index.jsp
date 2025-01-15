<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="MyServlet" method="get">
		<label for="id">아이디 : </label>
		<input type="text" id="id" name="userId"><br>
		<label for="pw">비밀번호 : </label>
		<input type="password" id="pw" name="userPw"><br>
		<label for="name">이름 : </label>
		<input type="text" id="name" name="userName"><br>
		<label for="age">나이 : </label>
		<input type="text" id="age" name="userAge"><br>
		<label>성별</label><br>
		<input type="radio" id="none" name="userGender" value="n" checked>
		<label for="none">선택안함</label>
		<input type="radio" id="male" name="userGender" value="m">
		<label for="male">남성</label>
		<input type="radio" id="female" name="userGender" value="f">
		<label for="female">여성</label><br>
		
		<button>로그인</button>
	</form>
</body>
</html>