package com.example.bookTest.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MytestController {
	@GetMapping("/library")
	public String library() {
		return "mytest/library";
	}
}
