package com.my.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {
	@GetMapping("/")
	public String home() {
		return "index";
	}
	@GetMapping("/gallery")
	public String gallery() {
		return "gallery/index";
	}
	@GetMapping("/game")
	public String game() {
		return "game/index";
	}
	@GetMapping("/game/write")
	public String gameWrite() {
		return "game/write";
	}
	@GetMapping("/gallery/write")
	public String galleryWrite() {
		return "gallery/write";
	}
	@GetMapping("/gallery/view")
	public String galleryView() {
		return "gallery/view";
	}
}
