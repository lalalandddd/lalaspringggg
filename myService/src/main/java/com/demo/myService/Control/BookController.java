package com.demo.myService.Control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.demo.myService.DTO.BookDTO;
import com.demo.myService.DTO.BookSearchDTO;
import com.demo.myService.DTO.MyageDTO;
import com.demo.myService.DTO.MynameDTO;
import com.demo.myService.Service.BookService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BookController {
	private final BookService bookService;
	@GetMapping("/book")
	public String book() {
		return "book";
	}
	@GetMapping("/bookSearch")
	public String bookSearch(BookSearchDTO bookSearchDTO, Model model) {
		
		return "search";
	}
	@GetMapping("/searchkeyword")
	public String search(BookSearchDTO bookSearchDTO, Model model) {
		BookDTO book=bookService.bookSearch(bookSearchDTO);
		model.addAttribute("book",book);
		return "result";
	}
	@GetMapping("/myname")
	public String myname(MynameDTO mynameDTO, Model model) {
		return "myname";
	}
	@GetMapping("/myage")
	public String myage(MynameDTO mynameDTO, Model model){
		MyageDTO age=bookService.age(mynameDTO);
		model.addAttribute("age",age);
		return "myage";
	}
}
