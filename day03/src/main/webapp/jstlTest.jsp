<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>결과 출력</h1>
	<!-- 서블릿에서 넘겨주는 값이 없는데 작성이 될 경우 오류 발생 -->
	<%-- <h3><%= request.getAttribute("name") %></h3> --%>
	<!-- 서블릿에서 담아준 name : 짱구 -->
	<h3>${name}</h3>
	
	<!-- 기존 값에 홍길동이라는 이름으로 값 수정 -->
	<% pageContext.setAttribute("name", "홍길동");  %>
	<h3>${name}</h3>
	
	<!-- 서블릿에서 쿼리스트링으로 전달한 name : 철순 -->
	<h3>${param.name}</h3>
	
	<!-- 서블릿에서 담아준 name : 짱구 -->
	<h3>${requestScope.name}</h3>
</body>
</html>