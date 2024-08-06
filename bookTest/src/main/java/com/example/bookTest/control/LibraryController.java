package com.example.bookTest.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.bookTest.DTO.MemberDTO;

@Controller
public class LibraryController {
	@GetMapping("/user")
	public String user() {
		return "mytest/libraryUser";
	}
	@GetMapping("/manager")
	public String manager() {
		return "mytest/libraryManager";
	}
	@GetMapping("/login")
	public String login() {
		return "mytest/member/userLogin";
	}
	@PostMapping("/login")
	public ModelAndView login(@ModelAttribute MemberDTO memberDTO) {
		ModelAndView mav=new ModelAndView("/member/userLoginCheck");
		mav.addObject("userlogin",memberDTO);
		return mav;
	}
	@GetMapping("/singup")
	public String signup() {
		return "mytest/member/userSignup";
	}
	@PostMapping("/signup")
	public ModelAndView signup(@ModelAttribute MemberDTO memberDTO) {
		ModelAndView mav=new ModelAndView("/mytest/member/userSignupSave");
		mav.addObject("data",memberDTO);
		return mav;
	}
	@GetMapping("/userSave")
	public String userSave() {
		return "mytest/member/userSave";
	}
	@GetMapping("/mLogin")
	public String mSignup() {
		return "mytest/member/managerLogin";
	}
	@GetMapping("/rental")
	public String rental() {
		return "mytest/book/rental";
	}
	@GetMapping("/back")
	public String back() {
		return "mytest/book/return";
	}
	@GetMapping("/managerMain")
	public String managerMain() {
		return "mytest/member/managerMain";
	}
	@GetMapping("/bookUp")
	public String bookUp() {
		return "mytest/book/bookUp";
	}
	@GetMapping("/bookSearch")
	public String bookSearch() {
		return "mytest/book/bookSearch";
	}
	@GetMapping("/bookRev")
	public String bookRev() {
		return "mytest/book/bookRev";
	}
	@GetMapping("/bookDel")
	public String bookDel() {
		return "mytest/book/bookDel";
	}
}
