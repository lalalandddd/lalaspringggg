package com.midProject.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	@GetMapping("/")
	public String testhome() {
		return "aaa/test";
	}
	@GetMapping("/homework")
	public String homework() {
		return "aaa/homework";
	}
	@GetMapping("/projectPreview")
	public String preview() {
		return "aaa/projectPreview";
	}
}
