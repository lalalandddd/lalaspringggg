package com.movieAndGame.DAO;

import org.apache.ibatis.annotations.Mapper;

import com.movieAndGame.DTO.MovieReviewDTO;

@Mapper
public interface MovieReviewDAO {
	public int reviewSave(MovieReviewDTO movieReviewDTO);
}
