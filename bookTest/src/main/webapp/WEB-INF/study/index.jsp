<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 도서관리 </title>
<link rel="stylesheet" href="/css/default.css">
</head>
<body>
	<a href="/"> === 프로젝트 시작화면 === </a><br>
	${list.get(0).bookTitle }
	<div id="wrap">
		<h2> 도서 관리 페이지 </h2>
		<div id="mainTitle">
			<h3>등록 도서 목록</h3>
			<a href="/bookWrite" id="enroll">도서 등록</a>
		</div>
		<div id="bookListWrap">
			<ul id="bookList">
				<li class="blist">
					<span class="bookTitle">책 제목</span>
					<span class="bookSubtitle">부제</span>
					<span class="bookWriter">저자</span>
					<span class="bookCode">코드번호</span>
					<span class="bookSort">분류</span>
				</li>
				<c:forEach var="row" items="${list }">
					<li class="blist">
						<span class="bookTitle">
							<a href="/book2/bookView?id=${row.bookId}">${row.bookTitle }</a>
						</span>
						<span class="bookSubtitle">
							<a href="/book2/bookView?id=${row.bookId}">${row.bookSubtitle }</a>
						</span>
						<span class="bookWriter">
							<a href="/book2/bookView?id=${row.bookId}">${row.bookWriter }</a>
						</span>
						<span class="bookCode">
							<a href="/book2/bookView?id=${row.bookId}">${row.bookCode }</a>
						</span>
						<span class="bookSort">
							<a href="/book2/bookView?id=${row.bookId}">${row.bookSort }</a>
						</span>
					</li>
				</c:forEach>
			</ul>
		</div>
	</div>
</body>
</html>