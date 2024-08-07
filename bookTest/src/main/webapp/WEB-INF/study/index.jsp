<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 도서관리 </title>
<link rel="stylesheet" href="/css/default.css">
</head>
<body>
	<div id="wrap">
		<h2> 도서 관리 페이지 </h2>
		<div id="mainTitle">
			<h3>등록 도서 목록</h3>
			<a href="/bookWrite" id="enroll">도서 등록</a>
		</div>
		<div id="bookListWrap">
			<ul id="bookList">
				<li class="blist">
					<span class="bookTitle">자바의 기초</span>
					<span class="bookWriter">홍길동</span>
					<span class="bookCode">ㅈ03홍2394</span>
					<span class="bookSort">컴퓨터 프로그램언어</span>
				</li>
				<li class="blist">
					<span class="bookTitle">스프링 프레임워크의 기초</span>
					<span class="bookWriter">홍길동</span>
					<span class="bookCode">ㅅ09홍2399</span>
					<span class="bookSort">컴퓨터 프로그램언어</span>
				</li>
				<li class="blist">
					<span class="bookTitle">안드로이드sdk</span>
					<span class="bookWriter">김유신</span>
					<span class="bookCode">ㅇ21김1154</span>
					<span class="bookSort">컴퓨터 운영체제</span>
				</li>
				<li class="blist">
					<span class="bookTitle">C언어 도장꺠기</span>
					<span class="bookWriter">최배달</span>
					<span class="bookCode">C27최0187</span>
					<span class="bookSort">컴퓨터 프로그램언어</span>
				</li>
				<li class="blist">
					<span class="bookTitle">GAMERS</span>
					<span class="bookWriter">게이머즈</span>
					<span class="bookCode">G77게6458</span>
					<span class="bookSort">컴퓨터 게임</span>
				</li>
			</ul>
		</div>
	</div>
</body>
</html>