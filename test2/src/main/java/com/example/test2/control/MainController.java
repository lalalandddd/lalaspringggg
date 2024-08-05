package com.example.test2.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MainController {
/*
JSP MVC 패턴 주소 맵핑
 - 주소 패턴과 서블렛 클래스 연결(web.xml)
 - 주소 패턴(*.do 등등)이 다양하면 서블렛 클래스 갯수도 늘어난다. 여러 개의 주소를 하나로 연결하고 싶다면 그것도 따로 만들어야 한다.
 - 주소 요청을 처리할 메서드 지정을 위해 Map, properties 같은 주소와 메서드를 1:1 지정하여 처리하기 위한 객체 또는 파일이 필요하다.
 - 어떤 주소 요청인지 파악하기 위한 코드와 실행 코드를 작성해야 한다.
*/
/*
스프링에서의 주소 맵핑(요청 주소와 처리 내용을 연결하는 작업)
 - @Controller 클래스에 지정하고 요청 방식에 따라 주소 맵핑(@GetMapping("/"))
 - 요청 주소를 처리할 메서드 정의와 반환값으로 보여줄 페이지 이름 설정
 - 위의 과정을 맵핑이 필요한 만큼 반복... 즉 클래스는 하나면 끝.
*/
	@GetMapping("/test")  // test 주소 요청이 들어오면
	public String testFirst() {
		return "test";  // test.jsp 열기 (확장자 빼고 쓰자)
	}
	@GetMapping("/aaa.abc")
	public String testSecond() {
		return "login";
	}
	@GetMapping("signUp")
	public String signUp() {
		return "member/signUp";
	}
	@PostMapping("signUp")
//	@GetMapping("signupSave")
	public String signupSave(@RequestParam("userId") String id,@RequestParam("userPw") String pw,@RequestParam("userEmail") String email,@RequestParam("userTel") String tel,@RequestParam("userBirth") String birth) {
		//String id=request.getParameter("userId");  // 기존 방법
		System.out.println(id+","+pw+","+email+","+tel+","+birth);
		return "member/signupSave";
	}
// 주소 요청 : /signUp   뷰 페이지 : /member/signUp.jsp    뷰 페이지 내용 : 아이디, 비밀번호, 연락처, 생년월일 입력
}
