package com.movieAndGame.DAO;

import org.apache.ibatis.annotations.Mapper;

import com.movieAndGame.DTO.MovieMemberDTO;

@Mapper
public interface MovieMemberDAO {
	public int insert(MovieMemberDTO movieMemberDTO);  // 회원가입을 위한 데이터 저장 메서드
}
