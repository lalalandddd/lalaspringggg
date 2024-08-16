package com.movieAndGame.DAO;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.movieAndGame.DTO.GameMemberDTO;

@Mapper
public interface GameMemberDAO {
	public int insert(GameMemberDTO gameMemberDTO);
	public List<String> findAllId();
	public GameMemberDTO login(GameMemberDTO gameMemberDTO);
}
