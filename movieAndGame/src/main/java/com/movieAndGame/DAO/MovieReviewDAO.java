package com.movieAndGame.DAO;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.movieAndGame.DTO.MovieReviewDTO;

@Mapper
public interface MovieReviewDAO {
	public int reviewSave(MovieReviewDTO movieReviewDTO);
	// 전체 데이터 가져오기
	public List<MovieReviewDTO> findAll();
	public MovieReviewDTO findById(int id);
}
