<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서정보 보기</title>
<!-- jquery CDN -->
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<link rel="stylesheet" href="/css/info.css">
<script src="/js/info.js"></script>
<script>
	inputType=["text","text","text","number","text","number","text","text","number","text"];
	inputName=["bookCode","bookSort","bookTitle","bookVolume","bookSubtitle","bookAllpage","bookWriter","bookPublisher","bookPrice","bookContent"];
</script>
</head>
<body>
	<form id="fm" method="get" action="/book2/delete">
	<input type="hidden" name="id" value="${book.bookId }">
		<div id="wrap">
			<a href="/"> HOME </a><br>
			<a href="/index"> 도서관리 페이지 </a><br><br>
			<h2> 도서 정보 보기 페이지 </h2>
			<table id="viewBox">
				<tr>
					<td class="fieldName">코드번호</td>
					<td class="value">${book.getBookCode() }</td>
				</tr>
				<tr>
					<td class="fieldName">분류</td>
					<td class="value">${book.bookSort }</td>
				</tr>
				<tr>
					<td class="fieldName">책 제목</td>
					<td class="value">${book.bookTitle }</td>
				</tr>
				<tr>
					<td class="fieldName">권수</td>
					<td class="value">${book.bookVolume }</td>
				</tr>
				<tr>
					<td class="fieldName">부제목</td>
					<td class="value">${book.bookSubtitle }</td>
				</tr>
				<tr>
					<td class="fieldName">페이지</td>
					<td class="value">
		 				<fmt:formatNumber value="${book.bookAllpage }" pattern="#,###"/>
					</td>
				</tr>
				<tr>
					<td class="fieldName">저자</td>
					<td class="value">${book.bookWriter }</td>
				</tr>
				<tr>
					<td class="fieldName">출판사</td>
					<td class="value">${book.bookPublisher }</td>
				</tr>
				<tr>
					<td class="fieldName">가격</td>
					<td class="value">
						<fmt:formatNumber value="${book.bookPrice }" type="currency"/>
					</td>
				</tr>
				<tr>
					<td class="fieldName">목차</td>
					<td class="value">${book.bookContent }</td>
				</tr>
				<tr>
					<td colspan="2">
						<button type="button" id="modify">수정</button>
						<button type="button" id="delete" data-id="${book.bookId }">삭제</button>
					</td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>