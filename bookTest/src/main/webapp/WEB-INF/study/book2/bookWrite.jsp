<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 정보 작성</title>
<link rel="stylesheet" href="/css/write.css">
</head>
<body>
	<h2> 도서 정보 작성 페이지 </h2>
	<div id="wrap">
		<a href="/index">HOME</a><br>
		<h3 id="enrollCount">${count }권 등록 완료</h3><br>
		<form method="post" action="/enroll">
			<div id="formWrap">
				<div class="inputField">
					<label for="bookTitle">도서명</label>
					<input type="text" name="bookTitle" id="bookTitle" placeholder="도서명 입력">
				</div>
				<div class="inputField">
					<label for="bookWriter">저자</label>
					<input type="text" name="bookWriter" id="bookWriter" placeholder="저자 입력">
				</div>
				<div class="inputField">
					<label for="bookPrice">가격</label>
					<input type="number" name="bookPrice" id="bookPrice" placeholder="가격 입력">
				</div>
				<div class="inputField">
					<label for="bookAllpage">페이지수</label>
					<input type="number" name="bookAllpage" id="bookAllpage" placeholder="페이지수 입력">
				</div>
				<div class="inputField">
					<label for="bookPublisher">출판사</label>
					<input type="text" name="bookPublisher" id="bookPublisher" placeholder="출판사 입력">
				</div>
				<button id="bt">등록</button>
			</div>
		</form>
	</div>
</body>
</html>