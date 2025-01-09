<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>서블릿 연습 결과</title>
</head>
<body>
<%-- <% %> 태그 영역은 자바 명령어를 작성하는 부분, '스크립틀릿'이라고 부름-->
	<!-- 스크립틀릿이 있을땐 주석시 !가 아닌 %로 작성 -->
	<%-- <h1><%=request.getParameter("userName")%>님 환영합니다</h1> --%>
	<!-- 서블릿에서 getParameter()를 설정해주었기 떄문에 getAttribute를 사용해서 값을 출력해줌 -->
	<h1><%= request.getAttribute("userName") %>님 환영합니다!</h1>
</body>
</html>