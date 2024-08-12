package com.example.bookTest.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.bookTest.DTO.CoffeDto;
import com.example.bookTest.service.CoffeService;

@Controller
public class CoffeController {
	@Autowired
	private CoffeService coffeService;
	@GetMapping("/coffe")
	public ModelAndView coffeHome() {
		ModelAndView mav=new ModelAndView("coffe/coffeHome");
		List<CoffeDto> list=coffeService.coffeeAll();
		mav.addObject("list",list);
		return mav;
	}
	@GetMapping("/coffeReg")
	public String coffeReg() {
		return "coffe/coffeReg";
	}
	@PostMapping("/coffeUp")
	public String coffeReg(@ModelAttribute CoffeDto coffeDto) {
		coffeService.coffeReg(coffeDto);
		return "redirect:/index";
	}
	@GetMapping("/coffe/coffeeView")
	public ModelAndView view(@RequestParam(value="id", required=false, defaultValue="0") int id) {
		CoffeDto coffee=coffeService.getCoffee(id);
		if(coffee==null) coffee=new CoffeDto();
		return new ModelAndView("coffe/coffeeView").addObject("coffee",coffee);
	}
	@GetMapping("/coffe/coffeeDelete")
	public String coffeDelete(@RequestParam("id") int id) {
		coffeService.coffeDelete(id);
		return "redirect:/coffe";
	}
	@GetMapping("/coffe/update")
	public String coffeUpdate(@ModelAttribute CoffeDto coffeDto, @RequestParam("id") int id) {
		coffeDto.setCoffeId(id);
		coffeService.coffeUpdate(coffeDto);
		return "redirect:/coffe/coffeeView?id="+id;
	}
}
