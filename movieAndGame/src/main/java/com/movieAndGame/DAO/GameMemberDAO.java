package com.movieAndGame.DAO;

import org.apache.ibatis.annotations.Mapper;

import com.movieAndGame.DTO.GameMemberDTO;

@Mapper
public interface GameMemberDAO {
	public int insert(GameMemberDTO gameMemberDTO);
}
