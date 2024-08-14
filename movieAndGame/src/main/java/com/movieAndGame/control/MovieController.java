package com.movieAndGame.control;

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
