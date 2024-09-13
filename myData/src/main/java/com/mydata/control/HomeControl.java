package com.mydata.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mydata.DTO.Product;

@Controller
public class HomeControl {
//	@GetMapping("/")
//	public String home() {
//		return "main";
//	}
//	@GetMapping("/input")
//	public String input() {
//		return "product";
//	}
//	@PostMapping("/execute")
//	public String ok(@ModelAttribute Product product, Model model) {
//		model.addAttribute("Product",product);
//		return "ok";
//	}
}
