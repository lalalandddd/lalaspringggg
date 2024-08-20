package com.movieAndGame.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieAndGame.DAO.GameTargetMobileDAO;
import com.movieAndGame.DTO.GameTargetMobileDTO;

@Service
public class GameTargetMobileService {
	@Autowired
	private GameTargetMobileDAO gameTargetMobileDAO;
	public void postSave(GameTargetMobileDTO gameTargetMobileDTO) {
		gameTargetMobileDAO.postSave(gameTargetMobileDTO);
	}
	public List<GameTargetMobileDTO> targetList(){
		return gameTargetMobileDAO.findAll();
	}
	public GameTargetMobileDTO findById(int id) {
		return gameTargetMobileDAO.findById(id);
	}
}
