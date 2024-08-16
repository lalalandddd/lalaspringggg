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
import com.movieAndGame.DTO.GameTargetMobileDTO;
import com.movieAndGame.service.GameTargetMobileService;

@Controller
@RequestMapping("/gameTargetMobile")
public class GameTargetMobileController {
	@Autowired
	private GameTargetMobileService gameTargetMobileService;
	@GetMapping("/review")
	public String reviewMobile(Model model) {
		return "game/target/index";
	}
	@GetMapping("/targetWrite")
	public String targetWrite(Model model, HttpSession session) {
		if(session.getAttribute("user")==null) {
			return "redirect:/game/member.login";
		}
		GameTargetMobileDTO dto=new GameTargetMobileDTO();
		String name=((GameMemberDTO)session.getAttribute("user")).getMemberId();
		dto.setWriter(name);
		model.addAttribute("gameTargetMobileDTO",dto);
		return "game/target/targetWrite";
	}
	@GetMapping("/write")
	public String gameTargetWrite(@Valid GameTargetMobileDTO gameTargetMobileDTO, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "game/target/targetWrite";
		}
		gameTargetMobileService.targetSave(gameTargetMobileDTO);
		return "redirect:/game/target/index";
	}
}
