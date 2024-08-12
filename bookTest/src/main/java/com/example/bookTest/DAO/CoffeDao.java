package com.example.bookTest.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.bookTest.DTO.CoffeDto;

@Repository
public class CoffeDao {
	private final JdbcTemplate jt;
	@Autowired
	public CoffeDao(JdbcTemplate jdbc) {
		this.jt=jdbc;
	}
	public void insert(CoffeDto coffeDto) {
		String sql="insert into coffe(item_name,price,decaffein) values(?,?,?)";
		jt.update(sql,coffeDto.getItemName(),coffeDto.getPrice(),coffeDto.getDecaffein());
	}
	public class CoffeDtoRowMapper implements RowMapper<CoffeDto>{
		@Override
		public CoffeDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			CoffeDto coffeDto=new CoffeDto();
			coffeDto.setItemName(rs.getString("item_name"));
			coffeDto.setPrice(rs.getInt("price"));
			coffeDto.setDecaffein(rs.getInt("decaffein"));
			coffeDto.setCoffeId(rs.getInt("coffe_id"));
			return coffeDto;
		}
	}
	public List<CoffeDto> coffee(){
		String sql="select * from coffe";
		List<CoffeDto> list=jt.query(sql, new CoffeDtoRowMapper());
		return list;
	}
	public CoffeDto findId(int id) {
		String sql="select * from coffe where coffe_id=?";
		CoffeDto coffee=jt.queryForObject(sql, new RowMapper<CoffeDto>() {
			@Override
			public CoffeDto mapRow(ResultSet rs, int rowNum) throws SQLException {
				CoffeDto dto=new CoffeDto();
				dto.setItemName(rs.getString("item_name"));
				dto.setPrice(rs.getInt("price"));
				dto.setDecaffein(rs.getInt("decaffein"));
				dto.setCoffeId(rs.getInt("coffe_id"));
				return dto;
			}
		},id);
		return coffee;
	}
	public void coffeDelete(int id) {
		String sql="delete from coffe where coffe_id=?";
		jt.update(sql,id);
	}
	public void coffeUpdate(CoffeDto coffeDto) {
		String sql="update coffe set item_name=?,price=?,decaffein=? where coffe_id=?";
		jt.update(sql,coffeDto.getItemName(),coffeDto.getPrice(),coffeDto.getDecaffein(),coffeDto.getCoffeId());
	}
}
