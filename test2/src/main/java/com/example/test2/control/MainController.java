package com.example.test2.control;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.test2.DTO.MemberDTO;
import com.example.test2.DTO.TestDTO;

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
		return "/member/signUp";
	}
// 주소 요청 : /signUp   뷰 페이지 : /member/signUp.jsp    뷰 페이지 내용 : 아이디, 비밀번호, 이메일, 연락처, 생년월일 입력

// form 데이터 받아오는 방법 1 (복잡함)
//	@PostMapping("/signUp")
//	public String signupSave(@RequestParam("userId") String id,@RequestParam("userPw") String pw,@RequestParam("userEmail") String email,@RequestParam("userTel") String tel,@RequestParam("userBirth") String birth) {
//		//String id=request.getParameter("userId");  // 기존 방법
//		System.out.println(id+","+pw+","+email+","+tel+","+birth);
//		return "member/signupSave";
//	}

// form 데이터 받아오는 방법 2 (깔끔하지만 반드시 규칙을 지켜야 함, 데이터베이스 저장까지 생각하면 가장 좋다.)
	@PostMapping("/signUp")
	public String signupSave(@ModelAttribute MemberDTO memberDTO) {
		System.out.println(memberDTO.getUserId());
		System.out.println(memberDTO);
		return "/member/signupSave";
	}

// form 데이터 받아오는 방법 3 (범용성 최고. 단, 데이터베이스 저장할 때 힘들다.)
//	@PostMapping("/signUp")
//	public String signupSave(@RequestParam Map<String, String> pm) {
//		System.out.println(pm.get("userId"));
//		System.out.println(pm);
//		return "/member/signupSave";
//	}

// form 데이터 받아오기 실습
	@GetMapping("/mytestHome")
	public String home() {
		return "/mytestHome";
	}
	@GetMapping("homework")
	public String homework() {
		return "/homework";
	}
	@GetMapping("/login")
	public String login() {
		return "/mytest/login";
	}
	@GetMapping("/search")
	public String search() {
		return "/mytest/search";
	}
	@GetMapping("/")
	public String index() {
		return "/member/index";
	}
	@PostMapping("/login")
	public String loginResult(@ModelAttribute TestDTO testDTO) {
		System.out.println(testDTO);
		if(testDTO.getUserId().equals("asdf")&&testDTO.getUserPw().equals("1234")) {
			System.out.println("로그인 성공!");
		}else { System.out.println("로그인 실패!"); }
		return "/mytest/loginResult";
	}
// 페이지를 제공하면서 데이터도 같이 보내고 싶다?
	@GetMapping("/modelAndView")
	public ModelAndView home2() {
		String title="오늘도 공부는 잘 하셨습니까?";
		ModelAndView mv=new ModelAndView("/mytestHome");  // ModelAndView 객체 생성하면서 뷰 페이지 입력
		mv.addObject("pageTitle",title);
		return mv;
	}
}  // 여기에 위에서 배운 form에서 데이터 받아오는 방법2와 연계해서 진행해야 한다.
/*
자바빈
  1. 클래스의 인스턴스 변수는 input의 name과 일치시켜준다.
  2. 클래스의 기본생성자 메서드가 필요하다.
  3. 인스턴스변수의 getter, setter 메서드가 필요하다.
  4. 인스턴스변수의 제어자는 private(제어자 없어도 되지만, 보안 문제가...)
*/
/*
form 데이터 받아오기 실습
  - 로그인을 위해 로그인 페이지에서 아이디와 비밀번호를 입력하고 로그인 버튼을 클릭한다.
  - DTO class : LoginDTO
  - 뷰 페이지
    > login.jsp (로그인 form 페이지)
    > loginResult.jsp(로그인 후 보여줄 페이지)
  - loginResult.jsp에 <a href="/test"> 페이지 이동</a> 넣기
*/