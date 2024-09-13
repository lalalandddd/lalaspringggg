package com.midProject.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.midProject.DTO.BkDTO;
import lombok.RequiredArgsConstructor;

import com.midProject.DAO.BkDAO.BkDTORowMapper;

@Repository
@RequiredArgsConstructor
public class BkDAO {
	private final JdbcTemplate jt;
//	public void save(BkDTO bkDTO) {
//		String sql="insert into bookinfo2 (btitl, burl) values (?,?)";
//		jt.update(sql, bkDTO.getBtitl(), bkDTO.getBurl());
//	}
	public void save(BkDTO bkDTO) {
		String sql="insert into test (btitl, burl) values (?,?)";
		jt.update(sql, bkDTO.getBtitl(), bkDTO.getBurl());
	}
	public class BkDTORowMapper implements RowMapper<BkDTO>{
		@Override
		public BkDTO mapRow(ResultSet rs, int rowNum) throws SQLException{
			BkDTO book=new BkDTO();
			book.setBid(rs.getInt("bid"));
			book.setBtitl(rs.getString("btitl"));
			book.setBurl(rs.getString("burl"));
			return book;
		}
	}
//	public List<BkDTO> findAll(){
//		String sql="select * from bookinfo2";
//        List<BkDTO> book=jt.query(sql, new BkDTORowMapper());
//        return book;
//	}
	public List<BkDTO> findAll(){
		String sql="select * from test";
        List<BkDTO> book=jt.query(sql, new BkDTORowMapper());
        return book;
	}
//	public BkDTO findById(int id) {
//		String sql="select * from bookinfo2 where bid=?";
//		BkDTO bkDTO=jt.queryForObject(sql, new BkDTORowMapper(),id);
//		return bkDTO;
//	}
	public BkDTO findById(int id) {
		String sql="select * from test where bid=?";
		BkDTO bkDTO=jt.queryForObject(sql, new BkDTORowMapper(),id);
		return bkDTO;
	}
	public void delete(int bid) {
		String sql="delete from test where bid=?";
		jt.update(sql,bid);
	}
//	public String getImagePath(int bid) {
//		String sql="";
//		return jt.queryForObject(sql, new Object[] {bid}, String.class);
//	}
}
