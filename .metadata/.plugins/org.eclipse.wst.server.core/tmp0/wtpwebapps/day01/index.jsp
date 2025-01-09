<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>서블릿 연습</title>
</head>
<body>
	<h1>안녕하세요!!</h1>
	<!--
	method의 get / post 를 작성하면 각 메소드 방식으로 전송해줌
	즉, get을 작성하면 서블릿에 doGet()메소드가 실행됨
	폼 태그의 method 속성을 생략하면 디폴트는 get
	get 방식 : 주소창에 전송하려는 데이터가 보여짐, 보안성 ↓
	-->
	<!-- action에 서블릿 경로를 작성해줌 -->
	<!-- 경로에 / 하나 차이로 오류가 발생 될수 있음 -->
	<form action="MyServlet" method="get">
		<input type="text" name="userName" placeholder="이름">
		<button>전송</button>
		<!-- 
		button 태그의 기본 타입 : submit
		submit은 현재 form 태그의 action에 작성된 경로로 요청 (request)
		이때, request에는 현재 폼에 속해있는 모든 폼 데이터를 가지고 있음
		
		index.jsp 파일인데 자바파일인 서블릿으로 요청을 보내기 위해서 서블릿에 어노테이션으로 등록된 경로를 작성해주면 됨
		action = "/hello"로 수정시 오류 발생
		-->
	</form>
</body> 
</html>