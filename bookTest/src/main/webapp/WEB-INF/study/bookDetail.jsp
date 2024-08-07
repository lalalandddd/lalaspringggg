<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/"> project home </a><br>
	<h2> 도서정보 출력 페이지 </h2>
	<p> 도서명 : ${book.bookTitle } </p>
	<p> 저자 : ${book.bookWriter } </p>
	<p> 출판사 : ${book.bookPublisher } </p>
	<a href="/write"> 추가 입력? </a><br>
</body>
</html>