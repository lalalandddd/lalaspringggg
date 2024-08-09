<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2> 회원가입 확인 화면 </h2><br>
	<h3> ${data.userId }님! 회원가입을 축하합니다! </h3><br>
	<p> 회원 ID : ${data.userId }</p>
	<p> 회원 비밀번호 : ${data.userPw }</p>
	<p> 회원 이름 : ${data.userName }</p>
	<p> 회원 이메일 : ${data.userEmail }</p>
	<p> 회원 전화번호 : ${data.userTel }</p>
	<p> 회원 주소 : ${data.userAddress }</p>
	<p> 회원 생일 : ${data.userBirth }</p>
	<a href="/library"> 도서관 메인 화면으로 돌아가기 </a><br>
</body>
</html>