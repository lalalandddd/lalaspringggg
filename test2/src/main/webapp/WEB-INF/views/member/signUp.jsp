<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2> 회원가입 </h2>
	<div id="signupBox">
		<form method="post" action="/signUp">
			<div class="joinInput">
				<label>아이디</label>
				<input type="text" name="userId" placeholder="아이디를 입력하세요">
			</div>
			<div class="joinInput">
				<label>비밀번호</label>
				<input type="password" name="userPw" placeholder="비밀번호를 입력하세요">
			</div>
			<div class="joinInput">
				<label>이메일</label>
				<input type="email" name="userEmail" placeholder="이메일을 입력하세요">
			</div>
			<div class="joinInput">
				<label>연락처</label>
				<input type="tel" name="userTel" placeholder="연락처를 입력하세요">
			</div>
			<div class="joinInput">
				<label>생년월일</label>
				<input type="text" name="userBirth" placeholder="생년월일을 입력하세요">
			</div>
			<button id="joinBt">가입</button>
		</form>
	</div>
</body>
</html>