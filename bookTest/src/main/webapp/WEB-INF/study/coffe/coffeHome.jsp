<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/default.css">
</head>
<body>
	<a href="/"> === 프로젝트 시작화면 === </a><br>
	${list.get(0).itemName } 잘 나오는지 확인 용... 나중에 지우자?
	<div id="wrap">
		<h2> 커피 관리 메뉴 </h2>
		<div id="mainTitle">
			<h3>등록 커피 목록</h3>
			<a href="/coffeReg">커피등록</a>
		</div>
		<div id="bookListWrap">
			<ul id="bookList">
				<li class="blist">
					<span class="bookTitle">커미이름</span>
					<span class="bookCode">가격</span>
					<span class="bookSort">0:카페인/1:디카페인</span>
				</li>
				<c:forEach var="row" items="${list }">
					<li class="blist">
						<span class="bookTitle">
							<a href="/coffe/coffeeView?id=${row.coffeId}">${row.itemName }</a>
						</span>
						<span class="bookCode">
							<a href="/coffe/coffeeView?id=${row.coffeId}">${row.price }</a>
						</span>
						<span class="bookSort">
							<a href="/coffe/coffeeView?id=${row.coffeId}">${row.decaffein }</a>
						</span>
					</li>
				</c:forEach>
			</ul>
		</div>
	</div>
</body>
</html>