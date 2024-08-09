package com.example.bookTest.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.bookTest.DTO.BookInfoDTO;

@Repository
public class BookDAO {
	private final JdbcTemplate jt;
	@Autowired
	public BookDAO(JdbcTemplate jdbcTemplate) {
		this.jt=jdbcTemplate;
	}
	public void insert(BookInfoDTO bookInfoDTO) {  // 도서정보를 데이터베이스(BookInfoDTO)에 저장
		String sql="insert into studysite_book(book_title, book_writer, book_price, book_allpage, book_publisher, book_volume, book_subtitle, book_code, book_sort, book_content) values(?,?,?,?,?,?,?,?,?,?)";
		jt.update(sql,bookInfoDTO.getBookTitle(),bookInfoDTO.getBookWriter(),bookInfoDTO.getBookPrice(),bookInfoDTO.getBookAllpage(),bookInfoDTO.getBookPublisher(),bookInfoDTO.getBookVolume(),bookInfoDTO.getBookSubtitle(),bookInfoDTO.getBookCode(),bookInfoDTO.getBookSort(),bookInfoDTO.getBookContent());
	}
	public class BookInfoDTORowMapper implements RowMapper<BookInfoDTO>{
		@Override
		public BookInfoDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
			BookInfoDTO bookInfoDTO=new BookInfoDTO();
			bookInfoDTO.setBookWriter(rs.getString("book_writer"));
			bookInfoDTO.setBookPrice(rs.getInt("book_price"));
			bookInfoDTO.setBookAllpage(rs.getInt("book_allpage"));
			bookInfoDTO.setBookCode(rs.getString("book_code"));
			bookInfoDTO.setBookSort(rs.getString("book_sort"));
			bookInfoDTO.setBookTitle(rs.getString("book_title"));
			bookInfoDTO.setBookVolume(rs.getInt("book_volume"));
			bookInfoDTO.setBookSubtitle(rs.getString("book_subtitle"));
			bookInfoDTO.setBookPublisher(rs.getString("book_publisher"));
			bookInfoDTO.setBookContent(rs.getString("book_content"));
			bookInfoDTO.setBookId(rs.getInt("book_id"));
			return bookInfoDTO;
		}
	}
// book(studysite_book) 테이블 전체 데이터 가져오기 - 첫화면에 목록 출력을 위해서
// 페이징도 없고, 보낼 데이터도 없다.
	public List<BookInfoDTO> select(){
		String sql="select * from studysite_book";
		List<BookInfoDTO> list=jt.query(sql, new BookInfoDTORowMapper());
		return list;
	}
// 도서 상세 정보 가져오기 - 클릭한 1권에 대해서만! (book_id 컬럼으로 조회)
// book_id 컬럼이 중복데이터를 가질 수 없는 유일값이기 때문에 가능함
	public BookInfoDTO findId(int id){
		String sql="select * from studysite_book where book_id=?";
// jt.queryForObject(쿼리문, mapper, ?에 넣어줄 값)
		BookInfoDTO data=jt.queryForObject(sql,new RowMapper<BookInfoDTO>() {
			@Override  // 위에 익명클래스를 오버라이드 했으므로 클래스 이름을 가져오는 것만 해도 되지만 공부를 위해 모두 쳐 봤다...
			public BookInfoDTO mapRow(ResultSet rs, int rowNum) throws SQLException{
				BookInfoDTO dto=new BookInfoDTO();
				dto.setBookWriter(rs.getString("book_writer"));
				dto.setBookPrice(rs.getInt("book_price"));
				dto.setBookAllpage(rs.getInt("book_allpage"));
				dto.setBookCode(rs.getString("book_code"));
				dto.setBookSort(rs.getString("book_sort"));
				dto.setBookTitle(rs.getString("book_title"));
				dto.setBookVolume(rs.getInt("book_volume"));
				dto.setBookSubtitle(rs.getString("book_subtitle"));
				dto.setBookPublisher(rs.getString("book_publisher"));
				dto.setBookContent(rs.getString("book_content"));
				dto.setBookId(rs.getInt("book_id"));
				return dto;
			}
		} ,id);
		return data;
	}
	public void bookDelete(int id) {
		String sql="delete from studysite_book where book_id=?";
		jt.update(sql,id);
	}
// 수정 정보를 데이터베이스에 저장하기
	public void bookUpdate(BookInfoDTO bookInfoDTO) {
		String sql="update studysite_book set book_title=?, book_writer=?, book_price=?, book_allpage=?, book_publisher=?, book_volume=?, book_subtitle=?, book_code=?, book_sort=?, book_content=? where book_id=?";
		jt.update(sql,bookInfoDTO.getBookTitle(),bookInfoDTO.getBookWriter(),bookInfoDTO.getBookPrice(),bookInfoDTO.getBookAllpage(),bookInfoDTO.getBookPublisher(),bookInfoDTO.getBookVolume(),bookInfoDTO.getBookSubtitle(),bookInfoDTO.getBookCode(),bookInfoDTO.getBookSort(),bookInfoDTO.getBookContent(),bookInfoDTO.getBookId());
	}
}
