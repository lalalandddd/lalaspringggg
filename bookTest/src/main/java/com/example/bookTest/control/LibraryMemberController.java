package com.example.bookTest.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.bookTest.DTO.MemberDTO;
import com.example.bookTest.service.LibraryMemberService;

@Controller
public class LibraryMemberController {
	@Autowired
	private LibraryMemberService libraryMemberService;
	@GetMapping("/signup")
	public String signup() {
		return "mytest/member/userSignup";
	}
	@PostMapping("/signup")
	public ModelAndView signup(@ModelAttribute MemberDTO memberDTO) {
		libraryMemberService.memberSave(memberDTO);
		ModelAndView mav=new ModelAndView("mytest/member/userSignupSave");
		mav.addObject("data",memberDTO);
		return mav;
	}
	@GetMapping("/memberList")
	public ModelAndView memberList() {
		ModelAndView mav=new ModelAndView("mytest/member/memberList");
		List<MemberDTO> list=libraryMemberService.selectAll();
		mav.addObject("list",list);
		return mav;
	}
	@GetMapping("/mytest/member/userView")
	public ModelAndView view(@RequestParam(value="id", required=false, defaultValue="0") int id) {
		MemberDTO member=libraryMemberService.getMember(id);
		if(member==null) member=new MemberDTO();
		return new ModelAndView("mytest/member/userView").addObject("member",member);
	}
}
