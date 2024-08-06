<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2> 글쓰기 페이지(예정) 입니다! </h2>
	<form method="post" action="/boardWrite">
		제목 : <input type="text" name="title"><br>
		작성자 : <input type="text" name="writer"><br>
		내용 : <textarea name="content"></textarea><br>
		비밀번호 : <input type="password" name="boardPw"><br>
		<button>작성</button>
	</form>
	<a href="/board">게시판으로</a>
<!--
동작 내용
 - 글쓰기를 클릭하여 게시글 작성 페이지로 이동하고, 작성 버튼을 클릭하여 게시글 보기 페이지로 이동하여 작성한 내용을 출력한다.
 - 각 페이지 이동하기 위한 Mapping과 뷰 페이지에 데이터 출력 방법들을 작성하여 정상적으로 동작하도록 하세요.
-->
</body>
</html>