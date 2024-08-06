<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2> 로그인 </h2>
	<div id="signupBox">
		<form method="post" action="/login">
			<div class="loginInput">
				<label>아이디</label>
				<input type="text" name="userId" placeholder="아이디를 입력하세요">
			</div>
			<div class="loginInput">
				<label>비밀번호</label>
				<input type="password" name="userPw" placeholder="비밀번호를 입력하세요">
			</div>
			<button id="loginBt">로그인</button>
		</form>
	</div>
</body>
</html>
