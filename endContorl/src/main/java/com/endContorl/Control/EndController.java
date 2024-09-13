package com.endContorl.Control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.endContorl.DTO.MyLunch;

@Controller
public class EndController {
	@GetMapping("/")
	public String home() {
		return "index";
	}
	@GetMapping("/lunch")
	public String lunch() {
		return "lunch";
	}
	@GetMapping("/lunchInput")
	public String lunchInput(@ModelAttribute MyLunch myLunch, Model model) {
		model.addAttribute("myLunch",myLunch);
		return "exit";
	}
}
