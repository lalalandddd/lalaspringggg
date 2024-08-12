package com.movieAndGame.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/movie")
public class MovieController {
	@GetMapping("/index")
	public String movieHome() {
		return "movie/index";
	}
	@GetMapping("/login")
	public String login() {
		return "movie/member/login";
	}
	@GetMapping("/signUp")
	public String signUp() {
		return "movie/member/signUp";
	}
	@GetMapping("/review")
	public String review() {
		return "movie/review";
	}
}
