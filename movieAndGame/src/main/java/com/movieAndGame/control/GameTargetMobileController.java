package com.movieAndGame.control;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movieAndGame.DTO.GameMemberDTO;
import com.movieAndGame.DTO.GameTargetMobileDTO;
import com.movieAndGame.service.GameTargetMobileService;

@Controller
@RequestMapping("/mobileTarget")
public class GameTargetMobileController {
	@Autowired
	private GameTargetMobileService gameTargetMobileService;
	@GetMapping("/mtarget")
	public String mtarget(Model model) {
		List<GameTargetMobileDTO> list=gameTargetMobileService.targetList();
		model.addAttribute("targetList",list);
		return "game/target/index";
	}
	@GetMapping("/mtargetWrite")
	public String targetWrite(Model model, HttpSession session) {
		if(session.getAttribute("user")==null) {
			return "redirect:/game/login";
		}
		GameTargetMobileDTO dto=new GameTargetMobileDTO();
		String name=((GameMemberDTO)session.getAttribute("user")).getName();
		dto.setWriter(name);
		model.addAttribute("gameTargetMobileDTO",dto);
		return "game/target/targetWrite";
	}
	@GetMapping("/write")
	public String gameTargetMobileWrite(@Valid GameTargetMobileDTO gameTargetMobileDTO, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "game/target/targetWrite";
		}
		gameTargetMobileService.postSave(gameTargetMobileDTO);
		return "redirect:/mobileTarget/mtarget";
	}
	@GetMapping("/view/{id}")
	public String view(@PathVariable("id") int id, Model model) {
		GameTargetMobileDTO dto=gameTargetMobileService.findById(id);
		model.addAttribute("gameTargetMobileDTO",dto);
		return "game/target/detail";
	}
}
