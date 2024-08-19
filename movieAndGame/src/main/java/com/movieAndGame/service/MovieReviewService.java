package com.movieAndGame.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieAndGame.DAO.MovieReviewDAO;
import com.movieAndGame.DTO.MovieReviewDTO;

@Service
public class MovieReviewService {
	@Autowired
	private MovieReviewDAO movieReviewDAO;
	public List<MovieReviewDTO> reviewlist(){
		return movieReviewDAO.findAll();
	}
	public void reviewSave(MovieReviewDTO movieReviewDTO) {
		if(movieReviewDTO!=null) {
			movieReviewDAO.reviewSave(movieReviewDTO);
		}
	}
	public MovieReviewDTO findById(int id) {
		return movieReviewDAO.findById(id);
	}
}
