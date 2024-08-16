package com.movieAndGame.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieAndGame.DAO.MovieReviewDAO;
import com.movieAndGame.DTO.MovieReviewDTO;

@Service
public class MovieReviewService {
	@Autowired
	private MovieReviewDAO movieReviewDAO;
	public void reviewSave(MovieReviewDTO movieReviewDTO) {
		
	}
}
