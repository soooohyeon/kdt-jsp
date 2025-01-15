<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2><%= request.getAttribute("userName") %>님 환영합니다.</h2>
	아이디 : <%= request.getAttribute("userId") %><br>
	비밀번호 : <%= request.getParameter("userPw") %><br>
	나이 : <%= request.getParameter("userAge") %><br>
	성별 : <%= request.getParameter("userGender") %><br>
</body>
</html>