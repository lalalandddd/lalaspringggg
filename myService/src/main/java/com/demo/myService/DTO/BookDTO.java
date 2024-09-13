package com.demo.myService.DTO;

import lombok.Data;

@Data
public class BookDTO {
	private String title;
	private String writer;
	private int year;
	private int page;
	
	public static BookDTO of(String title) {  // Entity 객체 → DTO
		BookDTO bookDTO=new BookDTO();
		bookDTO.setTitle(title);
		bookDTO.setWriter("박문수");
		bookDTO.setYear(2024);
		bookDTO.setPage(234);
		return bookDTO;
	}
}
