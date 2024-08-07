<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/"> === 프로젝트 시작화면 === </a>
	<p>HOME!!</p>
	<h3>개인정보 입력</h3>
	<form method="get" action="/infoInput">
		이름 : <input type="text" name="uName" placeholder="이름 입력하쎄요!"><br>
		생년월일 : <input type="text" name="uBirth" placeholder="생년월일(8자리) 입력하쎄요!"><br>
		<button>입력</button>
	</form>
</body>
</html>