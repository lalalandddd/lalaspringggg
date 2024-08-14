package com.movieAndGame.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieAndGame.DAO.MovieMemberDAO;
import com.movieAndGame.DTO.MovieMemberDTO;

@Service
public class MovieMemberService {
	@Autowired
	private MovieMemberDAO movieMemberDAO;
	// 회원가입 데이터베이스 저장
	public void signUpSave(MovieMemberDTO movieMemberDTO) {
		movieMemberDAO.insert(movieMemberDTO);
	}
}
