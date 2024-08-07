<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2> 은행, 잔액 정보 입력 페이지 </h2>
	<form method="post" action="/result">
		은행명 : <input type="text" name="bankName" placeholder="은행이름?">
		잔액 : <input type="text" name="balance" placeholder="잔액?">
		<button>입력</button>
	</form>
</body>
</html>