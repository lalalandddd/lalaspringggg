package com.midProject.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.midProject.DTO.BkDTO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BkDAO {
	private final JdbcTemplate jt;
	public void save(BkDTO bkDTO) {
		String sql = "insert into test (btitl, burl) values (?, ?)";
		jt.update(sql, bkDTO.getBtitl(), bkDTO.getBurl());
	}
	private static class BkDTORowMapper implements RowMapper<BkDTO> {
		@Override
		public BkDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
			BkDTO book = new BkDTO();
			book.setBid(rs.getInt("bid"));
			book.setBtitl(rs.getString("btitl"));
			book.setBurl(rs.getString("burl"));
			return book;
		}
	}
	public List<BkDTO> findAll() {
		String sql = "select * from test order by bid desc";
		return jt.query(sql, new BkDTORowMapper());
	}
	public BkDTO findById(int bid) {
		String sql = "select * from test where bid=?";
		return jt.queryForObject(sql, new BkDTORowMapper(), bid);
	}
	public void delete(int bid) {
		String sql = "delete from test where bid=?";
		jt.update(sql, bid);
	}
	public void update(BkDTO bkDTO) {
		String sql="update test set btitl=?, burl=? where bid=?";
		jt.update(sql, bkDTO.getBtitl(), bkDTO.getBurl(), bkDTO.getBid());
	}
}
