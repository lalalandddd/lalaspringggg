package com.movieAndGame.control;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movieAndGame.DTO.MovieMemberDTO;
import com.movieAndGame.DTO.MovieReviewDTO;
import com.movieAndGame.service.MovieReviewService;

@Controller
@RequestMapping("/movieReview")
public class MovieMenuController {
	@Autowired
	private MovieReviewService movieReviewService;
	@GetMapping("/review")
	public String reviewMain(Model model) {
		return "movie/review/index";
	}
	@GetMapping("/reviewWrite")
	public String reviewWrite(Model model, HttpSession session) {
		if(session.getAttribute("user")==null) {  // 로그인 상태가 아니다?
			return "redirect:/movie/member/login";  // 로그인 페이지로 가라
		}
		MovieReviewDTO dto=new MovieReviewDTO();
		String name=((MovieMemberDTO)session.getAttribute("user")).getMemberId();
		dto.setWriter(name);
		model.addAttribute("movieReviewDTO",dto);
		return "movie/review/reviewWrite";
	}
	@GetMapping("/write")
	public String movieReviewWrite(@Valid MovieReviewDTO movieReviewDTO, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "movie/review/reviewWrite";
		}
		movieReviewService.reviewSave(movieReviewDTO);
		return "redirect:/movie/review/index";
	}
}
