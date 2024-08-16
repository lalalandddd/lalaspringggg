package com.movieAndGame.control;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movieAndGame.DTO.MovieMemberDTO;
import com.movieAndGame.service.MovieMemberService;

@Controller
@RequestMapping("/movie")
public class MovieController {
	@Autowired
	private MovieMemberService movieMemberService;
	@GetMapping("/index")
	public String movieHome(Model model) {
		return "movie/index";
	}
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("movieMemberDTO",new MovieMemberDTO());
		return "movie/member/login";
	}
	// 로그인 처리 요청
	@PostMapping("/login")
	public String login(MovieMemberDTO member, HttpSession session, Model model) {  // member 객체를 받도록 html에서 설정했기에 movieMemberDTO가 아니다.
// 로그인 처리 - 데이터베이스에 아이디와 비번이 일치하는지 확인하고 일치하면 세션 만들고 첫페이지(index)로 이동
// 일치하지 않으면 현재 페이지(login)로 돌려보내야 한다.
		MovieMemberDTO user=movieMemberService.login(member);
		if(user==null) {  // 로그인 실패(아이디 또는 비번 잘못 입력)
			model.addAttribute("member",member);  // member에 저장된 잘못 입력된 값을 되돌려보내기
			model.addAttribute("fail","a");
			return "movie/member/login";
		}
		session.setAttribute("user",user);
		return "redirect:/movie/index";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		return "redirect:/movie/index";
	}
	@GetMapping("/signUp")
	public String signUp(Model model) {
		model.addAttribute("movieMemberDTO",new MovieMemberDTO());
		return "movie/member/signUp";
	}
	@PostMapping("/signUp")  // 유효성 검사, 검사결과는 Valid 뒤에 BindingResult로 받는다.
	public String signUp(@Valid MovieMemberDTO movieMemberDTO, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			System.out.println("유효하지 않은 값이 입력됐다!!");
			return "movie/member/signUp";  // 에러가 있다면 입력 페이지로 돌아간다.
		}
		boolean isDup=movieMemberService.signUpSave(movieMemberDTO);
		if(isDup) {
			bindingResult.rejectValue("memberId","error.memberId","중복 아이디입니다.");
			return "movie/member/signUp";
		}
		movieMemberService.signUpSave(movieMemberDTO);
		return "redirect:/movie/index";
	}
	@GetMapping("/playing")
	public String playing() {
		return "movie/playing";
	}
	@GetMapping("/schedule")
	public String schedule() {
		return "movie/schedule";
	}
	@GetMapping("/preview")
	public String preview() {
		return "movie/preview";
	}
	@GetMapping("/review")
	public String review() {
		return "movie/review";
	}
}
