package com.endContorl.Control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.endContorl.DTO.Friend;

@Controller
public class HomeController {
	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("myName","내이름");
		return "home";
	}
	@GetMapping("/myFriend")
	public String friend() {
		return "friendWrite";
	}
	@PostMapping("/friendInput")
	public String input(@ModelAttribute Friend friend, Model model) {
		model.addAttribute("friend",friend);
		return "myFriendInfo";
	}
}
