<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 보기</title>
<!-- jquery CDN -->
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<link rel="stylesheet" href="/css/info.css">
<script src="/js/info.js"></script>
</head>
<body>
	<div id="wrap">
		<a href="/managerMain"> 관리자 화면 </a><br>
		<a href="/memberList"> 회원 목록 화면 </a><br>
		<h2> 유저 정보 확인 및 수정 페이지 입니다 </h2>
	</div>
	<table id="viewBox">
		<tr>
			<td class="fieldName">회원 ID</td>
			<td class="value">${member.userId }</td>
		</tr>
		<tr>
			<td class="fieldName">비밀번호</td>
			<td class="value">${member.userPw }</td>
		</tr>
		<tr>
			<td class="fieldName">이름</td>
			<td class="value">${member.userName }</td>
		</tr>
		<tr>
			<td class="fieldName">이메일</td>
			<td class="value">${member.userEmail }</td>
		</tr>
		<tr>
			<td class="fieldName">전화번호</td>
			<td class="value">${member.userTel }</td>
		</tr>
		<tr>
			<td class="fieldName">주소</td>
			<td class="value">${member.userAddress }</td>
		</tr>
		<tr>
			<td class="fieldName">생일</td>
			<td class="value">${member.userBirth }</td>
		</tr>
		<tr>
			<td colspan="2">
				<button type="button" id="modify">회원정보 수정</button>
				<button type="button" id="delete">회원 삭제</button>
			</td>
		</tr>
	</table>
</body>
</html>