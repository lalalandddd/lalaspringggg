package com.movieAndGame.DAO;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.movieAndGame.DTO.GameReviewDTO;

@Mapper
public interface GameReviewDAO {
	public int reviewSave(GameReviewDTO gameReviewDTO);
	public List<GameReviewDTO> findAll();
	public GameReviewDTO findById(int id);
}
