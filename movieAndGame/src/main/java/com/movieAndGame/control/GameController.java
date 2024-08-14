package com.movieAndGame.control;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movieAndGame.DTO.GameMemberDTO;
import com.movieAndGame.service.GameMemberService;

@Controller
@RequestMapping("/game")
public class GameController {
	@Autowired
	private GameMemberService gameMemberService;
	@GetMapping("/index")
	public String gameHome(Model model) {
		return "game/index";
	}
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("gameMemberDTO", new GameMemberDTO());
		return "game/member/login";
	}
	@GetMapping("/signUp")
	public String signUp(Model model) {
		model.addAttribute("gameMemberDTO", new GameMemberDTO());
		return "game/member/signUp";
	}
	@PostMapping("/signUp")
	public String signUp(@Valid GameMemberDTO gameMemberDTO, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "game/member/signUp";
		}
		gameMemberService.signUpSave(gameMemberDTO);
		return "redirect:/game/index";
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