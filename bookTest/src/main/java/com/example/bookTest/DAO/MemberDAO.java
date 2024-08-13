package com.example.bookTest.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.bookTest.DTO.MemberDTO;

@Repository
public class MemberDAO {
	private final JdbcTemplate jt;
	@Autowired
	public MemberDAO(JdbcTemplate jdbcTemplate) {
		this.jt=jdbcTemplate;
	}
	public void insert(MemberDTO memberDTO) {
		String sql="insert into library_member(user_id,user_pw,user_name,user_email,user_tel,user_address,user_birth) values(?,?,?,?,?,?,?)";
		jt.update(sql,memberDTO.getUserId(),memberDTO.getUserPw(),memberDTO.getUserName(),memberDTO.getUserEmail(),memberDTO.getUserTel(),memberDTO.getUserAddress(),memberDTO.getUserBirth());
	}
	public class MemberDTORowMapper implements RowMapper<MemberDTO>{
		@Override
		public MemberDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
			MemberDTO memberDTO=new MemberDTO();
			memberDTO.setUserNb(rs.getInt("user_nb"));
			memberDTO.setUserId(rs.getString("user_id"));
			memberDTO.setUserPw(rs.getString("user_pw"));
			memberDTO.setUserName(rs.getString("user_name"));
			memberDTO.setUserEmail(rs.getString("user_email"));
			memberDTO.setUserTel(rs.getString("user_tel"));
			memberDTO.setUserAddress(rs.getString("user_address"));
			memberDTO.setUserBirth(rs.getString("user_birth"));
			return memberDTO;
		}
	}
	public List<MemberDTO> select(){
		String sql="select * from library_member";
		List<MemberDTO> list=jt.query(sql, new MemberDTORowMapper());
		return list;
	}
	public MemberDTO findNb(int id) {
		String sql="select * from library_member where user_nb=?";
//		MemberDTO data=jt.queryForObject(sql,new RowMapper<MemberDTO>() {
//			@Override
//			public MemberDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
//				MemberDTO memberDTO=new MemberDTO();
//				memberDTO.setUserNb(rs.getInt("user_nb"));
//				memberDTO.setUserId(rs.getString("user_id"));
//				memberDTO.setUserPw(rs.getString("user_pw"));
//				memberDTO.setUserName(rs.getString("user_name"));
//				memberDTO.setUserEmail(rs.getString("user_email"));
//				memberDTO.setUserTel(rs.getString("user_tel"));
//				memberDTO.setUserAddress(rs.getString("user_address"));
//				memberDTO.setUserBirth(rs.getString("user_birth"));
//				return memberDTO;
//			}
//		},nb);   // 여기 쓴 부분이 아래 한줄로 정리 끗
		MemberDTO data=jt.queryForObject(sql,new MemberDTORowMapper(),id);
		return data;
	}
	public void memberDelete(int id) {
		String sql="delete from library_member where user_nb=?";
		jt.update(sql,id);
	}
	public void memberUpdate(MemberDTO memberDTO) {
		String sql="update library_member set user_id=?, user_pw=?, user_name=?, user_email=?, user_tel=?, user_address=?, user_birth=? where user_nb=?";
		jt.update(sql,memberDTO.getUserId(),memberDTO.getUserPw(),memberDTO.getUserName(),memberDTO.getUserEmail(),memberDTO.getUserTel(),memberDTO.getUserAddress(),memberDTO.getUserBirth(),memberDTO.getUserNb());
	}
}
