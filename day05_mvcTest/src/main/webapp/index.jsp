<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel = "stylesheet" href = "${pageContext.request.contextPath}/assets/css/layout.css">
</head>
<body>
	<%-- <%@ include file = "${pageContext.request.contextPath}/header.jsp"%> --%>
	<jsp:include page="/header.jsp"></jsp:include>
	<!-- ${pageContext.request.contextPath} jstl에서 제공하는 url 경로를 잡기 위해 사용 -->
	
	<c:choose>
		<c:when test="${not empty sessionScope.memberNumber}">
			<h1>${sessionScope.memberName}님 환영합니다!</h1>
			<form action="" method="">
				<button>logout</button>
			</form>
		</c:when>
		<c:otherwise>
		<form action="${pageContext.request.contextPath}/member/join.me" method="get">
			<button>회원가입</button>
		</form>
		<a href="${pageContext.request.contextPath}/member/login.me">로그인 하러가기</a>
		</c:otherwise>
	</c:choose>
</body>
</html>