package com.example.bookTest.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.bookTest.DTO.BookInfoDTO;
import com.example.bookTest.service.BookInfoService;

@Controller
public class BookController {
	@Autowired
	private BookInfoService bookInfoService;
	@GetMapping("/index")
	public ModelAndView home() {
		ModelAndView mav=new ModelAndView("index");
		List<BookInfoDTO> list=bookInfoService.selectAll();
		mav.addObject("list",list);
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
		bookInfoService.bookSave(bookInfoDTO);
		return "redirect:/index";
	}
	@GetMapping("/book2/bookView")
	public ModelAndView view(@RequestParam(value="id", required=false, defaultValue="0") int id) {
		BookInfoDTO data=bookInfoService.getBook(id);
		if(data==null) data=new BookInfoDTO();
// getBook 메서드 반환값이 null이면 bookView.jsp 변수의 값이 null이므로 get 메서드 호출이 안 되어 오류 발생, 오류가 발생하지 않도록 빈 값이 있는 객체를 할당한다.
		return new ModelAndView("book2/bookView").addObject("book",data);
	}
	@GetMapping("/book2/bookDelete")
	public String bookDelete(@RequestParam("id") int id) {
		bookInfoService.bookDelete(id);
		return "redirect:/index";
//		return "<script>alert('삭제되었습니다.'); location.href='/index';</script>";
	}
	@GetMapping("/book2/update")
	public String bookUpdate(@ModelAttribute BookInfoDTO bookInfoDTO, @RequestParam("id") int id) {
		bookInfoDTO.setBookId(id);
		bookInfoService.bookUpdate(bookInfoDTO);
		return "redirect:/book2/bookView?id="+id;
	}
}
