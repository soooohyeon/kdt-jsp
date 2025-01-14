<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><%=request.getAttribute("userName") %>님 환영합니다.</h1>
	<h1><%=request.getAttribute("userName") + "님의 2025년 나이는" + request.getAttribute("userAge") %>입니다.</h1>
	<h1>성별 : <%=request.getAttribute("userGender") %></h1>
	<h1>취미 : <%
		/* request.getAttribute()는 1개의 값을 문자열을 리턴해줌 */
		/* 앞에 문자열 자료형으로 강제 형변환 시켜줌 */
		String[] hobbies = (String[])request.getAttribute("userHobbies");
	 	if (hobbies != null) {
	 		for(String hobby : hobbies){
	            out.print(hobby + " ");
			}
		} else {
			out.print("취미가 없습니다");
		}
	%></h1>
</body>
</html>