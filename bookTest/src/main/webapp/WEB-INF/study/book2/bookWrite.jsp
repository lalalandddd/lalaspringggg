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
	<h3 id="enrollCount">${count }권 등록 완료</h3><br>
	<a href="/index">HOME</a><br><br>
	<h2> 도서 정보 작성 페이지 </h2>
	<div id="wrap">
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
				<div class="inputField">
					<label for="bookVolume">권수</label>
					<input type="number" name="bookVolume" id="bookVolume" placeholder="권수 입력">
				</div>
				<div class="inputField">
					<label for="bookSubtitle">부제</label>
					<input type="text" name="bookSubtitle" id="bookSubtitle" placeholder="부제 입력">
				</div>
				<div class="inputField">
					<label for="bookCode">도서코드</label>
					<input type="text" name="bookCode" id="bookCode" placeholder="도서코드 입력">
				</div>
				<div class="inputField">
					<label for="bookSort">도서분류</label>
					<input type="text" name="bookSort" id="bookSort" placeholder="도서분류 입력">
				</div>
				<div class="inputField">
					<label for="bookContent">목차</label>
					<textarea name="bookContent" id="bookContent" placeholder="목차 입력" rows="20" cols="60"></textarea>
				</div>
				<button id="bt">등록</button>
			</div>
		</form>
	</div>
</body>
</html>