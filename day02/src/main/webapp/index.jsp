<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1>GET / POST 예제</h1>
   <form action="handler" method="get">
      <label for="name">이름(GET) : </label>
      <input type="text" id="name" name="userName" placeholder="이름 입력"><br>
      <button type="submit">GET요청</button>
   </form>
   
   <form action="handler" method="post">
      <label for="email">이메일(POST) : </label>
      <input type="email" id="email" name="email"><br>
      <button type="submit">POST요청</button>
   </form>
   
   <h1>forward / redirect 예제</h1>
   <form action="forward" method="post">
      <label for="forwardName">Forward 이름 : </label>
      <input type="text" id="forwardName" name="forwardName"><br>
      <button type="submit">Forward 요청</button>
   </form>
   
   <form action="redirect" method="post">
      <label for="redirectName">Redirect 이름 : </label>
      <input type="text" id="redirectName" name="redirectName"><br>
      <button type="submit">Redirect 요청</button>
   </form>
      
</body>
</html>