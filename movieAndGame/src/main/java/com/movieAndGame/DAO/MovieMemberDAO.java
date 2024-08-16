package com.movieAndGame.DAO;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.movieAndGame.DTO.MovieMemberDTO;

@Mapper
public interface MovieMemberDAO {
	public int insert(MovieMemberDTO movieMemberDTO);  // 회원가입 데이터 저장
	public List<String> findAllId();
	public MovieMemberDTO login(MovieMemberDTO movieMemberDTO);  // 로그인 처리 메서드
}
