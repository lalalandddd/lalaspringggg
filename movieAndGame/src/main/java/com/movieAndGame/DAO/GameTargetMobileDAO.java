package com.movieAndGame.DAO;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.movieAndGame.DTO.GameTargetMobileDTO;

@Mapper
public interface GameTargetMobileDAO {
	public int postSave(GameTargetMobileDTO gameTargetMobileDTO);
	public List<GameTargetMobileDTO> findAll();
	public GameTargetMobileDTO findById(int id);
}
