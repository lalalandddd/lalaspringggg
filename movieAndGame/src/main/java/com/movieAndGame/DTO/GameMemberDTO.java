package com.movieAndGame.DTO;

import lombok.Data;

@Data
public class GameMemberDTO {
	private int gameMemberId;
	private String memberId;
	private String name;
	private String nick;
	private String password;
	private String email;
	private String tel;
	private int birthYear;
	private int birthMonth;
}
