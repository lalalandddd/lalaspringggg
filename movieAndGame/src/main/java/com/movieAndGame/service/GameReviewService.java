package com.movieAndGame.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieAndGame.DAO.GameReviewDAO;
import com.movieAndGame.DTO.GameReviewDTO;

@Service
public class GameReviewService {
	@Autowired
	private GameReviewDAO gameReviewDAO;
	public void reviewSave(GameReviewDTO gameReviewDTO) {
		
	}
	
}
