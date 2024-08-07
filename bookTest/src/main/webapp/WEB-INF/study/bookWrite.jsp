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
	<h2> 도서정보 입력 페이지 </h2><br><br>
	<form method="get" action="/detail">
		<div class="bookWrite">
			<label>책 제목</label>
			<input type="text" name="bookTitle" placeholder="책 제목 입력칸">
		</div>
		<div class="bookWrite">
			<label>저자</label>
			<input type="text" name="bookWriter" placeholder="저자 입력칸">
		</div>
		<div class="bookWrite">
			<label>출판사</label>
			<input type="text" name="bookPublisher" placeholder="출판사 입력칸">
		</div>
		<button id="bookWriteBt">도서 정보 입력</button>
	</form>
</body>
</html>