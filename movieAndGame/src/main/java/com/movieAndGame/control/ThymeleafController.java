package com.movieAndGame.control;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.movieAndGame.DTO.TestMemberDTO;

@Controller
public class ThymeleafController {
	@GetMapping("/")
	public String projectHome() {
		return "projectHome";
	}
	@GetMapping("/game")
	public String gameIndex() {
		return "game/index";
	}
	@GetMapping("/movie")
	public String movieIndex() {
		return "movie/index";
	}
	@GetMapping("/homework")
	public String homework() {
		return "homework";
	}
	@GetMapping("/test")
//	public ModelAndView testHome() {
//		String name="영화광";
//		return new ModelAndView("test").addObject("name",name);
//	}
	public String testHome(Model model) {
		TestMemberDTO mem=new TestMemberDTO();
		mem.setAge(25);
		mem.setEmail("asdf@asdf.com");
		mem.setName("영화광");
		mem.setTel("010-1234-9876");
		String name="영화광";
		List<String> animal=new ArrayList<>();
		animal.add("사자"); animal.add("호랑이"); animal.add("고양이"); animal.add("개"); animal.add("여우");
		animal.add("늑대"); animal.add("코끼리"); animal.add("얼룩말"); animal.add("기린"); animal.add("하마");
		animal.add("악어"); animal.add("코뿔소"); animal.add("물소"); animal.add("토끼"); animal.add("미어캣");
		model.addAttribute("name",name);
		model.addAttribute("member",mem);
		model.addAttribute("animal",animal);
		model.addAttribute("tag","<h2>타임리프</h2>");
		return "test";
	}
}
