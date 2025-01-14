<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 태그</title>
</head>
<body>
	<!-- 선언문 : JSP 내에서 전역변수와 메소드 선언 -->
	<%!
		int num1 = 15;
		int num2 = 20;
		
		int multiply() {
			return num1 * num2;
		}
	%>
	
	
	<!-- 표현식 : 변수와 메소드 결과 출력 -->
	<h2>num1 : <%= num1 %></h2>
	<h2>num2 : <%= num2 %></h2>
	
	<h3>곱셈결과 : <%= multiply() %></h3>
	
	
	<!-- 스크립틀릿 : 지역변수 선언 -->
	<% 
		int num3 = 30;
		String msg = "JSP에서 스크립틀릿 사용";
	%>
	
	<h2>num3 : <%= num3 %></h2>
	<h2>메세지 : <%= msg %></h2>
	
	
	<!-- 반복문 -->
	<% 
		for (int i = 1; i <= 5; i++) {
			out.println("<p>" + i + "번째 출력입니다</p>");
		}
	%>
	
	
	<!-- 혼합된 JSP, HTML -->
	<h1>for문과 HTML 태그 혼합</h1>
	<% 
		for (int i = 1; i <= 5; i++) {
	%>
		<p style="color:blue;">현재 숫자 : <%= i %></p>
	<% } %>
	
	
	<!-- 조건문 -->
	<h1>if문 출력</h1>
	<%
		if (num1 > 1) {
	%>
		<p style="color:pink;">num1은 1보다 큽니다.</p>
	<%
		} else {
	%>
		<p style="color:pink;">num1은 1보다 작습니다.</p>
	<%
		}
	%>
</body>
</html>