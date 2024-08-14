package com.movieAndGame.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieAndGame.DAO.GameMemberDAO;
import com.movieAndGame.DTO.GameMemberDTO;

@Service
public class GameMemberService {
	@Autowired
	private GameMemberDAO gameMemberDAO;
	public void signUpSave(GameMemberDTO gameMemberDTO) {
		gameMemberDAO.insert(gameMemberDTO);
	}
}
