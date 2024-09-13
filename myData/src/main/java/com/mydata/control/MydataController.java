package com.mydata.control;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MydataController {
	@GetMapping("/")
	public String mainpage() {
		return "mainPage";
	}
	@GetMapping("/info")
	public String info() {
		return "info";
	}
	@GetMapping("/infosave")
	public String infosave() {
		return "mainPage";
	}
	@GetMapping("/favorite")
	public String favorite() {
		return "myFavorite";
	}
	@PostMapping("/send")
	public String send(@RequestParam("name") String name, @RequestParam("age") int age, @RequestParam("birth") String birth, Model model) {
		model.addAttribute("name",name);
		model.addAttribute("age",age);
		model.addAttribute("birth",birth);
		return "result";
	}

}
