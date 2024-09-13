package com.lastWeb.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.lastWeb.DTO.ChatDTO;
import com.lastWeb.Service.ChatService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MainController {
	private final ChatService chatService;
	@GetMapping("/")
	public String main() {
		return "index";
	}
	@PostMapping("/save")
	public String save(@ModelAttribute ChatDTO dto, Model model) {
//		System.out.println(dto.getUserName());
		chatService.save(dto);
		List<ChatDTO> dtos=chatService.getDtos();
		model.addAttribute("dtos",dtos);
		return "list";
	}
}
