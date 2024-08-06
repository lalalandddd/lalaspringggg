<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/board">게시판으로</a>
	<a href="/boardWrite">글쓰기</a>
	<h2>글 제목 : ${data.title } </h2>
	<p>작성자 : ${data.writer }</p>
	<p>글 내용 : ${data.content }</p>
	<p>비밀번호? : ${data.boardPw }</p>
<!--
동작 내용
 - 글쓰기를 클릭하여 게시글 작성 페이지로 이동하고, 작성 버튼을 클릭하여 게시글 보기 페이지로 이동하여 작성한 내용을 출력한다.
 - 각 페이지 이동하기 위한 Mapping과 뷰 페이지에 데이터 출력 방법들을 작성하여 정상적으로 동작하도록 하세요.
-->
</body>
</html>