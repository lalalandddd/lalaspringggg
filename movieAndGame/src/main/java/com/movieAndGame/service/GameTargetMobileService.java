package com.movieAndGame.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieAndGame.DAO.GameTargetMobileDAO;
import com.movieAndGame.DTO.GameTargetMobileDTO;

@Service
public class GameTargetMobileService {
	@Autowired
	private GameTargetMobileDAO gameTargetMbileDAO;
	public void targetSave(GameTargetMobileDTO gameTargetMoblieDTO) {
		
	}
}
