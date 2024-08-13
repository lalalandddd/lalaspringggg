package com.movieAndGame.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movieAndGame.DTO.GameMemberDTO;

@Controller
@RequestMapping("/game")
public class GameController {
	@GetMapping("/index")
	public String gameHome(Model model) {
		return "game/index";
	}
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("gameMember", new GameMemberDTO());
		return "game/member/login";
	}
	@GetMapping("/signUp")
	public String signUp(Model model) {
		model.addAttribute("gameMember", new GameMemberDTO());
		return "game/member/signUp";
	}
	@GetMapping("/pcgame")
	public String pcgame() {
		return "game/pcgame";
	}
	@GetMapping("/mobile")
	public String mobile() {
		return "game/mobile";
	}
	@GetMapping("/console")
	public String console() {
		return "game/console";
	}
	@GetMapping("/makebyme")
	public String makebyme() {
		return "game/makebyme";
	}
	@GetMapping("/disgame")
	public String disgame() {
		return "game/disgame";
	}
	@GetMapping("/review")
	public String review() {
		return "game/review";
	}
}
