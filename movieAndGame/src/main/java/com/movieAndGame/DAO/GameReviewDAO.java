package com.movieAndGame.DAO;

import org.apache.ibatis.annotations.Mapper;

import com.movieAndGame.DTO.GameReviewDTO;

@Mapper
public interface GameReviewDAO {
	public int reviewSave(GameReviewDTO gameReviewDTO);
}
