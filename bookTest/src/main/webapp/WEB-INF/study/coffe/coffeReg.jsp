<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/coffe">HOME</a><br>
	<h2> 커피 등록 페이지 </h2>
	<form method="post" action="/coffeUp">
		<div class="inputField">
			<label for="itemName">커피 이름</label>
			<input type="text" name="itemName" id="itemName" placeholder="커피 이름 입력">
		</div>
		<div class="inputField">
			<label for="price">커피 가격</label>
			<input type="number" name="price" id="price" min="3000" placeholder="커피 가격 입력">
		</div>
		<div class="inputField">
			<label for="decaffein">디카페인?</label>
			<div class="radioField">
				<input type="radio" name="decaffein" value="0" checked>카페인
				<input type="radio" name="decaffein" value="1">디카페인
			</div>
		</div>
		<button>커피 등록</button>
	</form>
</body>
</html>