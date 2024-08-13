package com.movieAndGame.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movieAndGame.DTO.MovieMemberDTO;

@Controller
@RequestMapping("/movie")
public class MovieController {
	@GetMapping("/index")
	public String movieHome(Model model) {
		return "movie/index";
	}
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("movieMember",new MovieMemberDTO());
		return "movie/member/login";
	}
	@GetMapping("/signUp")
	public String signUp(Model model) {
		model.addAttribute("movieMember",new MovieMemberDTO());
		return "movie/member/signUp";
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
