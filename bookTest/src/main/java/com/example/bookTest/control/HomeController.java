package com.example.bookTest.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/")
	public String projectHome() {
		return "projectHome";
	}
	@GetMapping("/mytest")
	public String mytest() {
		return "mytest/main";
	}
}
