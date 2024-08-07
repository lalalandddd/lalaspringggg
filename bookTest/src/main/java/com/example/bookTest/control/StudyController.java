package com.example.bookTest.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.bookTest.DTO.BankDTO;
import com.example.bookTest.DTO.BookInfoDTO;
import com.example.bookTest.DTO.InfoDTO;

@Controller
public class StudyController {
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	@GetMapping("/infoInput")
	public ModelAndView infoInput(@ModelAttribute InfoDTO infoDTO) {
//		System.out.println(infoDTO.getUName());
		ModelAndView mav=new ModelAndView("infoInput");
//		mav=setViewName("infoInput");  // 위에서 () 공백으로 두고 이렇게 적어도 된다.
		String byear=infoDTO.getUBirth().substring(0,4);
		int age= 2024-Integer.parseInt(byear);
		mav.addObject("dataa",age);
		return mav;
	}
	@GetMapping("/write")
	public String bookWrite() {
		return "bookWrite";
	}
	@GetMapping("/detail")
	public ModelAndView bookDetail(@ModelAttribute BookInfoDTO bookInfoDTO) {
		ModelAndView mav=new ModelAndView("bookDetail");
		mav.addObject("book",bookInfoDTO);
		return mav;
	}
	@GetMapping("/input")
	public String input() {
		return "bank";
	}
	@PostMapping("/result")
	public ModelAndView result(@ModelAttribute BankDTO bankDTO) {
		ModelAndView mav=new ModelAndView("result");
		mav.addObject("bank",bankDTO);
		return mav;
	}
}
