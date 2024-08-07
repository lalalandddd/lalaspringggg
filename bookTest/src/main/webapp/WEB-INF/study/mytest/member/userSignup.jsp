<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2> 회원가입 화면입니다! </h2><br>
	<a href="/"> project home </a><br>
	<a href="/mytest"> === MY TEST PAGE!!! === </a><br>
	<a href="/library"> === 도서관 관리 프로그램 메인 화면 === </a><br>
	<div id="signupBox">
		<form method="post" action="/signup">
			<div class="joinInput">
				<label>아이디</label>
				<input type="text" name="userId" placeholder="아이디를 입력하세요">
			</div>
			<div class="joinInput">
				<label>비밀번호</label>
				<input type="password" name="userPw" placeholder="비밀번호를 입력하세요">
			</div>
			<div class="joinInput">
				<label>비밀번호 확인</label>
				<input type="password" name="pwRe" placeholder="비밀번호를 다시 입력하세요">
			</div>
			<div class="joinInput">
				<label>이메일</label>
				<input type="email" name="userEmail" placeholder="이메일을 입력하세요">
			</div>
			<div class="joinInput">
				<label>이름</label>
				<input type="text" name="userName" placeholder="이름을 입력하세요">
			</div>
			<div class="joinInput">
				<label>연락처</label>
				<input type="tel" name="userTel" placeholder="연락처를 입력하세요">
			</div>
			<div class="joinInput">
				<label>주소</label>
				<input type="text" name="userAddress" placeholder="주소를 입력하세요">
			</div>
			<div class="joinInput">
				<label>생년월일</label>
				<input type="text" name="userBirth" placeholder="생년월일을 입력하세요">
			</div>
			<button id="joinBt">도서관 회원 가입</button>
		</form>
	</div>
</body>
</html>