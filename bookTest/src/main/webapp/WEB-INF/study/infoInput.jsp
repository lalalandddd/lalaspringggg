<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2> html, css, js로 구성되어있는 페이지만 제공한다면 ModelAndView를 사용하지 않아도 된다. </h2>
	<p> 아무리 form에 입력하고 버튼 클릭해서 form 데이터를 받는 Mapping을 만들었어도 </p>
	<h3> 그 다음 보여줄 페이지에 데이터를 제공하지 않을꺼라면 그냥 페이지만 넘겨주면 된다. </h3>
	<p> ModelAndView는 사용자에게 제공할 페이지와 데이터를 저장할 수 있는 클래스이다. </p>
	<p> 사용자에게 제공할 페이지는 객체 생성 시 입력하거나 setViewName 메서드로 입력하면 된다. </p>
	<p> 이름 : </p>
	<p> 생년월일 : </p>
	<p> 나이 : ${dataa.age } </p>
	<a href="/home">돌아가기</a>
</body>
</html>