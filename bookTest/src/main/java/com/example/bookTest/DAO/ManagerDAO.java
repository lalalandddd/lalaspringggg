package com.example.bookTest.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ManagerDAO {
	private final JdbcTemplate jt;
	@Autowired
	public ManagerDAO(JdbcTemplate jdbcTemplate) {
		this.jt=jdbcTemplate;
	}
}
