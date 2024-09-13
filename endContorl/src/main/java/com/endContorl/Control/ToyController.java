package com.endContorl.Control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.endContorl.DTO.ToyDTO;
import com.endContorl.DTO.ToysDTO;
import com.endContorl.Service.ToyService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ToyController {
	private final ToyService toyService;
	@GetMapping("/toy")
	public String toy() {
		return "toy";
	}
	@PostMapping("/toy")
	public String toy(@ModelAttribute ToyDTO toyDTO, Model model) {
		ToysDTO toysDTO=toyService.toySearch(toyDTO);
		model.addAttribute("toysDTO",toysDTO);
		return "toys";
	}
}
