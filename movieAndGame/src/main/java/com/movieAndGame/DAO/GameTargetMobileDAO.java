package com.movieAndGame.DAO;

import org.apache.ibatis.annotations.Mapper;

import com.movieAndGame.DTO.GameTargetMobileDTO;

@Mapper
public interface GameTargetMobileDAO {
	public int targetMobileSave(GameTargetMobileDTO gameTargetMobileDTO);
}
