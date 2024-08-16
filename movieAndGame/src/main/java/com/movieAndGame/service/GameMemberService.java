package com.movieAndGame.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieAndGame.DAO.GameMemberDAO;
import com.movieAndGame.DTO.GameMemberDTO;

@Service
public class GameMemberService {
	@Autowired
	private GameMemberDAO gameMemberDAO;
	public boolean signUpSave(GameMemberDTO gameMemberDTO) {
		List<String> memberIdList=gameMemberDAO.findAllId();
		if(memberIdList.contains(gameMemberDTO.getMemberId())) return true;
		gameMemberDAO.insert(gameMemberDTO);
		return false;
	}
	public GameMemberDTO login(GameMemberDTO gameMemberDTO) {
		return gameMemberDAO.login(gameMemberDTO);
	}
}
