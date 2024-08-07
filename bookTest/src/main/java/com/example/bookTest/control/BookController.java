package com.example.bookTest.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.bookTest.DTO.BookInfoDTO;

@Controller
public class BookController {
	@GetMapping("/index")
	public ModelAndView home() {
		ModelAndView mav=new ModelAndView("index");
		return mav;
	}
	@GetMapping("/bookWrite")
	public ModelAndView bookWrite() {
		ModelAndView mav=new ModelAndView("book2/bookWrite");
		mav.addObject("count",5);
		return mav;
	}
	@PostMapping("/enroll")
	public String bookWrite(@ModelAttribute BookInfoDTO bookInfoDTO) {
// form 태그 안에 입력한 값은 BookInfoDTO 클래스의 객체에 저장되어있다.
// 데이터베이스에 저장하려면 DAO에 넘겨서 저장하면 된다.
// 입력값 저장 과정 : 컨트롤 -> service -> DAO
		return "index";
	}
}
