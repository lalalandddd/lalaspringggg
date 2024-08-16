package com.movieAndGame.control;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movieAndGame.DTO.GameMemberDTO;
import com.movieAndGame.DTO.GameReviewDTO;
import com.movieAndGame.service.GameReviewService;

@Controller
@RequestMapping("/gameReview")
public class GameMenuController {
	@Autowired
	private GameReviewService gameReviewService;
	@GetMapping("/review")
	public String reviewMain(Model model) {
		return "game/review/index";
	}
	@GetMapping("/reviewWrite")
	public String reviewWrite(Model model, HttpSession session) {
		if(session.getAttribute("user")==null) {
			return "redirect:/game/member/login";
		}
		GameReviewDTO dto=new GameReviewDTO();
		String name=((GameMemberDTO)session.getAttribute("user")).getMemberId();
		dto.setWriter(name);
		model.addAttribute("gameReviewDTO",dto);
		return "game/review/reviewWrite";
	}
	@GetMapping("/write")
	public String gameReviewWrite(@Valid GameReviewDTO gameReviewDTO, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "game/review/reviewWrite";
		}
		gameReviewService.reviewSave(gameReviewDTO);
		return "redirect:/game/review/index";
	}
}
