package com.example.test2.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.test2.DTO.BoardDTO;

@Controller
public class BoardController {
	@GetMapping("/board")
	public ModelAndView board() {
//		String title="여기는 게시판 입니까?";
		ModelAndView mav=new ModelAndView();
		mav.setViewName("board/boardList");
		return mav;
	}
	@GetMapping("/boardWrite")
	public String boardWrite() {
		return "board/boardWrite";
	}
	@PostMapping("/boardWrite")
	public ModelAndView boardView(@ModelAttribute BoardDTO boardDTO) {
		ModelAndView mav=new ModelAndView("/board/boardView");
		mav.addObject("data",boardDTO);
		return mav;
	}
}
