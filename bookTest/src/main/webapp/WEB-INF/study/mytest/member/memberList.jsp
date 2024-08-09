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
	<a href="/managerMain"> 관리자 화면 </a><br>
	<h3> 회원 목록 </h3>
	<div id="memberListWrap">
		<ul id="memberList">
			<li class="mlist">
				<span class="bookTitle">유저 ID</span>
				<span class="bookWriter">유저 이름</span>
				<span class="bookSubtitle">이메일</span>
				<span class="bookCode">전화번호</span>
				<span class="bookSort">생일</span>
			</li>
			<c:forEach var="mem" items="${list }">
				<li class="mlist">
					<span class="bookTitle">
						<a href="/mytest/member/userView?id=${mem.userIdnb }">${mem.userId }</a>
					</span>
					<span class="bookWriter">
						<a href="/mytest/member/userView?id=${mem.userIdnb }">${mem.userName }</a>
					</span>
					<span class="bookSubtitle">
						<a href="/mytest/member/userView?id=${mem.userIdnb }">${mem.userEmail }</a>
					</span>
					<span class="bookCode">
						<a href="/mytest/member/userView?id=${mem.userIdnb }">${mem.userTel }</a>
					</span>
					<span class="bookSort">
						<a href="/mytest/member/userView?id=${mem.userIdnb }">${mem.userBirth }</a>
					</span>
				</li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>