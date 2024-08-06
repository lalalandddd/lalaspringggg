<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2> 회원 로그인 확인 화면입니다! </h2>
	<p>입력 확인창</p>
	<p>${userlogin.userId }</p>
	<p>${userlogin.userPw }</p>
	<c:if test="${ userlogin.userId eq 'asdf' and userlogin.userPw eq '1234' }" >
		<p>${userlogin.userId } 회원님 반갑습니다!!</p>
	</c:if>
	<a href="/library"></a>
</body>
</html>