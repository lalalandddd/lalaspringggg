package com.movieAndGame.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movieAndGame.DTO.MovieMemberDTO;

@Controller
@RequestMapping("/game")
public class GameController {
	@GetMapping("/index")
	public String gameHome() {
		return "game/index";
	}
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("member", new MovieMemberDTO());
		return "game/member/login";
	}
	@GetMapping("/signUp")
	public String signUp() {
		return "game/member/signUp";
	}
	@GetMapping("/review")
	public String review() {
		return "game/review";
	}
}
