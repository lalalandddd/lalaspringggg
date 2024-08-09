package com.example.bookTest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookTest.DAO.BookDAO;
import com.example.bookTest.DTO.BookInfoDTO;

@Service
public class BookInfoService {
	private final BookDAO bookDAO;
	@Autowired
	public BookInfoService(BookDAO bookDAO) {
		this.bookDAO=bookDAO;
	}
	public void bookSave(BookInfoDTO bookInfoDTO) {
		if(bookInfoDTO!=null) {  // 도서 코드가 이미 데이터베이스에 저장되어있는지 확인 후 저장
			bookDAO.insert(bookInfoDTO);  // DAO 클래스의 insert 메서드 실행해서 저장
		}
	}
// 도서정보 전체 데이터베이스에서 가져와서 List에 저장되어있는거 받아서 control에게 넘겨주기
	public List<BookInfoDTO> selectAll(){
		return bookDAO.select();
	}
// 도서 상세 정보 가져오기 : id 파라미터 값의 DAO를 넘겨서 조회하고 결과 받아서 control에 넘기기
	public BookInfoDTO getBook(int id) {
		if(id!=0) {  // id 파라미터의 값이 존재한다면 DAO를 통해 조회
			return bookDAO.findId(id);
		}
		return null;  // id 파라미터 없이 /book2/bookView 주소 요청 들어온다면 null값 반환
	}
// 도서 삭제
	public void bookDelete(int id) {
		bookDAO.bookDelete(id);
	}
// 도서 정보 변경
	public void bookUpdate(BookInfoDTO bookInfoDTO) {
		bookDAO.bookUpdate(bookInfoDTO);
	}
}
