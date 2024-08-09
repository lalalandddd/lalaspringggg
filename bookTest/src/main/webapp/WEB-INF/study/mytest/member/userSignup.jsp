<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/write.css">
</head>
<body>
	<a href="/"> project home </a><br>
	<a href="/mytest"> === MY TEST PAGE!!! === </a><br>
	<a href="/library"> === 도서관 관리 프로그램 메인 화면 === </a><br><br>
	<h2> 회원 가입 페이지 </h2><br>
	<div id="wrap">
		<form method="post" action="/signup">
			<div id="formWrap">
				<div class="inputField">
					<label>아이디</label>
					<input type="text" name="userId" placeholder="아이디를 입력하세요">
				</div>
				<div class="inputField">
					<label>비밀번호</label>
					<input type="password" name="userPw" placeholder="비밀번호를 입력하세요">
				</div>
				<div class="inputField">
					<label>이름</label>
					<input type="text" name="userName" placeholder="이름을 입력하세요">
				</div>
				<div class="inputField">
					<label>이메일</label>
					<input type="email" name="userEmail" placeholder="이메일을 입력하세요">
				</div>
				<div class="inputField">
					<label>연락처</label>
					<input type="tel" name="userTel" placeholder="연락처를 입력하세요">
				</div>
				<div class="inputField">
					<label>주소</label>
					<input type="text" name="userAddress" placeholder="주소를 입력하세요">
				</div>
				<div class="inputField">
					<label>생년월일</label>
					<input type="text" name="userBirth" placeholder="생년월일(8자리)을 입력하세요">
				</div>
				<button id="bt">도서관 회원 가입</button>
			</div>
		</form>
	</div>
</body>
</html>