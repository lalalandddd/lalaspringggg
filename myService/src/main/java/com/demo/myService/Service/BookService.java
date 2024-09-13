package com.demo.myService.Service;

import org.springframework.stereotype.Service;

import com.demo.myService.DTO.BookDTO;
import com.demo.myService.DTO.BookSearchDTO;
import com.demo.myService.DTO.MyageDTO;
import com.demo.myService.DTO.MynameDTO;

@Service
public class BookService {
	public BookDTO bookSearch(BookSearchDTO bookSearchDTO) {  // 책제목 검색, 책 세부 내용 가져오기
		BookDTO bookDTO=BookDTO.of(bookSearchDTO.getTitle());
		return bookDTO;
	}
	public MyageDTO age(MynameDTO mynameDTO) {
		MyageDTO myageDTO=MyageDTO.of(mynameDTO.getMyname());
		return myageDTO;
	}
}
