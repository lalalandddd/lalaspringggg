package com.movieAndGame.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieAndGame.DAO.GameReviewDAO;
import com.movieAndGame.DTO.GameReviewDTO;

@Service
public class GameReviewService {
	@Autowired
	private GameReviewDAO gameReviewDAO;
	public List<GameReviewDTO> reviewlist(){
		return gameReviewDAO.findAll();
	}
	public void reviewSave(GameReviewDTO gameReviewDTO) {
		gameReviewDAO.reviewSave(gameReviewDTO);
	}
	public GameReviewDTO findById(int id) {
		return gameReviewDAO.findById(id);
	}
}
